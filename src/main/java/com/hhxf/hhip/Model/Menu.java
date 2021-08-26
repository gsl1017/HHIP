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
}
