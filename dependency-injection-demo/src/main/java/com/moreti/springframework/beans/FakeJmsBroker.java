package com.moreti.springframework.beans;

import org.springframework.beans.factory.annotation.Value;

public class FakeJmsBroker {
    String jmsUsername;
    String jmsPassword;
    String jmsUrl;

    public String getJmsUsername() {
        return jmsUsername;
    }

    public void setJmsUsername(String jmsUsername) {
        this.jmsUsername = jmsUsername;
    }

    public String getJmsPassword() {
        return jmsPassword;
    }

    public void setJmsPassword(String jmsPassword) {
        this.jmsPassword = jmsPassword;
    }

    public String getJmsUrl() {
        return jmsUrl;
    }

    public void setJmsUrl(String jmsUrl) {
        this.jmsUrl = jmsUrl;
    }

    @Override
    public String toString() {
        return "FakeJmsBroker{" +
                "jmsUsername='" + jmsUsername + '\'' +
                ", jmsPassword='" + jmsPassword + '\'' +
                ", jmsUrl='" + jmsUrl + '\'' +
                '}';
    }
}
