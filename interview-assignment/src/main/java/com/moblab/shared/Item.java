package com.moblab.shared;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Item")
public class Item {

    @ApiModelProperty(value = "Item Id")
    private String itemId;
    @ApiModelProperty(value = "list Id")
    private String listId;
    @ApiModelProperty(value = "Item name")
    private String itemName;
    @ApiModelProperty(value = "Item's description")
    private String description;
    @ApiModelProperty(value = "Item's deadline")
    private String deadline;


    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
