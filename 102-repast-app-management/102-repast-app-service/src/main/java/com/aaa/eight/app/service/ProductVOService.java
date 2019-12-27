package com.aaa.eight.app.service;

import com.aaa.eight.app.base.BaseService;
import com.aaa.eight.app.mapper.ProductVOMapper;
import com.aaa.eight.app.util.JSONUtil;
import com.aaa.eight.app.vo.PageVO;
import com.aaa.eight.app.vo.ProductVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.ArrayList;
import java.util.List;

import static com.aaa.eight.app.staticproperties.StaticProperties.*;

/**
 * @Project repast-app-parent
 * @Author TLZ
 * @Date Create in 2019/12/23 15:51
 **/
@Service
public class ProductVOService extends BaseService<ProductVO> {

    /**
     * 商品缓存redis的前部分key
     */
    @Value("${redis_productvo_key}")
    private String productvoKey;

    /**
     * 商店某类商品缓存redis的前部分key
     */
    @Value("${redis_shop_productcate_key}")
    private String productvoCateKey;

    @Autowired
    private ProductVOMapper productVOMapper;


    @Override
    public Mapper<ProductVO> getMapper() {
        return productVOMapper;
    }

     /**
       *    根据商品编号查询多表详情数据
       *    先查询redis，再查数据库
       *@Author TLZ
       *@Date 22:57  2019/12/23
       *@Param
       *@return
       **/
    public List<ProductVO> selectProductById(RedisService redisService,@Param("productId")Long productId){
        /*Map<String, Object> resultMap = new HashMap<String, Object>();*/
        String productvoString = redisService.get(productvoKey + productId);
        List<ProductVO> productVOList = productVOMapper.selectProductById(productId);
        String id =""+productId;
        if ( null == productvoString|| "".equals(productvoString) ){
            if (productVOList.size()>0){
                saveRedis(redisService,productvoKey,id, productVOList);
                return productVOList;
            }else {
                /*resultMap.put(CODE, StatusEnum.SYSTEM_EXCEPTION.getCode());
                resultMap.put(MSG, StatusEnum.SYSTEM_EXCEPTION.getMsg());*/
                return null;
            }
        }else {
            List<ProductVO> productVORedisList = JSONUtil.toList(productvoString, ProductVO.class);
            if (productVOList.size() == productVORedisList.size()){
                /*resultMap.put(CODE, StatusEnum.SUCCESS.getCode());
                resultMap.put(MSG, StatusEnum.SUCCESS.getMsg());
                resultMap.put(DATA, productVORedisList);*/
            } else {
                /*resultMap.put(CODE, StatusEnum.SUCCESS.getCode());
                resultMap.put(MSG, StatusEnum.SUCCESS.getMsg());
                resultMap.put(DATA, productVORedisList);*/
                saveRedis(redisService,productvoKey,id, productVOList);
            }
            return productVORedisList;
        }
    }
     /**
       *    查询某店铺的某一类商品
       *@Author TLZ
       *@Date 11:27  2019/12/25
       *@Param
       *@return
       **/
    public List<ProductVO> selectProductByCateInShop(RedisService redisService,@Param("cateId")Long cateId,@Param("shopId")Long shopId){
        /*Map<String, Object> resultMap = new HashMap<String, Object>();*/
        String id = ""+cateId+shopId;
        String productvoCateString = redisService.get(productvoCateKey + id);
        List<ProductVO> productVOList = productVOMapper.selectProductByCateInShop(cateId,shopId);
        if ( null == productvoCateString|| "".equals(productvoCateString) ){
            if (productVOList.size()>0){
                saveRedis(redisService,productvoCateKey,id, productVOList);
                return productVOList;
            }else {
                /*resultMap.put(CODE, StatusEnum.SYSTEM_EXCEPTION.getCode());
                resultMap.put(MSG, StatusEnum.SYSTEM_EXCEPTION.getMsg());*/
                return null;
            }
        }else {
            List<ProductVO> productVORedisList = JSONUtil.toList(productvoCateString, ProductVO.class);
            if (productVOList.size() == productVORedisList.size()){
                /*resultMap.put(CODE, StatusEnum.SUCCESS.getCode());
                resultMap.put(MSG, StatusEnum.SUCCESS.getMsg());
                resultMap.put(DATA, productVORedisList);*/
            } else {
                /*resultMap.put(CODE, StatusEnum.SUCCESS.getCode());
                resultMap.put(MSG, StatusEnum.SUCCESS.getMsg());
                resultMap.put(DATA, productVORedisList);*/
                saveRedis(redisService,productvoCateKey,id, productVOList);
            }
            return productVORedisList;
        }
    }

