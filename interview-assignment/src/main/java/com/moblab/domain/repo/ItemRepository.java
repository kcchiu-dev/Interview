package com.moblab.domain.repo;

import com.moblab.domain.entity.ItemEntity;
import com.moblab.domain.entity.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, String> {


    Optional<ItemEntity> findByItemId(String itemId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO ITEM (ITEM_ID, LIST_ID, ITEM_NAME, DESCRIPTION, DEADLINE, CREATE_DATE, UPDATE_DATE) " +
            "       VALUES (:itemId, :listId, :itemName, :description, :deadLine, :createDate, :updateDate)", nativeQuery = true)
    int addItem(@Param("itemId") String itemId,
                @Param("listId") String listId,
                @Param("itemName") String itemName,
                @Param("description") String description,
                @Param("deadLine") Date deadLine,
                @Param("createDate") LocalDateTime createDate,
                @Param("updateDate") LocalDateTime updateDate);

    @Transactional
    @Modifying
    @Query(value = "UPDATE ITEM SET LIST_ID = :listId, UPDATE_DATE = :updateDate WHERE ITEM_ID = :itemId ", nativeQuery = true)
    int updateItemBelong(@Param("listId") String listId,
                         @Param("updateDate") LocalDateTime updateDate,
                         @Param("itemId") String itemId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM ITEM WHERE ITEM_ID = :itemId ", nativeQuery = true)
    int deleteItem(@Param("itemId") String itemId);


}