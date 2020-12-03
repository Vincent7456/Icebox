package com.ice.icebox.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class IceboxConfiguration {

    @ConditionalOnProperty(prefix = "icebox.useIcebox.enabled", value = "true", havingValue = "false")
    public void print() {
        log.info("use icebox configuration.");
    }
}
