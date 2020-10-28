package com.ml.aweb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ml.aweb.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * (Category)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-23 10:37:53
 */
public interface CategoryDao extends BaseMapper<Category> {
}