     /**
       *    根据关键字模糊查询商品多表信息
       *@Author TLZ
       *@Date 14:33  2019/12/24
       *@Param
       *@return
       **/
    public List<PageVO> selectProductByKeyword(@Param("keyword")String keyword, @Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize){
        /*Map<String, Object> resultMap = new HashMap<String, Object>();*/
        List<PageVO> pageVOList = new ArrayList<PageVO>();
        int totalNum;
        if(pageSize<=0){
            totalNum = pageSize;
        }else {
            totalNum = productVOMapper.count(keyword);
        }
        PageVO<ProductVO> pageVo = new PageVO<>(currentPage,pageSize,totalNum);
        List<ProductVO> productVOList = productVOMapper.selectProductByKeyword(keyword, pageVo.getStartIndex(), pageSize);
        pageVo.setItems(productVOList);
        pageVo.setTotalNum(totalNum);
        if ( null == productVOList|| "".equals(productVOList) ){
            /*resultMap.put(CODE, StatusEnum.SYSTEM_EXCEPTION.getCode());
            resultMap.put(MSG, StatusEnum.SYSTEM_EXCEPTION.getMsg());*/
            return null;
        }else {
            /*resultMap.put(CODE, StatusEnum.SUCCESS.getCode());
            resultMap.put(MSG, StatusEnum.SUCCESS.getMsg());
            resultMap.put(DATA, pageVo);*/
            pageVOList.add(pageVo);
            return pageVOList;
        }
    }

     /**
       *    根据关键字查询商品总条数
       *@Author TLZ
       *@Date 11:29  2019/12/25
       *@Param
       *@return
       **/
    public Integer count(@Param("keyword")String keyword){
        return productVOMapper.count(keyword);
    }



     /**
       *  向redis中保存商品多表信息数据
       *@Author TLZ
       *@Date 22:57  2019/12/23
       *@Param
       *@return
       **/
    private List<ProductVO> saveRedis(RedisService redisService,String key,String id, List<ProductVO> productVOList) {
        /*Map<String, Object> saveRedisResult = new HashMap<String, Object>();*/
        String productvoListStr = JSONUtil.toJsonString(productVOList);
        try {
            String addResult = redisService.set(key+id, productvoListStr);
            // 5.判断redis是否保存成功
            if(OK.equals(addResult.toUpperCase())) {
                // 说明redis保存成功
                /*saveRedisResult.put(CODE, StatusEnum.SUCCESS.getCode());
                saveRedisResult.put(MSG, StatusEnum.SUCCESS.getMsg());
                saveRedisResult.put(DATA, productVOList);*/
            } else {
                // 说明保存失败
                // 无论失败还是成功都不要再判断了
                redisService.set(key+id, productvoListStr);
                /*saveRedisResult.put(CODE, StatusEnum.REDIS_FAILED.getCode());
                saveRedisResult.put(MSG, StatusEnum.REDIS_FAILED.getMsg());
                saveRedisResult.put(DATA, productVOList);*/
            }return productVOList;
        } catch (Exception e) {
            e.printStackTrace();
            redisService.set(key+id, productvoListStr);
            /*saveRedisResult.put(CODE, StatusEnum.REDIS_EXCEPTION.getCode());
            saveRedisResult.put(MSG, StatusEnum.REDIS_EXCEPTION.getMsg());
            saveRedisResult.put(DATA, productVOList);*/
            return productVOList;
        }
    }

}
