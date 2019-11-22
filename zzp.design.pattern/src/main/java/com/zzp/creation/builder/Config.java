package com.zzp.creation.builder;

/**
 * @Description
 * @Author Garyzeng
 * @since 2019.11.22
 **/
public class Config {

    private String ip;

    private String port;

    private String username;

    private String password;

    private Boolean isCache;

    private Config() {

    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getCache() {
        return isCache;
    }

    public void setCache(Boolean cache) {
        isCache = cache;
    }

    private static class ConfigBuilder{

        private String ip;

        private String port;

        private String username;

        private String password;

        private Boolean isCache;

        public void ip(String ip) {
            this.ip = ip;
        }

        public void port(String port) {
            this.port = port;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setCache(Boolean cache) {
            isCache = cache;
        }
    }
}
