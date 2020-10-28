package com.ml.aweb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ml.aweb.dao.OrderitemDao;
import com.ml.aweb.dao.OrderitemJPADao;
import com.ml.aweb.entity.Order;
import com.ml.aweb.entity.Orderitem;
import com.ml.aweb.entity.Product;
import com.ml.aweb.entity.User;
import com.ml.aweb.util.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Orderitem)表服务接口
 *
 * @author makejava
 * @since 2020-10-28 11:52:36
 */

@Service
public class OrderitemService {
    @Autowired
    OrderitemDao orderitemDao;
    @Autowired
    OrderitemJPADao orderitemJPADao;

    public int getSaleCount(Product product) {
//            从缓存中拿数据
//        OrderitemService orderItemService = SpringContextUtil.getBean(OrderitemService.class);
//        List<Orderitem> ois =orderItemService.listByProduct(product);
        List<Orderitem> ois = orderitemJPADao.findByProduct(product);
        int result =0;
        for (Orderitem oi : ois) {
            if(null!=oi.getOrder())
                if(null!= oi.getOrder() && null!=oi.getOrder().getPayDate())
                    result+=oi.getNumber();
        }
        return result;
    }

//    @Cacheable(key="'orderItems-uid-'+ #p0.id")
//    public List<Orderitem> listByUser(User user) {
//        return orderitemJPADao.findByUserAndOrderIsNull(user);
//    }
//
//    @Cacheable(key="'orderItems-pid-'+ #p0.id")
//    public List<Orderitem> listByProduct(Product product) {
//        return orderitemJPADao.findByProduct(product);
//    }
//    @Cacheable(key="'orderItems-oid-'+ #p0.id")
//    public List<Orderitem> listByOrder(Order order) {
//        return orderitemJPADao.findByOrderOrderByIdDesc(order);
//    }

}