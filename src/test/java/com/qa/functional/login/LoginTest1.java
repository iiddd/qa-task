package com.qa.functional.login;

import Base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest1 extends BaseTest {

    @BeforeMethod
    private void beforeTest() {
        openTestApp();
        System.out.println("123");
    }

    @Test
    public void test_001() {

    }
}
