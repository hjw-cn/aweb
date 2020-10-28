package com.ml.aweb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ml.aweb.entity.Orderitem;
import com.ml.aweb.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (Orderitem)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-28 11:52:36
 */

@Mapper
public interface OrderitemDao extends BaseMapper<Orderitem> {
}