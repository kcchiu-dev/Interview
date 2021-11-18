package com.moblab.service;

import com.moblab.shared.Account;
import com.moblab.shared.Item;
import com.moblab.shared.List;


public interface ActivityService {

    List getListByListId(String listId);

    java.util.List<List> fetchAllList();

    Item getItemByItemId(String itemId);

    java.util.List<Item> fetchItemList();

    int addList(List list);

    int addItem(Item item);

    int updateListDueDate(String listId, String date);

    int updateItemBelongList(String itemId, String listId);

    int deleteItem(String itemId);

    Object deleteList(String listId);

    Object addUserList(List list, Account account);


}
