package com.plugins.netty.suppor.config;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 服务配置文件类
 * Created by zhangtao on 2015/11/27.
 */
public class Config {

    Map<String,String> hostAndPort= Maps.newConcurrentMap();
    boolean isAlive=false;//是否长连接
    boolean isWatch=false;//是否监听配置文件变化
    Integer connection_timeout=10*1000;//连接超时
    String configFile="/netty_server.properties";//默认项目根路径下配置文件


    public Map<String, String> getHostAndPort() {
        return hostAndPort;
    }

    public void setHostAndPort(Map<String, String> hostAndPort) {
        this.hostAndPort = hostAndPort;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isWatch() {
        return isWatch;
    }

    public void setWatch(boolean watch) {
        isWatch = watch;
    }

    public Integer getConnection_timeout() {
        return connection_timeout;
    }

    public void setConnection_timeout(Integer connection_timeout) {
        this.connection_timeout = connection_timeout;
    }

    public String getConfigFile() {
        return configFile;
    }

    public void setConfigFile(String configFile) {
        this.configFile = configFile;
    }
}
