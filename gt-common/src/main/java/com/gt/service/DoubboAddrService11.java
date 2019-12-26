package com.gt.service;

import com.gt.entity.UserAddr;

public interface DoubboAddrService11 {
    Integer add(UserAddr userAddr);

    Integer update(UserAddr userAddr);

    Integer delete(Integer addrId, Integer userId);
}
