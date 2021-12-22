package server.product;

import common.domain.Product;
import common.service.ProductJsonRpcService;
import common.domain.ProductParam;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AutoJsonRpcServiceImpl
@Service
public class ProductJsonRpcServiceImpl implements ProductJsonRpcService {

    @Override
    public List<Product> findAll(ProductParam param) {
        System.out.println("接收到请求：");
        System.out.println(param.toString());
        ArrayList<Product> list = new ArrayList<>();
        Product product = new Product();
        product.setId("1");
        product.setPrice(new BigDecimal("12.1"));
        product.setName("test1");
        list.add(product);
        Product product1 = new Product();
        product1.setId("2");
        product1.setPrice(new BigDecimal("12.2"));
        product1.setName("test2");
        list.add(product1);
        return list;
    }

    @Override
    public Product findOne(String id) {
        Product product = new Product();
        product.setId("1");
        product.setPrice(new BigDecimal("12.1"));
        product.setName("test1");
        return product;
    }
}
