package com.moblab.domain.repo;

import com.moblab.domain.entity.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<ActivityEntity, String> {


    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Activity ( ACTIVITY_ID, LIST_ID, USER_ID, CREATE_DATE, UPDATE_DATE) " +
            "       VALUES (:activityId, :listId, :userId, :createDate, :updateDate)", nativeQuery = true)
    int addActivity(@Param("activityId") String activityId,
                @Param("listId") String listId,
                @Param("userId") String userId,
                @Param("createDate") LocalDateTime createDate,
                @Param("updateDate") LocalDateTime updateDate);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Activity WHERE ACTIVITY_ID = :activityId ", nativeQuery = true)
    int deleteListByActivityId(@Param("activityId") String activityId);


    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Activity WHERE USER_ID = :userId ", nativeQuery = true)
    int deleteListByUserId(@Param("userId") String userId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Activity WHERE LIST_ID = :listId ", nativeQuery = true)
    int deleteListByListId(@Param("listId") String listId);


}
