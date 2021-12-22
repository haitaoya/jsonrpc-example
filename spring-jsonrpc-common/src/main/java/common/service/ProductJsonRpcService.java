package common.service;

import common.domain.Product;
import common.domain.ProductParam;
import com.googlecode.jsonrpc4j.JsonRpcService;

import java.util.List;

@JsonRpcService("rpc/products")
public interface ProductJsonRpcService {
    List<Product> findAll(ProductParam param);
    Product findOne(String id);
}
