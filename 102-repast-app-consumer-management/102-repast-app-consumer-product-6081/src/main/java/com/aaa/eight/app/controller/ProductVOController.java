package com.aaa.eight.app.controller;

import com.aaa.eight.app.api.IRepastService;
import com.aaa.eight.app.base.BaseController;
import com.aaa.eight.app.base.ResultData;
import com.aaa.eight.app.vo.PageVO;
import com.aaa.eight.app.vo.ProductVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.aaa.eight.app.staticproperties.StaticProperties.NO_DATA;


/**
 * @Project repast-app-parent
 * @Author TLZ
 * @Date Create in 2019/12/23 16:04
 **/
@RestController
@Api(value = "商品多表信息", tags = "商品多表信息接口")
public class ProductVOController extends BaseController {
    @Autowired
    private IRepastService repastService;

    @PostMapping("/selectProductById")
    @ApiOperation(value = "查询商品联合信息", notes = "执行查询商品联合信息的操作")
    public ResultData selectProductById(String token, @RequestParam("productId")Long productId){
        if(null==token){
            return getTokenFailed();
        }
        List<ProductVO> productVOList = repastService.selectProductById(productId);
        if(!"".equals(productVOList)){
            return success(productVOList);
        }
        return failed();
    }

    @PostMapping("/selectProductByKeyword")
    @ApiOperation(value = "根据关键字查询商品联合信息", notes = "执行根据关键字查询商品联合信息的操作")
    public ResultData selectProductByKeyword(String token, @RequestParam("keyword")String keyword,@RequestParam("currentPage")Integer currentPage,@RequestParam("pageSize")Integer pageSize){
        if(null==token){
            return getTokenFailed();
        }
        List<PageVO> pageVOList = repastService.selectProductByKeyword(keyword, currentPage, pageSize);
        if(!"".equals(pageVOList)){
            if(pageVOList.get(1).getItems().size()==0){
                return failed(NO_DATA);
            }else {
                return success(pageVOList);
            }
        }
        return failed();
    }

    @PostMapping("/selectProductByCateInShop")
    @ApiOperation(value = "根据店铺编号和商品类别查询某店铺的某类商品联合信息", notes = "执行根据店铺编号和商品类别查询某店铺的某类商品联合信息的操作")
    public ResultData selectProductByCateInShop(String token, @RequestParam("cateId")Long cateId,@RequestParam("shopId")Long shopId){
        if(null==token){
            return getTokenFailed();
        }
        List<ProductVO> productVOList = repastService.selectProductByCateInShop(cateId, shopId);
        if(!"".equals(productVOList)){
            return success(productVOList);
        }
        return failed();
    }


}
