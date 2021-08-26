package com.hhxf.hhip.Impl;

import com.hhxf.hhip.Model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "menuDao")
public interface MenuDao extends JpaRepository<Menu,String> {
    List<Menu> getMenusByPid(String pid);
}
