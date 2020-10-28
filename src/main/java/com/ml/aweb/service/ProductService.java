package com.ml.aweb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ml.aweb.dao.ProductDao;
import com.ml.aweb.entity.Category;
import com.ml.aweb.entity.Product;
import com.ml.aweb.util.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hanjiawei
 * @date 2020-10-23
 */

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;

    @Autowired
    ProductImageService productImageService;

    @Autowired
    OrderitemService orderitemService;
    @Autowired
    ReviewService reviewService;

    private List<Product> listByCategory(Category category){
        return productDao.selectList(new QueryWrapper<Product>().eq("cid", category.getId()));
    }

    public void fill(List<Category> categorys) {
        for (Category category : categorys) {
            fill(category);
        }
    }

    public void fill(Category category) {
        ProductService productService = SpringContextUtil.getBean(ProductService.class);
        List<Product> products = productService.listByCategory(category);
        productImageService.setFirstProductImages(products);
        category.setProducts(products);
    }

    public void fillByRow(List<Category> categorys) {
        int productNumberEachRow = 8;
        for (Category category : categorys) {
            List<Product> products =  category.getProducts();
            List<List<Product>> productsByRow =  new ArrayList<>();
            for (int i = 0; i < products.size(); i+=productNumberEachRow) {
                int size = i+productNumberEachRow;
                size= Math.min(size, products.size());
                List<Product> productsOfEachRow =products.subList(i, size);
                productsByRow.add(productsOfEachRow);
            }
            category.setProductsByRow(productsByRow);
        }
    }

    public void setSaleAndReviewNumber(Product product) {
        int saleCount = orderitemService.getSaleCount(product);
        product.setSaleCount(saleCount);


        int reviewCount = reviewService.getCount(product);
        product.setReviewCount(reviewCount);

    }


    public void setSaleAndReviewNumber(List<Product> products) {
        for (Product product : products)
            setSaleAndReviewNumber(product);
    }

    public Product getProductById(Long pid){
        Product product = productDao.selectById(pid);
        productImageService.setFirstProductImage(product);
        return productDao.selectById(pid);
    }
}
