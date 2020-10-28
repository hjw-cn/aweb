package com.ml.aweb.dao;

import com.ml.aweb.entity.Product;
import com.ml.aweb.entity.Review;

import java.util.List;

public interface ReviewJPADao {
    List<Review> findByProductOrderByIdDesc(Product product);
    int countByProduct(Product product);
}
