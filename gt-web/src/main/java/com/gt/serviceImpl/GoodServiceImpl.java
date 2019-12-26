package com.gt.serviceImpl;

import com.gt.service.GoodService;
import com.gt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private HttpClientService htClient;

    @Override
    public SysResult getGoodById(Integer id) {
        String url = "http://176.201.111.44:8091/findGoodById?id="+id;
        return htClient.doGet(url,SysResult.class);
    }
}
