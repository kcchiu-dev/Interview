package com.moblab.service.impl;

import com.moblab.domain.entity.AccountEntity;
import com.moblab.domain.entity.ItemEntity;
import com.moblab.domain.entity.ListEntity;
import com.moblab.domain.repo.ActivityRepository;
import com.moblab.domain.repo.ItemRepository;
import com.moblab.domain.repo.ListRepository;
import com.moblab.service.ActivityService;
import com.moblab.shared.Account;
import com.moblab.shared.Item;
import com.moblab.shared.List;
import org.apache.tomcat.jni.Local;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ListRepository listRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List getListByListId(String listId) {
        Optional<ListEntity> optionalList = listRepository.findByListId(listId);
        List list = new List();
        if (optionalList.isPresent()) {
            list = convertToListDto(optionalList.get());
        }
        return list;
    }

    @Override
    public java.util.List<List> fetchAllList() {
        java.util.List<ListEntity> list = listRepository.findAll();
        return list.stream().map(this::convertToListDto).collect(Collectors.toList());
    }

    @Override
    public Item getItemByItemId(String itemId) {
        Optional<ItemEntity> optionalItem = itemRepository.findByItemId(itemId);
        Item item = new Item();
        if (optionalItem.isPresent()) {
            item = convertToItemDto(optionalItem.get());
        }
        return item;
    }

    @Override
    public java.util.List<Item> fetchItemList() {
        java.util.List<ItemEntity> items = itemRepository.findAll();
        return items.stream().map(this::convertToItemDto).collect(Collectors.toList());
    }

    @Override
    public int addList(List list) {
        String listId = UUID.randomUUID().toString();
        Date dueDate = new Date();
        try {
            dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(list.getDueDate());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
        return listRepository.addList(listId, list.getListName(), dueDate, LocalDateTime.now(), LocalDateTime.now());
    }

    @Override
    public int addItem(Item item) {
        String itemId = UUID.randomUUID().toString();
        Date deadLine = new Date();
        try {
            deadLine = new SimpleDateFormat("yyyy-MM-dd").parse(item.getDeadline());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
        return itemRepository.addItem(itemId, item.getListId(), item.getItemName(), item.getDescription(), deadLine, LocalDateTime.now(), LocalDateTime.now());
    }

    @Override
    public int updateListDueDate(String listId, String date) {
        Date dueDate = new Date();
        try {
            dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
        return listRepository.updateListDueDate(dueDate, LocalDateTime.now(), listId);
    }

    @Override
    public int updateItemBelongList(String itemId, String listId) {
        return itemRepository.updateItemBelong(listId, LocalDateTime.now(), itemId);
    }

    @Override
    public int deleteItem(String itemId) {
        return itemRepository.deleteItem(itemId);
    }

    @Override
    public Object deleteList(String listId) {
        boolean bResult = false;
        if (listRepository.deleteList(listId) > 0) {
            activityRepository.deleteListByListId(listId);
            bResult = true;
        }
        return bResult;
    }

    @Override
    public Object addUserList(List list, Account account) {
        String activityId = UUID.randomUUID().toString();
        return activityRepository.addActivity(activityId, list.getListId(), account.getUserId(), LocalDateTime.now(), LocalDateTime.now());
    }

    private List convertToListDto(ListEntity listEntity) {
        List list = modelMapper.map(listEntity, List.class);
        return list;
    }

    private Item convertToItemDto(ItemEntity itemEntity) {
        Item item = modelMapper.map(itemEntity, Item.class);
        return item;
    }

}
