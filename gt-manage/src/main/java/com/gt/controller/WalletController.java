package com.gt.controller;


import com.gt.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @RequestMapping("/wallet")
    public void updaWallet(Double money){
        Long userId = 1L;
         walletService.updateWallet(money,userId);
    }
}
