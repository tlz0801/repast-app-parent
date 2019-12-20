package com.aaa.eight.app.api;

import com.aaa.eight.app.fallback.RepastFallback;
import com.aaa.eight.app.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Project repast-app-parent
 * @Author TLZ
 * @Date Create in 2019/12/20 11:34
 **/
@FeignClient(value = "product-interface-provider", fallbackFactory = RepastFallback.class)
public interface IRepastService {

    @PostMapping("/allProduct")
    List<Product> allProduct();
}
