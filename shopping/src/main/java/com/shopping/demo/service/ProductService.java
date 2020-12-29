package com.shopping.demo.service;

import com.shopping.demo.entity.PProductDO;
import com.shopping.demo.product.form.SaveProductForm;

/**
 * @Author :tianfeng
 * @Date : 2020/12/1 10:51
 * @Description:
 */
public interface ProductService {
    PProductDO queryProduct(String productId);

    PProductDO saveProduct(SaveProductForm saveProductForm);
}
