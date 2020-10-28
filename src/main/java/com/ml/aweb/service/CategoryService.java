package com.ml.aweb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ml.aweb.dao.CategoryDao;
import com.ml.aweb.entity.Category;
import com.ml.aweb.entity.Product;
import com.ml.aweb.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hanjiawei
 * @date 2020-10-23
 */

@Service
public class CategoryService {
    @Autowired
    CategoryDao categoryDao;

    public Page4Navigator<Category> list(int start,int size,int navigatorPages){
//        Sort sort = Sort.by(Sort.Direction.DESC, "id");
//        new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>()
//        Page pageFromJPA =categoryDao.findAll(pageable);
        IPage<Category> page = new Page<>(start/size,size);

        IPage<Category> iPage = categoryDao.selectPage(page, new QueryWrapper<Category>().orderByDesc("id"));


        return new Page4Navigator<>(iPage,navigatorPages);
    }

    public List<Category> list(){
        return categoryDao.selectList(new QueryWrapper<Category>());
    }

    //这个方法的用处是删除Product对象上的 分类。 为什么要删除呢？
    // 因为在对分类做序列还转换为 json 的时候，会遍历里面的 products, 然后遍历出来的产品上，又会有分类，接着就开始子子孙孙无穷溃矣地遍历了，就搞死个人了
    //而在这里去掉，就没事了。 只要在前端业务上，没有通过产品获取分类的业务，去掉也没有关系

    public void removeCategoryFromProduct(List<Category> cs) {
        for (Category category : cs) {
            removeCategoryFromProduct(category);
        }
    }
    public void removeCategoryFromProduct(Category category) {
        List<Product> products =category.getProducts();
        if(null!=products) {
            for (Product product : products) {
                product.setCid(-1L);
            }
        }

        List<List<Product>> productsByRow =category.getProductsByRow();
        if(null!=productsByRow) {
            for (List<Product> ps : productsByRow) {
                for (Product p: ps) {
                    p.setCid(-1L);
                }
            }
        }
    }
}
