package com.moblab.domain.repo;

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
public interface ListRepository extends JpaRepository<ListEntity, String> {


    Optional<ListEntity> findByListId(String listId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO LIST (LIST_ID, LIST_NAME, DUE_DATE, CREATE_DATE, UPDATE_DATE) " +
            "       VALUES (:listId, :listName, :dueDate, :createDate, :updateDate) ", nativeQuery = true)


    int addList(@Param("listId") String listId,
                @Param("listName") String listName,
                @Param("dueDate") Date dueDate,
                @Param("createDate") LocalDateTime createDate,
                @Param("updateDate") LocalDateTime updateDate);

    @Transactional
    @Modifying
    @Query(value = "UPDATE LIST SET DUE_DATE = :dueDate, UPDATE_DATE = :updateDate WHERE LIST_ID = :listId", nativeQuery = true)
    int updateListDueDate(@Param("dueDate") Date dueDate,
                          @Param("updateDate") LocalDateTime updateDate,
                          @Param("listId") String listId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM LIST WHERE LIST_ID = :listId ", nativeQuery = true)
    int deleteList(@Param("listId") String listId);

}