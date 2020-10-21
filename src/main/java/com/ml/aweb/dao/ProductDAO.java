package com.ml.aweb.dao;

import com.ml.aweb.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductDAO extends ElasticsearchRepository<Product,Integer> {
}
