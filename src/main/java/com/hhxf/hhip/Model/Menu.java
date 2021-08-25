package com.hhxf.hhip.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="user")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "mid")
    private String mid;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "fid")
    private Integer fid;
    @Column(name = "state")
    private Integer state;
    @Column(name = "icon")
    private String icon;

    public Menu(Integer id, String mid, String title, String content, Integer fid, Integer state, String icon) {
        this.id = id;
        this.mid = mid;
        this.title = title;
        this.content = content;
        this.fid = fid;
        this.state = state;
        this.icon = icon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Menu() {
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", mid='" + mid + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", fid=" + fid +
                ", state=" + state +
                ", icon='" + icon + '\'' +
                '}';
    }
}
