package com.example;

import org.junit.Before;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

public class MvcTest {

    @Before
    public void before() {
        RestAssuredMockMvc.standaloneSetup(new Server());
    }
}
