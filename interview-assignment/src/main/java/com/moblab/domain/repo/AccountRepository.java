package com.moblab.domain.repo;

import com.moblab.domain.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, String> {



    List<AccountEntity> findByDisableOrderByUsername(boolean disable);

    Optional<AccountEntity> findByUsername(String username);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO ACCOUNT (USER_ID, USERNAME, DISABLE, CREATE_DATE, UPDATE_DATE) " +
            "       VALUES (:userId, :username, :disable, :createDate, :updateDate)", nativeQuery = true)
    int addUser(@Param("username") String username,
                @Param("userId") String userId,
                @Param("disable") String disable,
                @Param("createDate") LocalDateTime createDate,
                @Param("updateDate") LocalDateTime updateDate);

    @Transactional
    @Modifying
    @Query(value = "UPDATE ACCOUNT SET DISABLE = :disable, UPDATE_DATE = :updateDate WHERE USER_ID = :userId ", nativeQuery = true)
    int deleteUser(@Param("disable") String disable, @Param("updateDate") LocalDateTime
            updateDate, @Param("userId") String userId);



}