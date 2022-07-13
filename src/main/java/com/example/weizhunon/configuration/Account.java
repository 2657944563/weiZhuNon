package com.example.weizhunon.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope("prototype")
public class Account {
    @Value("1")
    private Integer id;
    @Value("tome")
    private String name;
    @Value("2000")
    private Float money;
}
