package com.shopping.kafka.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Labels {

    private String app;

    @JsonProperty("pod-template-hash")
    private String pod_template_hash;

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getPod_template_hash() {
        return pod_template_hash;
    }

    public void setPod_template_hash(String pod_template_hash) {
        this.pod_template_hash = pod_template_hash;
    }
}
