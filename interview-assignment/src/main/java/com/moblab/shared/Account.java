package com.moblab.shared;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Account")
public class Account {

    @ApiModelProperty(value = "User's Id")
    private String userId;

    @ApiModelProperty(value = "username")
    private String username;

    @ApiModelProperty(value = "Is user enable")
    private String disable;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisable() {
        return disable;
    }

    public void setDisable(String disable) {
        this.disable = disable;
    }
}
