package com.tr1nksgroup.model.components;

import com.tr1nksgroup.config.properties.InitialUnitsProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Resource
    InitialUnitsProperties initialUnitsProperties;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println(initialUnitsProperties.getTestcase1());
    }
}