package com.hhxf.hhip.Service;

import com.hhxf.hhip.util.Result;

public interface MenuService {
    Result getListByuserid(String userid);
    Result queryAll();
}
