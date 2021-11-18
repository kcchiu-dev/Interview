package com.moblab.shared;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "List")
public class List {

    @ApiModelProperty(value = "list Id")
    private String listId;

    @ApiModelProperty(value = "list Name")
    private String listName;

    @ApiModelProperty(value = "due date")
    private String dueDate;

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
