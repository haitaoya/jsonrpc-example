package common;

import java.net.MalformedURLException;
import java.net.URL;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcClientProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationClientConfig {
//	private static final String endpoint = "http://localhost:8080/calculator";
//下方是指定固定的Service进行rpc代理
//	@Bean
//	public JsonRpcHttpClient jsonRpcHttpClient() {
//		URL url = null;
//		// You can add authentication headers etc to this map
//		Map<String, String> map = new HashMap<String, String>();
//		try {
//			url = new URL(ApplicationClientConfig.endpoint);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		return new JsonRpcHttpClient(url, map);
//	}
//
//	@Bean
//	public ExampleClientAPI exampleClientAPI(JsonRpcHttpClient jsonRpcHttpClient) {
//		return ProxyUtil.createClientProxy(getClass().getClassLoader(), ExampleClientAPI.class, jsonRpcHttpClient);
//	}

	@Bean
	@ConditionalOnProperty(value = {"rpc.client.url","rpc.client.basePackage"})
	public AutoJsonRpcClientProxyCreator rpcClientProxyCreator(@Value("${rpc.client.url}") String url, @Value("${rpc.client.basePackage}") String basePackage) {
		AutoJsonRpcClientProxyCreator creator = new AutoJsonRpcClientProxyCreator();
		try {
			creator.setBaseUrl(new URL(url));
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		creator.setScanPackage(basePackage);
		return creator;
	}
}
