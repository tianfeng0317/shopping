package com.shopping.demo.api;

import com.shopping.demo.entity.PProductDO;
import com.shopping.demo.product.form.SaveProductForm;
import com.shopping.demo.result.ResultData;
import com.shopping.demo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @Author :tianfeng
 * @Date : 2020/12/1 10:49
 * @Description:
 */
@RestController
@RequestMapping("productApi")
public class ProductApi {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProductService productService;

    @RequestMapping(value = "queryProduct", method = RequestMethod.POST)
    @ResponseBody
    public ResultData queryProduct(String productId){
        logger.info("查询商品，productId：" + productId);
        PProductDO pProductDO = productService.queryProduct(productId);
        Optional<PProductDO> productDOOptional = Optional.ofNullable(pProductDO);
        return ResultData.success(productDOOptional);
    }

    @RequestMapping(value = "saveProduct", method = RequestMethod.POST)
    @ResponseBody
    public ResultData saveProduct(@RequestBody SaveProductForm saveProductForm){
        PProductDO pProductDO = productService.saveProduct(saveProductForm);
        Optional<PProductDO> productDOOptional = Optional.ofNullable(pProductDO);
        return ResultData.success(productDOOptional);
    }

}
