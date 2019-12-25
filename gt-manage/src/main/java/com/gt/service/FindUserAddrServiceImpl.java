package com.gt.service;

import com.gt.entity.UserAddr;
import com.gt.mapper.FindUserAddrMapper;
import com.gt.service.FindUserAddrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 何水告
 * @create 2019/12/24
 * 男人之所以努力，是为了获得更好的交配权
 */
@Service
public class FindUserAddrServiceImpl implements FindUserAddrService {
    @Autowired
    private FindUserAddrMapper findUserAddrMapper;
    private List<UserAddr> findUserAddr(Integer userCatAddressId) {
        List<UserAddr>addrs=findUserAddrMapper.selectUserAddrById(userCatAddressId);
        /*for(UserAddr addr:addrs){
            addr.setDeliveryAddressId(null);
            addr.setDelivery_address(null);
            addr.setUserCatAddressId(null);
            addr.setUserName(null);
            addr.setUserPhone(null);
        }*/
        return addrs;
    }

    @Override
    public List<UserAddr> getUserAddrById(Integer userCatAddressId) {
        return findUserAddr(userCatAddressId);
    }
}
