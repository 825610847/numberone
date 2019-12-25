package com.gt.service;


import com.gt.entity.UserProperty;
import com.gt.mapper.UserProMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class walletServiceImpl implements WalletService {

    @Autowired
    private UserProMapper userProMapper;

    @Override
    public void updateWallet(Double money, Long userId) {
        UserProperty userPro = userProMapper.selectById(userId);
        Double db = userPro.getUserWallet();
        Double sum=db+money;
        userPro.setUserWallet(sum);
    }
}
