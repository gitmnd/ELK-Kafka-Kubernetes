package com.shopping.kafka.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

public class Root {

    @JsonProperty("beat")
    private Beat beat;

    @JsonProperty("@version")
    private String version;

    @JsonProperty("source")
    private String source;

    @JsonProperty("@timestamp")
    private Date timestamp;

    @JsonProperty("log")
    private Log log;

    @JsonProperty("tags")
    private ArrayList<String> tags;

    @JsonProperty("host")
    private Host host;

    @JsonProperty("input")
    private Input input;

    @JsonProperty("offset")
    private int offset;

    @JsonProperty("kubernetes")
    private Kubernetes kubernetes;

    @JsonProperty("stream")
    private String stream;

    @JsonProperty("message")
    private String message;

    @JsonProperty("prospector")
    private Prospector prospector;

    @Override
    public String toString() {
        return "Root{" +
                "beat=" + beat +
                ", version='" + version + '\'' +
                ", source='" + source + '\'' +
                ", timestamp=" + timestamp +
                ", log=" + log +
                ", tags=" + tags +
                ", host=" + host +
                ", input=" + input +
                ", offset=" + offset +
                ", kubernetes=" + kubernetes +
                ", stream='" + stream + '\'' +
                ", message='" + message + '\'' +
                ", prospector=" + prospector +
                '}';
    }

    public Beat getBeat() {
        return beat;
    }

    public void setBeat(Beat beat) {
        this.beat = beat;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public Kubernetes getKubernetes() {
        return kubernetes;
    }

    public void setKubernetes(Kubernetes kubernetes) {
        this.kubernetes = kubernetes;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Prospector getProspector() {
        return prospector;
    }

    public void setProspector(Prospector prospector) {
        this.prospector = prospector;
    }
}
