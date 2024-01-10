package com.example.wonderfulcc.activity.posts;

import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wonderfulcc.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wangyi Li
 */
public class MyPostsAdapter extends RecyclerView.Adapter<MyPostsAdapter.MyPostsHolder> {
    // transfer data from database
    List<MyPosts> postsList = new ArrayList<>();

    // add a click feature to the recyclerView component
    // create an object from the on imageClickListener interface.
    private OnPostClickListener listener;
    public void setListener(OnPostClickListener listener) {
        this.listener = listener;
    }

    // create an interface to activate the click feature
    public interface OnPostClickListener {
        // create a method without a body and interface
        void onPostClick(MyPosts myPosts);
    }

    public void setPostsList(List<MyPosts> postsList) {
        this.postsList = postsList;
        // user setter to update data show the changes in database
        notifyDataSetChanged();
    }

    // get the MyPosts object with the adapter position
    public MyPosts getPosition(int position) {
        return postsList.get(position);
    }


    @NonNull
    @Override
    public MyPostsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // ViewGroup represents the recycleView components
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_card, parent, false);
        return new MyPostsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyPostsHolder holder, int position) {
        MyPosts myPosts = postsList.get(position);
        // print the data on the components using the holder object
        holder.textViewUsername.setText(myPosts.getUsername());
        holder.textViewTitle.setText(myPosts.getPost_title());
        holder.textViewDescription.setText(myPosts.getPost_description());
        holder.textViewTag.setText(myPosts.getPost_tag());
        holder.imageView.setImageBitmap(BitmapFactory.decodeByteArray(myPosts.getImage(), 0, myPosts.getImage().length));
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }


    public class MyPostsHolder extends RecyclerView.ViewHolder {
        // define the component of post_card design
        ImageView imageView;
        TextView textViewTitle, textViewDescription, textViewTag, textViewUsername;

        public MyPostsHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textViewUsername = itemView.findViewById(R.id.textViewUsername);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            textViewTag = itemView.findViewById(R.id.textViewTag);

            // add a click listener to the CardView
            /**
             * @reference https://www.udemy.com/course/full-android-11-masterclass-course-with-java-53-hours/learn/lecture/27266194#overview
             */
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // the location of information in the adapter
                    int position = getAdapterPosition();

                    // if the listener object is not null & no empty space is clicked in the recycler view component
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onPostClick(postsList.get(position));
                    }
                }
            });
        }
    }
}
