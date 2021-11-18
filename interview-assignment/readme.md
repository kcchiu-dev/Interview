# MobLab Interview

Technique: 

H2 Database: Once run the sever open console: [http://localhost:8080/h2](http://localhost:8080/h2)

swagger: Once run the sever open swagger-ui [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html#/)

 postman: In the project "testscript" folder

In Database I create four tables ACCOUNT, LIST, ITEM, ACTIVITY

and the ACTIVITY is intermediary table

You can use postman script to test service:

1. Create the Account using the Account folder **[POST][/users]**. Service will create UUID for userId
2. You can search all users using the Account folder **[GET][/users]**.
3. You can search the target user using the Account folder **[GET][/users/{username}]**.
4. You can disable the target user using the Account folder **[DELETE][/users/{userId}]**. In this service, we just update the user status
5. Create the List using the Activity folder **[POST][/activity/list]**. Service will create UUID for list Id
6. You can search all lists using the Activity folder **[GET][/activity/list]**.
7. You can search the target list using the list folder **[GET][/activity/list/{listId}]**.
8. Create the Item using the Activity folder **[POST][/activity/item]**. Service will create UUID for item Id
9. You can search all items using the Activity folder **[GET][/activity/item]**.
10. You can search the target item using the Activity folder **[GET][/activity/Item/{itemId}]**.
11. You can add the user's List using the Activity folder **[POST][/activity/user/list]**
12. You can update the target List's due date using the Activity folder **[PUT][/activity/list/{listId}/dueDate/{dueDate}]**
13. You can update the target Item belong which list using the Activity folder **[PUT][/activity/item/{itemId}/list/{listId}]**
14. You can delete the target list by list Id **[DELETE][/activity/list/{listId}]**
15. You can delete the target item by item Id **[DELETE][/activity/item/{itemId}]**