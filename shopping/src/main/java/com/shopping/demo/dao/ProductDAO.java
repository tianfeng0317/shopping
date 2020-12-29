package com.shopping.demo.dao;

import com.shopping.demo.entity.PProductDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author :tianfeng
 * @Date : 2020/12/1 10:50
 * @Description:
 */
@Repository
public interface ProductDAO extends JpaRepository<PProductDO, String> {
    PProductDO findByProductId(String productId);
}
