package com.ml.aweb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ml.aweb.dao.ReviewDao;
import com.ml.aweb.dao.ReviewJPADao;
import com.ml.aweb.entity.Product;
import com.ml.aweb.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Review)表服务接口
 *
 * @author makejava
 * @since 2020-10-28 14:23:49
 */
@Service
public class ReviewService {
    @Autowired
    ReviewDao reviewDao;
    @Autowired
    ReviewJPADao reviewJPADao;


    public int getCount(Product product) {
        return reviewJPADao.countByProduct(product);
    }
}