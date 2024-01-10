# [Anyway] Report

Type of whole test: Statement Complete


*The features test: Privacy——Users may send adding friends requests which are then accepted or denied



*Test if user can add other users normarlly by searching

*the first user(username:testuser2) try to send adding friends requests to the second user(username:testuser)

*test the testuser can receive the request or not, if he can receive it and accept the request, then test if he will appear at the friend lists of testuser2


*Number of test cases:1

*The code coverage:

      protected void onCreate(Bundle savedInstanceState) 
      {
      super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_check_apply);


        initViews();
        userDao = new UserDaoImpl(getApplicationContext());

        // get username
        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        this.username = userDao.readLogin();
        //get all applys
        applys.addAll(userDao.findApply(username));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.list_view,applys);
        applyListViews.setAdapter(arrayAdapter);

        applyListViews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String apply = applys.get(i);

                //create dialog to notify user whether to add friend by click an item in listview
                AlertDialog.Builder  builder= new AlertDialog.Builder(CheckApplyActivity.this);
                builder.setTitle("Add friend");
                builder.setMessage("Do you want to add "+apply+ "as your friend?");
                builder.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        userDao.accApply(apply, username);

                        startActivity(new Intent(CheckApplyActivity.this, CheckApplyActivity.class));
                        finish();
                    }
                });

                builder.setNegativeButton("Refuse", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        userDao.rejectApply(apply, username);
                        startActivity(new Intent(CheckApplyActivity.this, CheckApplyActivity.class));
                        finish();
                    }
                });
                //build dialog according to the builder
                AlertDialog dialog = builder.create();
                dialog.show();


            }
        });

    }


       private void add()
     {
        OrdinaryUser friend = userDao.searchUserByName(name.getText().toString());



     else{
            userDao.addFriend(username,name.getText().toString());
            Toast.makeText(getApplicationContext(),"Successful add",Toast.LENGTH_LONG).show();
     }


    }

* the screenshot:https://gitlab.cecs.anu.edu.au/u7323052/comp2100-6442-group-project-2022.s1/-/blob/master/Screenshot%20of%20Test/AddFriendsTest/Check%20add%20friends%20normally%20Test.png
* 
* by the screenshot, if we search the right user,we can send the request and if he accept it, he will become our friend.





*The features test: Privacy——Users may send adding friends requests which are then accepted or denied.

*Test if you can add yourself .
*Test if you can add your friends repeatably
*Test if you can add friends without inputting the username

*Number of test cases:3

*The code coverage:

      private void createUser(String name, String pass)
      {
       if(friend == null)
      {
        Toast.makeText(getApplicationContext(),"No users named "+name.getText().toString(),Toast.LENGTH_LONG).show();

       OrdinaryUser friend = userDao.searchUserByName(name.getText().toString());

        if(friend == null)
        {
            Toast.makeText(getApplicationContext(),"No users named "+name.getText().toString(),Toast.LENGTH_LONG).show(); }
        }
         else if(userDao.searchApplyByName(username,name.getText().toString()))
        {
            Toast.makeText(getApplicationContext(),"Already send application to "+name.getText().toString(),Toast.LENGTH_LONG).show();
        }
        else if(name.getText().toString().equals(username))
        {
            Toast.makeText(getApplicationContext(),"Can not add yourself",Toast.LENGTH_LONG).show();
        }
        else if(name.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Please enter the name of your friend",Toast.LENGTH_LONG).show();
        }


* the screenshot:
* the first is adding yourself:https://gitlab.cecs.anu.edu.au/u7323052/comp2100-6442-group-project-2022.s1/-/blob/master/Screenshot%20of%20Test/AddFriendsTest/Add%20yourself%20as%20friend%20Test.png
* the scond is adding your friend repeatably:https://gitlab.cecs.anu.edu.au/u7323052/comp2100-6442-group-project-2022.s1/-/blob/master/Screenshot%20of%20Test/AddFriendsTest/Add%20the%20Friends%20repeatably%20Test.png
* the third is adding the null username:https://gitlab.cecs.anu.edu.au/u7323052/comp2100-6442-group-project-2022.s1/-/blob/master/Screenshot%20of%20Test/AddFriendsTest/Add%20null%20username%20Test.png




