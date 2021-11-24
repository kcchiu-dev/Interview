package com.moblab.interviewassignment.Service.Impl;

import com.moblab.domain.entity.ItemEntity;
import com.moblab.domain.entity.ListEntity;
import com.moblab.domain.repo.ItemRepository;
import com.moblab.domain.repo.ListRepository;
import com.moblab.service.impl.ActivityServiceImpl;
import com.moblab.shared.Item;
import com.moblab.shared.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;


import java.util.Collections;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class ActivityServiceImplTest {


    @Mock
    private ListRepository listRepository;

    @Mock
    private ItemRepository itemRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private ListEntity listEntity;

    @Mock
    private ItemEntity itemEntity;



    @InjectMocks
    private ActivityServiceImpl activityService;

    @Test
    public void testGetListByListId(){
        BDDMockito.doReturn(Optional.of(listEntity)).when(listRepository).findByListId(BDDMockito.any());
        activityService.getListByListId(BDDMockito.any());
        modelMapper.map(listEntity, ListEntity.class);
    }

    @Test
    public void testFetchAllList(){
        BDDMockito.given(listRepository.findAll()).willReturn(Collections.singletonList(listEntity));
        activityService.fetchAllList();
    }

    @Test
    public void testGetItemByItemId(){
        BDDMockito.doReturn(Optional.of(itemEntity)).when(itemRepository).findByItemId(BDDMockito.any());
        activityService.getItemByItemId(BDDMockito.any());
        modelMapper.map(itemEntity, ItemEntity.class);
    }

    @Test
    public void testFetchItemList(){
        BDDMockito.given(itemRepository.findAll()).willReturn(Collections.singletonList(itemEntity));
        activityService.fetchItemList();
    }

    @Test
    public void testAddList(){
        List mockList = new List();
        mockList.setDueDate("2021-11-19");
        activityService.addList(mockList);
    }

    @Test
    public void testAddItem(){
        Item mockItem = new Item();
        mockItem.setDeadline("2021-11-19");
        activityService.addItem(mockItem);
    }

    @Test
    public void testUpdateListDueDate(){
        activityService.updateListDueDate("listId", "2021-11-19");
    }

    @Test
    public void testUpdateItemBelongList(){
        activityService.updateItemBelongList("itemId", "listId");
    }

    @Test
    public void testDeleteItem(){
        activityService.deleteItem("itemId");
    }

    @Test
    public void testDeleteList(){
        activityService.deleteList("listId");
    }
}
