package com.dmall;

import com.dmall.inventory.Application;
import com.dmall.inventory.apis.InventoryController;
import com.dmall.inventory.dao.InventoryRepository;
import com.dmall.inventory.domain.model.Inventory;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.when;

@Ignore
@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class InventoryBase {

    @Autowired
    WebApplicationContext wac;

    @Before
    public void setup() {
        RestAssuredMockMvc.webAppContextSetup(wac);
    }
}
