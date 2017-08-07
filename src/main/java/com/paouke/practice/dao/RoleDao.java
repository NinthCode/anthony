package com.paouke.practice.dao;

import com.paouke.practice.domain.RoleEntity;
import com.paouke.practice.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2017/7/29.
 */
@Repository
public interface RoleDao extends PagingAndSortingRepository<RoleEntity, Long>,
        JpaSpecificationExecutor<RoleEntity>, JpaRepository<RoleEntity, Long> {
    List<RoleEntity> findAllByUserId(Long UserId);
}
