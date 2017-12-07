package com.example;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(ids = {"com.example:server:+:stubs:8080"}, workOffline = true)
public class ClientTest {

    @Autowired
    private Client client;


    @Test
    public void shouldSayHello() throws Exception {
        MockMvc build = MockMvcBuilders.standaloneSetup(client).build();

        MvcResult mvcResult = build.perform(MockMvcRequestBuilders.get("/")).andReturn();

        Assertions.assertThat(mvcResult.getResponse().getContentAsString()).isEqualTo("Hello");

    }
}
