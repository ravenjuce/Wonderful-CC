# [Anyway] Report

Type of whole test: Statement Complete


*The features test: User Interactivity——The ability to ‘follow’ users, events, movements, hashtags, topics.


*Test if user can be followed successfully.(to see the following list after user was followed by other users)

*the first user(username:testuser4) try to follow the other user(username:testuser),check if the testuser can see the testuser4 or not at the following list

*Number of test cases:1

*The code coverage:

     public void onClick(View view) 
     {
     if (myUsername.equals(postUsername))
     {
      Toast.makeText(getApplicationContext(), "You can't follow yourself.", Toast.LENGTH_LONG).show();
     } 
    else 
    { 
     if (myFollowingList.contains(postUsername)) 
    {
    intent = new Intent(getApplication(), UnfollowActivity.class);
    Toast.makeText(getApplicationContext(), "You have followed the user.", Toast.LENGTH_LONG).show();
    } 
    else 
    {
    userDao.addFollowing(myUsername,postUsername);
     userDao.addFollower(postUsername,myUsername);
     Toast.makeText(getApplicationContext(), "You have successfully followed " + postUsername + "!", Toast.LENGTH_LONG).show();
      }
    }

            

* the screenshot:https://gitlab.cecs.anu.edu.au/u7323052/comp2100-6442-group-project-2022.s1/-/blob/master/Screenshot%20of%20Test/FollowTest/ChechTheFollowTest.png
* from the screenshot, we can see if one user follow the other user by post, the user followed can see his new followers at follow list.








