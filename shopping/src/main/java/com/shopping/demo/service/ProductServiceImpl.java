package com.shopping.demo.service;

import com.shopping.demo.dao.ProductDAO;
import com.shopping.demo.entity.PProductDO;
import com.shopping.demo.product.form.SaveProductForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * @Author :tianfeng
 * @Date : 2020/12/1 10:51
 * @Description:
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductDAO productDAO;

    @Override
    @Transactional(readOnly = true)
    public PProductDO queryProduct(String productId) {
        return productDAO.findByProductId(productId);
    }

    @Override
    @Transactional
    public PProductDO saveProduct(SaveProductForm saveProductForm) {
        PProductDO pProductDO = new PProductDO();
        BeanUtils.copyProperties(saveProductForm, pProductDO);
        String productId = UUID.randomUUID().toString().replace("-", "");
        pProductDO.setProductId(productId);
        Date date = new Date();
        pProductDO.setCreateDate(date);
        pProductDO.setModifyUser(saveProductForm.getCreateUser());
        pProductDO.setLastModifyDate(date);
        return productDAO.save(pProductDO);
    }
}
