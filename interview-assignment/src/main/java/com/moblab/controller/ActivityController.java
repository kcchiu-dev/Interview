package com.moblab.controller;


import com.moblab.service.ActivityService;
import com.moblab.shared.Item;
import com.moblab.shared.request.ServerRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @ApiResponses(value = {@ApiResponse(code=200,message = "search success")})
    @ApiOperation("search List by listId")
    @GetMapping("/list/{listId}")
    @ResponseBody
    public com.moblab.shared.List getListByListId(@PathVariable String listId){
        return activityService.getListByListId(listId);
    }

    @ApiResponses(value = {@ApiResponse(code=200,message = "search success")})
    @ApiOperation("search All List")
    @GetMapping("/list")
    @ResponseBody
    public List<com.moblab.shared.List> fetchAllList(){
        return activityService.fetchAllList();
    }

    @ApiResponses(value = {@ApiResponse(code=200,message = "search success")})
    @ApiOperation("search Item By itemId")
    @GetMapping("/item/{itemId}")
    @ResponseBody
    public Item getItemByItemId(@PathVariable String itemId){
        return activityService.getItemByItemId(itemId);
    }

    @ApiResponses(value = {@ApiResponse(code=200,message = "search success")})
    @ApiOperation("search all Items")
    @GetMapping("/item")
    @ResponseBody
    public List<Item> fetchAllItem(){
        return activityService.fetchItemList();
    }

    @ApiResponses(value = {@ApiResponse(code=200,message = "insert success")})
    @ApiOperation("add new list")
    @PostMapping("/list")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Object addList(@RequestBody ServerRequest request){
        return activityService.addList(request.getList());
    }

    @ApiResponses(value = {@ApiResponse(code=200,message = "insert success")})
    @ApiOperation("add new item")
    @PostMapping("/item")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Object addItem(@RequestBody ServerRequest request){
        return activityService.addItem(request.getItem());
    }

    @ApiResponses(value = {@ApiResponse(code=200,message = "update success")})
    @ApiOperation("update List's due date")
    @PutMapping("/list/{listId}/dueDate/{dueDate}")
    @ResponseBody
    public Object updateDueDate(@PathVariable String listId, @PathVariable String dueDate){
        return activityService.updateListDueDate(listId, dueDate);
    }

    @ApiResponses(value = {@ApiResponse(code=200,message = "update success")})
    @ApiOperation("update item belong list")
    @PutMapping("/item/{itemId}/list/{listId}")
    @ResponseBody
    public Object updateItemBelongList(@PathVariable String itemId, @PathVariable String listId){
        return activityService.updateItemBelongList(itemId, listId);
    }

    @ApiResponses(value = {@ApiResponse(code=200,message = "delete success")})
    @ApiOperation("delete target item by itemId")
    @DeleteMapping("/item/{itemId}")
    @ResponseBody
    public Object deleteItem(@PathVariable("itemId") String itemId){
        return activityService.deleteItem(itemId);
    }

    @ApiResponses(value = {@ApiResponse(code=200,message = "delete success")})
    @ApiOperation("delete target list by listId")
    @DeleteMapping("/list/{listId}")
    @ResponseBody
    public Object deleteList(@PathVariable("listId") String listId){
        return activityService.deleteList(listId);
    }


    @ApiResponses(value = {@ApiResponse(code=200,message = "insert success")})
    @ApiOperation("add new activity: add user's list")
    @PostMapping("/user/list")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Object addUserList(@RequestBody ServerRequest request){
        return activityService.addUserList(request.getList(), request.getAccount());
    }

}
