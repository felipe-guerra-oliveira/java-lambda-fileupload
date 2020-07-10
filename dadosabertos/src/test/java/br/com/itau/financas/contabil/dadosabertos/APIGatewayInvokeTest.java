package br.com.itau.financas.contabil.dadosabertos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

public class APIGatewayInvokeTest {
	
	@Test
	public void invokeTest() {
		APIGatewayProxyRequestEvent event = new APIGatewayProxyRequestEvent();
		
		Context context = new TestContext();
		String requestid = context.getAwsRequestId();
		
		FileConverterHandler handler = new FileConverterHandler();
		APIGatewayProxyResponseEvent result = handler.handleRequest(event, context);
		
		assertEquals(result.getStatusCode(), 200);
	}

}
