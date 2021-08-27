package com.hhxf.hhip.Impl;

import com.hhxf.hhip.Model.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "menuDao")
public interface MenuDao extends JpaRepository<Menu,String> {
    List<Menu> getMenusByPid(String pid);

    @Query(value = "select m from Menu m")
    Page<Menu> findByIdPageable(Pageable pageable);

}

