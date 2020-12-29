package com.shopping.demo.api;

import com.alibaba.fastjson.JSONObject;
import com.shopping.demo.dao.ProductDAO;
import com.shopping.demo.entity.PProductDO;
import com.shopping.demo.result.ResultData;
import com.shopping.demo.service.ProductService;
import com.shopping.demo.utils.RedisCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @Author :tianfeng
 * @Date : 2020/12/2 10:20
 * @Description: 缓存Api
 */
@RestController
@RequestMapping("/cacheApi")
public class CacheApi {

    private Logger logger = LoggerFactory.getLogger(CacheApi.class);

    private static final String PREFIX = "PRODUCT";

    @Autowired
    RedisCache redisCache;

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/queryProductByCache", method = RequestMethod.POST)
    @ResponseBody
    public ResultData queryProductByCache(String productId){
        String product = redisCache.get(PREFIX, productId);
        if (product != null){
            PProductDO pProductDO = JSONObject.parseObject(product, PProductDO.class);
            return ResultData.success(pProductDO);
        }
        PProductDO pProductDO = productService.queryProduct(productId);
        Optional<PProductDO> optional = Optional.ofNullable(pProductDO);
        if (optional.isPresent()){
            redisCache.set(PREFIX, productId, JSONObject.toJSONString(optional.get()));
        }
        return ResultData.success(optional);
    }

    @RequestMapping(value = "/saveCache", method = RequestMethod.POST)
    @ResponseBody
    public String saveCache(String nameValue){
        for (int i = 10; i <= 10; i++){
            redisCache.set("-", "names" + i, nameValue + i);
        }
        return "success";
    }

    @RequestMapping(value = "/deleteCacheByKey", method = RequestMethod.POST)
    @ResponseBody
    public ResultData deleteCacheByKey(String key){
        redisCache.deleteWithPrefix(PREFIX, key);
        return ResultData.success("操作成功");
    }
}
