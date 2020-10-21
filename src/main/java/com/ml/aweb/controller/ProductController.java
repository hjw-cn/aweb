package com.ml.aweb.controller;

import com.ml.aweb.dao.ProductDAO;
import com.ml.aweb.entity.Product;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author hanjiawei
 * @date 2020-10-21
 */
@Controller
public class ProductController {
    @Autowired
    ProductDAO productDAO;

    // 每页数量
    @GetMapping("/listProduct")
    public String listProduct(Model m,
                              @RequestParam(value = "start",defaultValue = "0") int start,
                              @RequestParam(value = "size",defaultValue = "10") int size)
    {
        String query = "商品";
        NativeSearchQuery searchQuery = getEntitySearchQuery(start, size, query);
        Page<Product> page = productDAO.search(searchQuery);
        m.addAttribute("page",page);
        return "listProduct";
    }

    private NativeSearchQuery getEntitySearchQuery(int start, int size, String searchContent) {
//        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("place", "浙江");
        // 设置价格降序
        Sort sort  = Sort.by(Sort.Direction.DESC,"price");
        // 设置分页
        Pageable pageable = PageRequest.of(start, size,sort);
        return new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(matchQueryBuilder).build();
    }
}
