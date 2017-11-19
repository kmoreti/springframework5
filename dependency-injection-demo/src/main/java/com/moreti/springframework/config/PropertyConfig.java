package com.moreti.springframework.config;

import com.moreti.springframework.beans.FakeDataSource;
import com.moreti.springframework.beans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
//@PropertySource({"file:${configPath}", "classpath:jms.properties" })
@PropertySources({
        @PropertySource("file:${configPath}"),
        @PropertySource("classpath:jms.properties")
})
public class PropertyConfig {

//    @Autowired
//    Environment env;

    @Value("${sybase.username}")
    String user;
    @Value("${sybase.password}")
    String password;
    @Value("${sybase.url}")
    String url;

    @Value("${moreti.jms.username}")
    String jmsUsername;
    @Value("${moreti.jms.password}")
    String jmsPassword;
    @Value("${moreti.jms.url}")
    String jmsUrl;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(user);
//        fakeDataSource.setUser(env.getProperty("USERNAME"));
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;
    }

    @Bean
    public FakeJmsBroker fakeJmsBroker() {
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setJmsUsername(jmsUsername);
        fakeJmsBroker.setJmsPassword(jmsPassword);
        fakeJmsBroker.setJmsUrl(jmsUrl);
        return fakeJmsBroker;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }


}
