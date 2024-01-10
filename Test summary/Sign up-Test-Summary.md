# [Anyway] Report

Type of whole test: Statement Complete


*The features test: Basic Part——sign——no input the username or password
*Test when we sign up, don't input username, the emulator will show expected message or not
*Test when we sign up, input the username without the password,the emulator will show expected message or not

*Number of test cases:2

*The code coverage:

    public void onClick(View view)
    {
     if(userName.getText().toString().equals(""))
    {
      Toast.makeText(getApplicationContext(),"Please type in the username.",Toast.LENGTH_LONG).show();
     }else if ( password.getText().toString().equals(""))
     {
        Toast.makeText(getApplicationContext(),"Please type in the password.",Toast.LENGTH_LONG).show();
     }

    else{
      createUser(userName.getText().toString(),
       password.getText().toString());
                
    }
            
    }


* the screenshot:
* the first is signing up without inputting username:https://gitlab.cecs.anu.edu.au/u7323052/comp2100-6442-group-project-2022.s1/-/blob/master/Screenshot%20of%20Test/SignupTest/no%20input%20the%20username%20Test.png
* the second is signing up without inputting passwords:https://gitlab.cecs.anu.edu.au/u7323052/comp2100-6442-group-project-2022.s1/-/blob/master/Screenshot%20of%20Test/SignupTest/no%20input%20the%20password%20Test.png





*The features test: Basic Part——sign—— input the username  with password and test it can login or not

*Test when we sign up,input the username and password regularly, if the emulator will show the expected message 
*Test the user signed can be used to login or not

*Number of test cases:1

*The code coverage:

      private void createUser(String name, String pass){
          OrdinaryUser usr = new OrdinaryUser();
          usr.setName(name);
          usr.setPassword(pass);


    else
    {
    userDao.addUser(usr);
    userDao.delLogin();
    userDao.saveLogin(name);
    Toast.makeText(getApplicationContext(),"Registration successful, going to the main page",Toast.LENGTH_LONG).show();
     Intent i = new Intent(getApplicationContext(), HomepageActivity.class);
     i.putExtra("name",name);
     startActivity(i);

        }

    }
    }

     }

     }

* the screenshot:https://gitlab.cecs.anu.edu.au/u7323052/comp2100-6442-group-project-2022.s1/-/blob/master/Screenshot%20of%20Test/SignupTest/sign%20up%20suceessfully%20Test.png
* by the screenshot, if we sign up successfully, it will show "Registration successful, going to the main page" and go to the main page automatically.






*The features test: Basic Part——sign—— sign up the existed user Test.


*Test if we sign up a existed user, it will show message on the emulator or not.

*Number of test cases:1

*The code coverage:

          private void createUser(String name, String pass)
    { 
        OrdinaryUser usr = new OrdinaryUser();
        usr.setName(name);
        usr.setPassword(pass);
    if(userDao.searchUserByName(name)!= null)
    {
     Toast.makeText(getApplicationContext(),"User already exist",Toast.LENGTH_LONG).show();
    }

* the screenshot:https://gitlab.cecs.anu.edu.au/u7323052/comp2100-6442-group-project-2022.s1/-/blob/master/Screenshot%20of%20Test/SignupTest/sign%20up%20the%20existed%20user%20Test.png
* from it,we can know we can not sign up the existed user.



