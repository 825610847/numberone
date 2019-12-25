package com.gt.serviceImpl;

import com.gt.service.UserService;
import com.gt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private HttpClientService htClient;

    @Override
    public SysResult login(String username, String pwd) {
        Map<String,String> params = new HashMap<String,String>();
        params.put("username",username);
        params.put("password",pwd);
        String url = "http://176.201.111.26:8090/login";
        return htClient.doGet(url,params,SysResult.class,"utf-8");
    }
}
