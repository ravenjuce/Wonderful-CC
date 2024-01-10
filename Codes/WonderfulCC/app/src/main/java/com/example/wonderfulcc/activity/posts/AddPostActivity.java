package com.example.wonderfulcc.activity.posts;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.wonderfulcc.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author Wangyi Li
 */
public class AddPostActivity extends AppCompatActivity {
    private ImageView imageViewAddImage;
    private EditText editTextAddTitle, editTextAddDescription, editTextTag;
    private Button buttonSave;

    ActivityResultLauncher<Intent> activityResultLauncherForSelectImage;

    private Bitmap selectedImage;
    private Bitmap scaledImage;
    //private RadioGroup mRadioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Add Post");
        setContentView(R.layout.activity_add_post);

        // register activity for selecting image
        registerActivityForSelectImage();

        imageViewAddImage = findViewById(R.id.imageViewAddImage);
        editTextAddTitle = findViewById(R.id.editTextAddTitle);
        editTextAddDescription = findViewById(R.id.editTextAddDescription);
        editTextTag =findViewById(R.id.editTextTag);
        buttonSave = findViewById(R.id.buttonSave);
        //mRadioGroup = findViewById(R.id.mRadioGroup);

        // set addImage click
        /**
         * @reference https://www.udemy.com/course/full-android-11-masterclass-course-with-java-53-hours/learn/lecture/27266194#overview
         */
        imageViewAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(AddPostActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    // ask for permission
                    // set request code. By using this code, we will be able to take the necessary action after the user gives the consent
                    ActivityCompat.requestPermissions(AddPostActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                } else {
                    // using intent to access the media folder
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                    /** tips: activityResultLauncher <- startActivityForResult
                     * start the intent but not use startActivity() method
                     * this intent operation will have a result and we need to follow this result
                     * if the user select an image or not, we need to take the selected image and display it in the image view
                     * startActivityForResult --> before API 30
                     * ActivityResultLauncher --> now (first create an object form the ActivityResultLauncher class in the global area
                     */
                    activityResultLauncherForSelectImage.launch(intent);
                }
            }
        });

        // set save click
        /**
         * @reference https://www.udemy.com/course/full-android-11-masterclass-course-with-java-53-hours/learn/lecture/27266194#overview
         */
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedImage == null) {
                    // if the user doesn't select an image
                    Toast.makeText(AddPostActivity.this, "Please select an image!", Toast.LENGTH_SHORT).show();
                } else {
                    //get visible status
                    /*String postIsVisible = "0";
                    switch (mRadioGroup.getCheckedRadioButtonId()) {
                        case R.id.mRadioButton01:
                            postIsVisible = "0";
                            break;
                        case R.id.mRadioButton02:
                            postIsVisible = "1";
                            break;
                    }*/

                    // transfer the data in the editText component to the variables
                    String title = editTextAddTitle.getText().toString();
                    String description = editTextAddDescription.getText().toString();
                    String tag = editTextTag.getText().toString();

                    // convert image to byte type for it can't transfer the image directly to the variables
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    // the images going to save to the SQLite database should be small in size the ways the application is going to crash
//                    selectedImage.compress(Bitmap.CompressFormat.PNG, 50, outputStream);
                    scaledImage = makeSmall(selectedImage, 800);
                    scaledImage.compress(Bitmap.CompressFormat.PNG, 50, outputStream);
                    // convert the image into byte array
                    byte[] image = outputStream.toByteArray();

                    // save data to database
                    // send the data in the variables to the MainActivity using intent
                    Intent intent = new Intent();
                    // sent the data use put extra method
                    intent.putExtra("title", title);
                    intent.putExtra("description", description);
                    intent.putExtra("tag", tag);
                    intent.putExtra("image", image);
                    //intent.putExtra("postIsVisible", postIsVisible);
                    // start the intent using setResult() method
                    setResult(RESULT_OK, intent);
                    finish();
                    // gonna get the data in the onActivityResult() in MainActivity
                }
            }
        });
    }

    // register activity for selecting image
    public void registerActivityForSelectImage() {
        activityResultLauncherForSelectImage = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        int resultCode = result.getResultCode();
                        Intent data = result.getData();

                        if (resultCode == RESULT_OK && data != null) {
                            try {
                                // convert the selected image to bitmap object
                                selectedImage = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
                                imageViewAddImage.setImageBitmap(selectedImage);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
    }

    // check the result of the permission we requested from the user

    /**
     * @reference https://www.udemy.com/course/full-android-11-masterclass-course-with-java-53-hours/learn/lecture/27266194#overview
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            activityResultLauncherForSelectImage.launch(intent);
        }
    }

    /** create a bitmap type method that returns a scaled image
     *  this method going to take a picture of the bitmap height & max size object of the integer type of the parameter
     * @param image
     * @param maxSize
     * @return a scaled image (bitmap)
     * @reference https://www.udemy.com/course/full-android-11-masterclass-course-with-java-53-hours/learn/lecture/27266194#overview
     */
    public Bitmap makeSmall(Bitmap image, int maxSize) {
        // transfer the width and the height of the image into the variables
        int width = image.getWidth();
        int height = image.getHeight();

        // get a reduction ratio
        float ratio = (float) width / (float) height;

        if (ratio > 1) { // width > height
            width = maxSize;
            height = (int) (width / ratio);
        } else {
            height = maxSize;
            width = (int) (height * ratio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }

}