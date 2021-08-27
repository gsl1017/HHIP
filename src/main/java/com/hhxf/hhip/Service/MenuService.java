package com.hhxf.hhip.Service;

import com.hhxf.hhip.util.Result;
import org.springframework.data.domain.Pageable;

public interface MenuService {
    Result getListByuserid(String userid);
    Result queryAll();
    Result findByIdPageable(Pageable pageable);
}
