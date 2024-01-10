# ANYWAY
## Team Meeting 4 - Week 10 - 5.14 (22:00-23:00)
**Absent:** Yifa Ge
<br>
**Lead/scribe:** Wangyi Li

## Agreed Procedure
Stand up Procedure: Two members who already have progress on coding report progress and plan for the next step.

## Agenda Items
| Number | Item |
| :--- | ---: |
| 1 | Database tables |
| 2 | Tokenizer & parser |
| 3 | Data structure for searching |
| 4 | Easy feature4 application |

## Meeting Minutes
- Our scoring point lies in the complete realisation of eight features.
  At the same time, there must be the "tokenizer & parser" and tree structure.

  Our project's progress is still to realise the rest of the two functions of the first easy part. (2/4)
- Finalise database tables: users table, friends table, posts table, comments table
- For the searching function, we conduct a joint search by username and tag, and the "tokenizer & parser" can be added here. Search format: @username; #TAG1#TAG2
- Our data exists in the database, and we need to export all of it and put it in a collection. Then use a class to convert it into a tree structure. For example, we can follow the first letter. The 26 letters are divided into the first layer and the second layer. Every five letters form a node.
- For the option to block users, you can create an additional table, similar to the friends' table. The first column is the username, and the second column is the blacklist. After the user login, the search method is called to read the user's post in the blacklist, and a judgment is added when the home page is displayed or not displayed.

## TODO Items
| Task | Assignee |
| :--- | ---: |
| Add friends notification \| Searching (parsing & tree) | Shiyun Zhu |
| Follow & unfollow \| Observation pattern | Wangyi Li |
| Blocklist \| User rights | Chuming Zhang |

## Scribe Rotation
The following dictates who will be scribe in this and the next meeting.
| Name |
| :---: |
| Wangyi Li |
| Wangyi Li |