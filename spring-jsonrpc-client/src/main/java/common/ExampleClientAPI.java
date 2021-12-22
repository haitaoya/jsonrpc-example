package common;

import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;

@JsonRpcService("rpc/calculator")
public interface ExampleClientAPI {
	int multiplier(@JsonRpcParam(value = "a") int a, @JsonRpcParam(value = "b") int b);

	// int multiplier(int a, int b);
}
