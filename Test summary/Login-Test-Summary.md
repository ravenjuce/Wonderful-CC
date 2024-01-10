# [Anyway] Report


Type of whole test: Statement Complete

*The features test: Basic Part——login——null user input test

*Test if we input the null for username or password, it will show the expected message on the emulator by toast
*Test if we input some username with password which is not signed, it will show the expected messages on the emulator by toast



*Number of test cases:2

*The code coverage:

    private void login (String name, String password)
    {
      OrdinaryUser user = userDao.searchUserByName(name);
      if (user==null)
     {
     Toast.makeText(getApplicationContext(),"Please sign up first.",Toast.LENGTH_LONG).show();
     }
     }
* the screenshot:
* the first is testing if we input null username or password:https://gitlab.cecs.anu.edu.au/u7323052/comp2100-6442-group-project-2022.s1/-/blob/master/Screenshot%20of%20Test/LoginTest/input%20null%20username%20Test.png
* the second is testing if we login with some unsigned username:https://gitlab.cecs.anu.edu.au/u7323052/comp2100-6442-group-project-2022.s1/-/blob/master/Screenshot%20of%20Test/LoginTest/user%20name%20is%20unsigned%20Test.png





*The features test: Basic Part——login——right/wrong  user input test

*Test if we input the correct username or password, it will show the expected message on the emulator or not by toast
*test if we input the wrong username or password,it will show t will show the expected message on the emulator or not by toast
*Number of test cases:2
*one case is the right user, the other one is user with wrong password

*The code coverage:

        private void login (String name, String password)
         {
          OrdinaryUser user = userDao.searchUserByName(name);

     else if(user.getPassword().equals(password))
      {
            userDao.delLogin();

            userDao.saveLogin(name);
            Toast.makeText(getApplicationContext(),"Get started.",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), HomepageActivity.class);
            intent.putExtra("name",user.getName());
            startActivity(intent);
      }
        else{
         Toast.makeText(getApplicationContext(),"Please enter the correct password.",Toast.LENGTH_LONG).show();
      }
    }


* the screenshot:
* input with correct username and password:https://gitlab.cecs.anu.edu.au/u7323052/comp2100-6442-group-project-2022.s1/-/tree/master/Screenshot%20of%20Test/LoginTest
* input with wrong username and password:https://gitlab.cecs.anu.edu.au/u7323052/comp2100-6442-group-project-2022.s1/-/blob/master/Screenshot%20of%20Test/LoginTest/uncorrect%20password%20input%20Test.png
