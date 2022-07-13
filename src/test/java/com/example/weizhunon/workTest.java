package com.example.weizhunon;

import com.example.weizhunon.configuration.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class workTest {
    @Autowired
    Account account;

    @Test
    public void a() {
        System.out.println(account.getId());
        System.out.println(account.getName());
        System.out.println(account.getMoney());
    }
}
