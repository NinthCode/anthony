package com.paouke.practice.dao;


import com.paouke.practice.domain.UserEntity;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by admin on 2017/7/29.
 */
@Repository
public interface UserDao extends PagingAndSortingRepository<UserEntity, Long>,
        JpaSpecificationExecutor<UserEntity>, JpaRepository<UserEntity, Long> {
}
