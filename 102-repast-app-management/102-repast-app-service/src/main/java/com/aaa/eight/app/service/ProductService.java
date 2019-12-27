package com.aaa.eight.app.service;

import com.aaa.eight.app.base.BaseService;
import com.aaa.eight.app.mapper.ProductMapper;
import com.aaa.eight.app.model.Product;
import com.aaa.eight.app.status.StatusEnum;
import com.aaa.eight.app.util.JSONUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import static com.aaa.eight.app.staticproperties.StaticProperties.*;

/**
 * @Project repast-app-parent
 * @Author TLZ
 * @Date Create in 2019/12/20 10:38
 **/
@Service
public class ProductService extends BaseService<Product> {

    @Value("${redis_shop_product_key}")
    private String shopProductKey;
    @Autowired
    private ProductMapper productMapper;
    @Override
    public Mapper<Product> getMapper() {
        return productMapper;
    }

    public List<Product> allProductByShopId(RedisService redisService,@Param("shopId") Long shopId){
        /*Map<String, Object> resultMap = new HashMap<String, Object>();*/
        String productString = redisService.get(shopProductKey + shopId);
        List<Product> products = productMapper.allProductByShopId(shopId);
        if ( null == productString|| "".equals(productString) ){
            if (products.size()>0){
                saveRedis(redisService, shopId, products);
                return products;
            }else {
                /*resultMap.put(CODE, StatusEnum.SYSTEM_EXCEPTION.getCode());
                resultMap.put(MSG, StatusEnum.SYSTEM_EXCEPTION.getMsg());*/
                return null;
            }
        }else {
            List<Product> productRedisList = JSONUtil.toList(productString, Product.class);
            if (products.size() == productRedisList.size()){
                /*resultMap.put(CODE, StatusEnum.SUCCESS.getCode());
                resultMap.put(MSG, StatusEnum.SUCCESS.getMsg());
                resultMap.put(DATA, productRedisList);*/

            } else {
                /*resultMap.put(CODE, StatusEnum.SUCCESS.getCode());
                resultMap.put(MSG, StatusEnum.SUCCESS.getMsg());
                resultMap.put(DATA, productRedisList);*/
                saveRedis(redisService,shopId,products);
            }
            return productRedisList;
        }
    }



    public List<Product> allProduct(){
        return productMapper.allProduct();
    }



    private List<Product> saveRedis(RedisService redisService,Long shopId, List<Product> products) {
        /*Map<String, Object> saveRedisResult = new HashMap<String, Object>();*/
        String productvoListStr = JSONUtil.toJsonString(products);
        try {
            String addResult = redisService.set(shopProductKey+shopId, productvoListStr);
            // 5.判断redis是否保存成功
            if(OK.equals(addResult.toUpperCase())) {
                // 说明redis保存成功
                /*saveRedisResult.put(CODE, StatusEnum.SUCCESS.getCode());
                saveRedisResult.put(MSG, StatusEnum.SUCCESS.getMsg());
                saveRedisResult.put(DATA, products);*/
            } else {
                // 说明保存失败
                // 无论失败还是成功都不要再判断了
                redisService.set(shopProductKey+shopId, productvoListStr);
                /*saveRedisResult.put(CODE, StatusEnum.REDIS_FAILED.getCode());
                saveRedisResult.put(MSG, StatusEnum.REDIS_FAILED.getMsg());
                saveRedisResult.put(DATA, products);*/

            }return products;
        } catch (Exception e) {
            e.printStackTrace();
            redisService.set(shopProductKey+shopId, productvoListStr);
            /*saveRedisResult.put(CODE, StatusEnum.REDIS_EXCEPTION.getCode());
            saveRedisResult.put(MSG, StatusEnum.REDIS_EXCEPTION.getMsg());
            saveRedisResult.put(DATA, products);*/
            return products;
        }
    }



    public List<Product> all(){
        List<Product> all = productMapper.selectAll();
        /*if (null == all){
            hashMap.put("code", StatusEnum.NOT_EXIST.getCode());
            hashMap.put("msg", StatusEnum.NOT_EXIST.getMsg());
        }*/
        return all;
    }


}
