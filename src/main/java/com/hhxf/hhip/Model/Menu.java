package com.hhxf.hhip.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="menu")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

    public static final int STATUS_DISABLED = 0;

    public static final int STATUS_ENABLED = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String mid;
    private String title;
    private String content;
    private Integer state;
    private String icon;
    private String pid;

    @OneToMany(targetEntity = Menu.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pid")
    private List<Menu> children = new ArrayList<>();

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", mid='" + mid + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", state=" + state +
                ", icon='" + icon + '\'' +
                ", pid='" + pid + '\'' +
                ", children=" + children +
                '}';
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
