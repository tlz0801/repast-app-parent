package com.aaa.eight.app.fallback;

import com.aaa.eight.app.api.IRepastService;
import com.aaa.eight.app.model.Product;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Project repast-app-parent
 * @Author TLZ
 * @Date Create in 2019/12/20 11:35
 **/
@Component
public class RepastFallback implements FallbackFactory<IRepastService> {
    @Override
    public IRepastService create(Throwable throwable) {
        IRepastService repastService = new IRepastService(){

            @Override
            public List<Product> all() {
                System.out.println("测试登录熔断数据");
                return null;
            }
        };
        return repastService;
    }
}
