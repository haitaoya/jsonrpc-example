package server;


import common.service.ExampleService;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.springframework.stereotype.Service;

@Service
@AutoJsonRpcServiceImpl
public class ExampleServiceImpl implements ExampleService {

	public int multiplier(int a, int b) {
		return a * b +1;
	}
}
