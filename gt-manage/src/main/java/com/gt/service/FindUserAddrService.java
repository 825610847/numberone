package com.gt.service;

import com.gt.entity.UserAddr;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 何水告
 * @create 2019/12/24
 * 男人之所以努力，是为了获得更好的交配权
 */
@Service
public interface FindUserAddrService {
    List<UserAddr> getUserAddrById(Integer userCatAddressId);

}
