package com.ml.aweb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ml.aweb.dao.ProductImageDao;
import com.ml.aweb.entity.Product;
import com.ml.aweb.entity.ProductImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Productimage)表服务接口
 *
 * @author makejava
 * @since 2020-10-23 14:29:52
 */

@Service
public class ProductImageService {

    private static final String TYPE_SINGLE = "single";
    private static final String TYPE_DETAIL = "detail";
    @Autowired
    ProductImageDao productImageDao;

    public void setFirstProductImage(Product product) {
        List<ProductImage> singleImages = listSingleProductImages(product);
        if(!singleImages.isEmpty())
            product.setFirstProductImage(singleImages.get(0));
        else
            product.setFirstProductImage(new ProductImage());
        //这样做是考虑到产品还没有来得及设置图片，但是在订单后台管理里查看订单项的对应产品图片。
    }

    public void setFirstProductImages(List<Product> products) {
        for (Product product : products)
            setFirstProductImage(product);
    }


//    @Cacheable(key="'productImages-single-pid-'+ #p0.id")
    public List<ProductImage> listSingleProductImages(Product product) {
        QueryWrapper<ProductImage> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pid", product.getId());
        queryWrapper.eq("type", TYPE_SINGLE);
        queryWrapper.orderByDesc("id");
        return productImageDao.selectList(queryWrapper);
    }
//    @Cacheable(key="'productImages-detail-pid-'+ #p0.id")
    public List<ProductImage> listDetailProductImages(Product product) {
        QueryWrapper<ProductImage> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pid", product.getId());
        queryWrapper.eq("type", TYPE_DETAIL);
        queryWrapper.orderByDesc("id");
        return productImageDao.selectList(queryWrapper);
    }

}