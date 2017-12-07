package com.example.com.example.server;

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
					.get("/managed/forenames?match=Krystian Sola");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
			assertThatJson(parsedJson).field("['pageSize']").isEqualTo(0);
			assertThatJson(parsedJson).field("['numberOfPages']").isEqualTo(0);
			assertThatJson(parsedJson).field("['total']").isEqualTo(0);
			assertThatJson(parsedJson).field("['page']").isEqualTo(0);
			assertThatJson(parsedJson).array("['values']").contains("['value']").isEqualTo("krystian");
	}

}
