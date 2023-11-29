package es.netmind.mypersonalbankapi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config.properties")
@Import({ReposConfig.class, ControllerConfig.class, PropertiesConfig.class})
@ComponentScan(basePackages = {"es.netmind.mypersonalbankapi.controladores", "es.netmind.mypersonalbankapi.persistencia"})
public class SpringConfig {
}