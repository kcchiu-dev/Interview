# MobLab Interview

Technique: 

H2 Database: Once run the sever open console: [http://localhost:8080/h2](http://localhost:8080/h2)

swagger: Once run the sever open swagger-ui [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html#/)

In Database I create four tables ACCOUNT, LIST, ITEM, ACTIVITY

and the ACTIVITY is intermediary table

I have provided postman script In the project "testscript" folder.

You can use **Postman script** to test service:

1. Create the Account using the Postman collections request name: **[POST][/users]**. Service will create UUID for userId. **Example: [POST] http://localhost:8080/users**
    ```json
    {
    	"account":{
    		"username":"test1"
    	}
    }
    ```
2. You can search all users using the Postman collections request name: **[GET][/users]**. To get all user information. **Example: [GET]] http://localhost:8080/users**.
3. You can search the target user using the Postman collections request name: **[GET][/users/{username}]**. As we create item 1 we can user username get user information. **Example: [GET] http://localhost:8080/users/test1** 
4. You can disable the target user using the Postman collections request name: **[DELETE][/users/{userId}]**. In this service, we just update the user status. we can use item 2 get all user information and copy target userId to disable user. **Example: [DELETE] http://localhost:8080/users/96c214e6-ab83-4ac3-af84-493b33bb5129**
5. Create the List using the Postman collections request name: **[POST][/activity/list]**. Service will create UUID for list Id. **Example: [POST] http://localhost:8080/activity/list**
    ```json
    {
        "list": {
            "listName": "testList",
            "dueDate": "2021-11-19"
        }
    }
    ```
6. You can search all lists using the Postman collections request name: **[GET][/activity/list]**. To request get all list information. **Example: [GET] http://localhost:8080/activity/list**
7. You can search the target list using the Postman collections request name: **[GET][/activity/list/{listId}]**. We can request item 6 get all List and copy target listId to test. **Example: [GET] http://localhost:8080/activity/list/4d79b472-f4d0-4338-b61d-3dafa0365edd** 
8. Create the Item using the Postman collections request name: **[POST][/activity/item]**. Service will create UUID for item Id. **Example: [POST] http://localhost:8080//activity/item**
    ```json
    {
        "item": {
            "listId": "4d79b472-f4d0-4338-b61d-3dafa0365edd",
            "itemName": "itemName",
            "description": "testDescription",
            "deadline": "2021-11-20"
        }
    }
    ```
9. You can search all items using the Postman collections request name: **[GET][/activity/item]**. To request get all items information. **Example: [GET] http://localhost:8080/activity/item**
10. You can search the target item using the Postman collections request name: **[GET][/activity/item/{itemId}]**. We can request item 9 get all items and copy target itemId to test. **Example: [GET] http://localhost:8080/activity/item/c5fc0ce3-1d31-4984-b8fc-2e9005c7b7dd**
11. You can add the user's List using the Postman collections request name: **[POST][/activity/user/list]** To add activity need to create Account and list first. ** Example: [POST] http://localhost:8080/activity/user/list**
```json
    {
        "list": {
            "listId": "4d79b472-f4d0-4338-b61d-3dafa0365edd"
        },
        "account": {
            "userId": "96c214e6-ab83-4ac3-af84-493b33bb5129"
        }
    }
```
12. You can update the target List's due date using the Postman collections request name: **[PUT][/activity/list/{listId}/dueDate/{dueDate}]** **Example: [PUT] http://localhost:8080/activity/list/4d79b472-f4d0-4338-b61d-3dafa0365edd/dueDate/2022-01-10**
13. You can update the target Item belong which list using the Postman collections request name: **[PUT][/activity/item/{itemId}/list/{listId}]** **Example: [PUT] http://localhost:8080/activity/item/c5fc0ce3-1d31-4984-b8fc-2e9005c7b7dd/list/d7f1ae38-1d04-41c5-a440-ca9404fb3ce3**
14. You can delete the target list by list Id **[DELETE][/activity/list/{listId}]** **Example: [DELETE] http://localhost:8080/activity/list/4d79b472-f4d0-4338-b61d-3dafa0365edd**
15. You can delete the target item by item Id **[DELETE][/activity/item/{itemId}]** **Example: [DELETE] http://localhost:8080/activity/item/c5fc0ce3-1d31-4984-b8fc-2e9005c7b7dd**