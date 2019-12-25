package com.gt.service;

import com.gt.entity.GoodProperty;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 何水告
 * @create 2019/12/25
 * 男人之所以努力，是为了获得更好的交配权
 */
@Service
public interface FindGoodByMyIdServer {
    List<GoodProperty> findGoodByMyIds(Long sellerId);

    void deleteGood(Long goodId);
}
