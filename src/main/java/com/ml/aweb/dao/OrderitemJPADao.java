package com.ml.aweb.dao;

import java.util.List;

import com.ml.aweb.entity.Order;
import com.ml.aweb.entity.Orderitem;
import com.ml.aweb.entity.Product;
import com.ml.aweb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderitemJPADao extends JpaRepository<Orderitem,Integer>{
    List<Orderitem> findByOrderOrderByIdDesc(Order order);
    List<Orderitem> findByProduct(Product product);
    List<Orderitem> findByUserAndOrderIsNull(User user);
}

