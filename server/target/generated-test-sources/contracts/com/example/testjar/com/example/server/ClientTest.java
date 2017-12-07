package com.example.testjar.com.example.server;

import com.example.MvcTest;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import io.restassured.response.ResponseOptions;
import org.junit.Test;

import static com.toomuchcoding.jsonassert.JsonAssertion.assertThatJson;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.springframework.cloud.contract.verifier.assertion.SpringCloudContractAssertions.assertThat;

public class ClientTest extends MvcTest {

	@Test
	public void validate_shouldSayHello() throws Exception {
		// given:
			MockMvcRequestSpecification request = given();

		// when:
			ResponseOptions response = given().spec(request)
					.get("/");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
		// and:
			String responseBody = response.getBody().asString();
			assertThat(responseBody).isEqualTo("Hello");
	}

}
