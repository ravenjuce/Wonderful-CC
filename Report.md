# Group ANYWAY Report



## Table of Contents

1. [Team Members and Roles](#team-members-and-roles)
2. [Summary of Individual Contributions](#summary-of-individual-contributions)
3. [Conflict Resolution Protocol](#conflict-resolution-protocol)
4. [Application Description](#application-description)
5. [Application UML](#application-uml)
6. [Application Design and Decisions](#application-design-and-decisions)
7. [Summary of Known Errors and Bugs](#summary-of-known-errors-and-bugs)
8. [Testing Summary](#testing-summary)
9. [Implemented Features](#implemented-features)
10. [Team Meetings](#team-meetings)



## Team Members and Roles

| UID | Name |
| :--- | :----: |
| 7041419 | Shiyun Zhu |
| 7267216 | Chuming Zhang |
| 7323052 | Wangyi Li |

## Summary of Individual Contributions

##### *U7323052, Wangyi Li, I contribute 35% of the code. Here are my contributions:*

**Code Implementation**

```yaml
Package:
  posts:
    MyPosts.class
    MyPostsDao.class
    MyPostsDatabase.class
    MyPostsRepository.class
    MyPostsViewModel.class
    MyPostsPreviewActivity.class
    AddPostActivity.class
  observer:
    FollowerNotificationActivity.class
  follow:  
    PostCardActivity.class
    CheckFollowActivity.class
  dao:    
    UserDaoImpl.class
     - addFollowing()
     - addFollower()
     - addFollowerNotification()
     - addLikeCount()
     - addComment()
```

**Code design**

1. Propose observer pattern on notification system (follower's update notification, comments interaction notification) but failed to apply at the end.

2. Propose state pattern for user's state of login or not, but didn't apply in the project.

**UI design**

1. Draw the interface of the whole app by hand, but most of them were modified in the development progress.  ([Interface Draft](upload/Interface_Draft.pdf)*)

2. Demonstrate one post on a card view and use the recycler view to contain them, which composed the pose browsing page. 

3. Apply design on the edit post page and the follow check page.

**Report writing**

1. Write the application description. 

2. Write the related part about my code. 

**Slide preparation**

Participate in the slide making. 

**Miscellaneous contributions**

1) Responsible for the two checkpoints. 
2) Writing two minutes. 
3) Propose the project theme (project description).



##### ***U7041419 , Shiyun Zhu , I contribute 35% of the code. Here are my contributions:***

**Code Implementation**

```yaml
Package:
   mainPage:
    CheckApplyActivity.class
    MePageActivity.class
    MessageActivity.class
    MsgAdapter.class 
  normal:
    AddfriendActivity.class
    FriendsActivity.class
    LoginActivity.class
    signUpActicity.class 
    #part of the HomepageActivity.class
    HomepageActivity.class
  search:
    SearchResultActivity.class  
  bean:
    Chat.class
    DisplayBoard.class
    Msg.class
    PersonPage.class
  tokenizer:
    Token.class
    Tokenizer.class
    Parser.class
  dao:
    PostDaoImpl.class
    UserDaoImpl.class:
     - addUser()
     - deleteUser()
     - searchUserByName()
     - saveLogin()
     - delLogin()
     - readLogin()
     - addFriend()
     - findApply()
     - accApply()
     - rejectApply()
     - searchFriendByName()
     - searchApplyByName()    
  utils:
    #part of the DBHelper.class
    DBHelper.class
```

**Code design:**

1. Design patterns: The Dao pattern is used for manipulate user data, including a interface class `UserDao`, a implement class `UserDaoImpl`, and other application classes.

2. Data structures: The` ArrayList` is used to store serialized information, such as users, friends, messages, etc.

**UI Design**

1. Interface: Designed the splash page of the app with a little flash, the page for login and registration, the personal home page, the page for applying for friends and adding friends, and the chat page.

2. Tools: [lottiefiles](https://lottiefiles.com/)  [Pictures](https://www.zcool.com.cn/work/ZNDQxMTI4ODQ=.html)

**Report Writing**

1. Build the Application UML
2. Write the related part about my code.

3. Write parts of Application Design and Decisions, write some introduction of database and describe the tokenizer and parser, and describe the grammer for searching posts.

**Miscellaneous contributions**

1. Participate in the design of project code structure.

2. Take the minutes of the meeting.



##### *U7267216, Chuming Zhang, I contribute 30% of the code. Here are my contributions:*

**Code Implementation**

```yaml
Package:
  blacklist:
    BlacklistActivity.class
    FriendListActivity.class
  adapter:
    BlackAdapter.class
    FriendAdapter.class
  follow:  
    PostCardActivity.class
    CheckFollowActivity.class
  dao:    
    UserDaoImpl.class
     - searchFriendByNameNew()
     - addBlacklist()
     - getallFriendList()
  utils:
    SharePreferenceUtil.class
  bean:
    Administrator.class
    FriendBean.class
    OrdinaryUser.class
    User.class
  posts:
  #part of the posts.package in the below classes
    MyPosts.class
    MyPostsPreviewActivity.class
    AddPostActivity.class
  
```

**Code design**

1. Create Blacklist functionality, but the implementation deviated from the planned approach

2. Include private and public options when editing the posts

**UI design**

1. Design the interface of the whole app by hand, but most of them were modified in the development progress.  (File)

2. Add  Radiogroup in Post Page for Private & Public


**Report writing**
1) Conflict Resoution Protocol
2) Application Description 
3) Summary of Known Errors and Bugs
4) Write the related part about my code.

**Slide preparation**

Participate in the slide making. 

**Miscellaneous contributions**

1) Wrote Wiki on gitlab.
2) Wrote one minute. 




## Conflict Resolution Protocol

Step 1: Identify the source of the conflict. 

Step 2: Communicate and share with each other the reason each solution is identified.

Step 3: Choose a solution that each side of the dispute can support. (Vote)

Step 4: Reach an agreement.

*When our group is in conflict over a matter, we decided to take a vote to settle our differences.*

*Based on the results of the vote, a decision is made by the minority following the majority.*



## Application Description

WonderfulCC is a communication platform for the community of Chinese character educational content designers. Designers can upload their derivative designs of Chinese characters here. It is divided into pages (libraries) of different Chinese characters by Chinese character labels. Therefore, in the label of the same Chinese character, users can intuitively feel the creators' interpretation of different Chinese characters.

Through likes, creator followings, and personal communication, the community is brought closer together. To collect the creations of those interested in Chinese character education and prepare for the next step of derivative of Chinese character education (Chinese character education game APP or books) (not considering copyright, user participation and other factors). To promote the development of interesting education of Chinese characters for second-language learners.

![post page 1](/uploads/l.png)

![post page 2](/uploads/2.png)



**Application Use Cases and Examples**

Targets Users: Chinese characters educational content designers

- Post their design on the platform and get feedback.
- Communicate with language learners to improve the design.
- Share ideas and communicate with language other designers to improve the design.

*Sherry is a designer focused on Chinese characters, and she is involved in a language teaching development program new. She wants to share her derivative Chinese characters’ designs with others and get feedback.*

1. *She opens the App and posts her recent works.*
2. *She gets much response from both language learners and other designers.*
3. *Lots of users like her design and also give lots of good advice.*
4. *Some of the users followed Sherry to get her newest post.*
5. *Some of the users request to add Sherry as a friend to communicate more stuff with her.*
6. *Sherry browses the posting page and gets inspired by lots of works.*
7. *Sherry also follows some users to check their updates.*
8. *She makes many friends on the App who use the App for different purposes.*



Targets Users: Chinese characters learner

- Learn Chinese characters more efficiently and creatively.
- Share interesting ideas about Chinese character design and advise on others' work.

*Mike is an Australian student struggling to learn Chinese characters and recently wanted to find more interesting ways to learn Chinese.*

1. *Mike clicks on the App with curiosity and anticipation*
2. *He browsed through the homepage to see what other users had shared about Chinese character’s derivative design and liked and commented on other people's posts*
3. *He finds that the works posted by other users are interesting and helpful for remembering and understanding the characters.*
4. *He leaves some comments on some posts with his points of view of their works and has good communication with the author and other users who commented there.*
5. *He follows some designers he likes to get their newest work.*
6. *He also adds some users to talk about the Chinese characters’ derivative design advice.*



Targets Users: Chinese characters education product developer

- Looking for some designers to cooperate.

*Udon is a member of a Chinese education product development program. Her company plans to develop a game to help users learn Chinese characters. She is looking for some new members to join her team.*

1. *Udon opens the App. She is an old user of the app. She has lots of friends on the app and follows many designers.*
2. *She chats with some of her friends to invite them and comment on her following to ask if they are interested in her program so they can make friends and talk a little bit more.*
3. *Some designers accept her invites and join her program.*
4. *She also talks with many designers to pay and get the copyright of their works to use them on her product.*



## Application UML

![uml](/uploads/uml.png)



## Application Design and Decisions

We chose to use SQLite and Room databases to store the main data,  FireBase has always had network connection problems, so we did not choose to use it. We have carried on the detailed design to the database form.

DataBase design:

1. The form user is used to store the personal information of the user. The field corresponds to the field of the entity class one by one. When the user logs in and registers, the information is extracted from this form.
2. The form post is used to store information about the post. The field corresponds to the field of the entity class, which is used to fetch information when the post is read with the post.
3. The form friend is used to store friend information and application information. When a friend application is sent, a new data will be created in the form, which contains the user name of the current user and applicant. When the application is approved, the state data will be changed to the number 1.



**Data Structures**

The most common data structure we use is `ArrayList`,

* *Specific activities: MyPostsPreviewActivity, AddPostActivity , etc*



**Design Patterns**

- Dao pattern:
  - Describe: We used the Dao pattern for database operations.
  - Reason: Dao mode can be used to separate database basic operations, data read and write logic operations, and specific business logic operations, which is convenient to improve the reuse and readability of code during data interaction, and convenient to modify at any time.
  - Location: DBHelper.class, PostDao.class, UserDaoImpl.class, PostDao.class, UserDao.class, And other classes which need to use data.
- Singleton Pattern
  - Describe: We used the Singleton pattern for creating database.
  - Reason: The reason we use the pattern is to make sure that there is only one room database for every time we want to call the database.
  - Location: MyPostDatabase: lines of code: 17-29
  
- Observer Pattern
  
  We tried to apply an observer pattern to the Following Update activity. For every time the user being followed updates a post, the follower will get the notification of the update. The post is the subject and the followers are observers. However, we get stuck in the combination of database and user interface. So we end with implement the function without the observer pattern.



**Grammar(s)**

 Production Rules:

\<exp> ::=  \<item> | \<item>\<item> | \<exp>\<item>

\<item> ::= \<name>  |  \<tag>  |

\<name> ::= \<at>\<string>

\<tag> ::= \<pond>\<string>

\<pond> is  #

\<at> is @

\<string>  is a string without space.

Reason:

We provided users with the function to search posts based on tags and author names. Since users need to specify which is a tag and which is a user name, even need to use multiple tags. so we design this grammar so that users can find posts on demand.

Advantages:

When searching posts, users can get the results they want more clearly.



**Tokenizer and Parsers**

- Tokenizer

  We use the sign (@) and the  sign (@) to distinguish a tag from an author, and each @ identifies the string that follows it as the author name until the next sign, and each # identifies the string that follows it as a tag until the next sign.

- Parser

  When the user enters tags and author names as required, tokenizer is used for word segmentation, then Parser is used to determine which are names and which are tags, and the corresponding posts are pulled from the database for joint filtering (not done yet).



**Other**

- For blacklisting this is a related function, although it is currently only implemented so that the content of the post page cannot be viewed after user A has been blacklisted. However, once the design is combined with other features, it will be impossible to like, follow, comment or chat after a user has been blacklisted. This would result in a relatively complete app.




## Summary of Known Errors and Bugs

1. *Bug 1:*

- *The like count and new comments need to go back to the previous menu and go back to see the increase of the like count and the new comment.*


2. *Bug 2:*

- *Blacklist: After posting something, if User A was balcklisted, then User A cannot see anything in Post Page*

3. *Bug 3:*

- *Private & Public and Blacklist, this two functions work fine on theirs own, but when combined with the last version of everyone's code, it flashes to varying degrees when tested.*

4. Bug 4：

- After sending a message to a friend, the friend list is cleared. Users need to return to the home page and enter the friend page to show the list.

5. Bug 5:

- The search function is not complete and the program will crash if you enter a search statement in another format.




## Implemented Features

**Feature Category: *Privacy*** 

Implemented features:

1. *Users may send requests which are then accepted or denied by another user or organisation (e.g., a request to follow an event, a person or organisation). (easy)*

   ​	a . Class AddFriendActivity, methods add(),  Lines of code: 62-79

   ​	b. Class FriendsActivity, Lines of code: 35-150

   ​	c. Class CheckApplyActivity, Lines of code: 55-82

   ​	d. MePageActivity, Lines of code: 41-46

   

2. *A user can only see a profile/event that is Public (consider that there are at least two types of profiles: public and private). (easy)*

   ​	a . Class MyPostPreviewActivity , methods dealWith(),  Lines of code: 151-171

   ​	b. Class MyPosts, Lines of code: 55-59,83-89

   ​	c. Class AddPostActivity, Lines of code: 97-106




**Feature Category: *User Interactivity***

Implemented features:

1. *The ability to micro-interact with items in your app (e.g. like/dislike/support/report a post/message/event) [stored in-memory]. (easy)*

​		a. PostCardActivity: buttonLike.setOnClickListener(), buttonSend.setOnClickListener(), lines of code: 102-147

​		b. UserDaoImpl: addLikeCount(), addComment(), generateLikeCountList(), generateCommentsList(), lines of code: 100-116, 264-283



2. *The ability to ‘follow’ users, events, movements, hashtags, topics. There must be a section specifically dedicated to 'things' followed. [stored in-memory] (medium)*

​		a. PostCardActivity: buttonFollow.setOnClickListener(), lines of code: 80-97

​		b. CheckFollowActivity: onCreate(), lines of code: whole file

​		c. FollowerNotificationActivity: onCreate(), lines of code: whole file

​		d. UserDaoImpl: addFollowing(), addFollower(), addFollowerNotification(), generateFollowingList(), generateFollowerNotificationList(), generateFollowerNotificationList(), lines of code: 73-97, 231-262



3. *Provide users with the ability to ‘block’ things. Things (e.g., events, users, messages containing abusive language, etc) shall not be visible to the user who blocked that activity. (medium)*

   ​	a . Class BlackAdapter, Lines of code: whole file

   ​	b. Class FriendAdapter, Lines of code: whole file

   ​	c. Class BlacklistActivity, Lines of code: whole file

   ​	d. Class FriendListActivity, Lines of code: whole file

   ​	e. Class HomePageActivity, method: friendList(), blackList()Lines of code: whole file
   ​	f. UserDaoImpl, Lines of code: 

   ​	g. Class MyPostPreviewActivity, boolean isBlackListFriend Lines of code: 175-198
  
   ​	h. Class FriendBean, Lines of code: whole file
   




**Feature Category: *Peer to Peer Messaging***

Implemented features:

*Provide users with the ability to message each other or an institution directly (e.g., a user can message an event/movement that is managed by another user). (hard)*

​			a. Class Msg, lines of code: whole file

​			b. Class MessageActivity, lines of code: whole file

​			c. Class MsgAdapter, lines of code: whole file

​			d. Class FriendsActivity,  lines of code: 55-65



**Feature Category: *Greater Data Usage, Handling and Sophistication***

Implemented features:

*User profile activity containing a media file (image, animation (e.g. gif), video). (easy)*

​		a. AddPostActivity: imageViewAddImage.setOnClickListener(), buttonSave.setOnClickListener(), registerActivityForSelectImage(), onRequestPermissionsResult(), makeSmall(), lines of code: whole file

​		b. MyPostActivity: registerActivityForAddPost(), lines of code: 109-140





## Team Meetings

- *[Team Meeting 1](MeetingMinutes/MeetingMinutes-Week7-4.20.md)*
- *[Team Meeting 2](MeetingMinutes/MeetingMinutes-Week9-5.2.md)*
- *[Team Meeting 3](MeetingMinutes/MeetingMinutes-Week9-5.3.md)*
- *[Team Meeting 4](MeetingMinutes/MeetingMinutes-Week10-5.14.md)*
- *[Team Meeting 5](MeetingMinutes/MeetingMinutes-Week11-5.16.md)*

