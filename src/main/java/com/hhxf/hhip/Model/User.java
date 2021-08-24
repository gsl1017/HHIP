package com.hhxf.hhip.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * user 实体类
 */
@Entity
@Table(name="user")
@AllArgsConstructor
@NoArgsConstructor
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private String id;
    @Column(name="account")
    private String account;
    @Column(name="username")
    private String username;
    @Column(name="pwd")
    private String pwd;
    @Column(name="creattime")
    private String creattime;
    @Column(name="creatuserid")
    private String creatuserid;
    @Column(name="state")
    private Integer state;
    @Column(name="menus")
    private String menus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    public String getCreatuserid() {
        return creatuserid;
    }

    public void setCreatuserid(String creatuserid) {
        this.creatuserid = creatuserid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMenus() {
        return menus;
    }

    public void setMenus(String menus) {
        this.menus = menus;
    }
}
