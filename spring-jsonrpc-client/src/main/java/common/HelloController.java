package common;

import common.domain.Product;
import common.domain.ProductParam;
import common.service.ExampleService;
import common.service.ProductJsonRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {


    @Autowired
    private ExampleService exampleService;

    @Autowired
    private ProductJsonRpcService productJsonRpcService;

    @RequestMapping("/hello")
    public String index() {
        int id = exampleService.multiplier(3, 9);
        return "result:" + id;
    }

    @RequestMapping("/product")
    public String buyProduct() {
        Product product = productJsonRpcService.findOne("1");
        return "result:" + product.toString();
    }

    @RequestMapping("/products")
    public String buyProducts() {
        ProductParam productParam = new ProductParam();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("2");
        strings.add("7");
        productParam.setIds(strings);

        List<Product> products = productJsonRpcService.findAll(productParam);
        return "result:" + products.toString();
    }

}