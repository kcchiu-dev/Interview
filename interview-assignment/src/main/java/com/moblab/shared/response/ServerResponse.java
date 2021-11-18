package com.moblab.shared.response;

import com.moblab.shared.Account;
import com.moblab.shared.Item;
import com.moblab.shared.List;

public class ServerResponse extends BasicResponse {

    private Account account;
    private List list;
    private Item item;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
