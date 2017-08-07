package com.paouke.practice.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by admin on 2017/7/29.
 */
@Entity
@Table(name = "t_a_equipment")
public class EquipmentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

    @Column(name = "status")
    private Date status;

    @Column(name = "token")
    private String token;

    @Column(name = "login_time_stamp")
    private Date loginTimeStamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getStatus() {
        return status;
    }

    public void setStatus(Date status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getLoginTimeStamp() {
        return loginTimeStamp;
    }

    public void setLoginTimeStamp(Date loginTimeStamp) {
        this.loginTimeStamp = loginTimeStamp;
    }
}
