package com.automation.web.dataProvider;

import org.testng.annotations.DataProvider;

public class Data {
    @DataProvider(name = "UserData")
    public Object[][] inputData() {
        return new Object[][]{{new UserData()}};
    }
}
