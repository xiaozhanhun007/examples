package com.zzp.creation.builder;

/**
 * @Description 建造者模式
 * @Author Garyzeng
 * @since 2019.11.22
 **/
public class Config {

    private String ip;

    private String port;

    private String username;

    private String password;

    private Boolean isCache;

    private Config(String ip, String port, String username, String password, Boolean isCache) {
        this.ip = ip;
        this.port = port;
        this.username = username;
        this.password = password;
        this.isCache = isCache;
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

    public static ConfigBuilder builder() {
        return new ConfigBuilder();
    }

    public static class ConfigBuilder{

        private String ip;

        private String port;

        private String username;

        private String password;

        private Boolean isCache;

        private ConfigBuilder() {

        }

        public ConfigBuilder ip(String ip) {
            this.ip = ip;
            return this;
        }

        public ConfigBuilder port(String port) {
            this.port = port;
            return this;
        }

        public ConfigBuilder username(String username) {
            this.username = username;
            return this;
        }

        public ConfigBuilder password(String password) {
            this.password = password;
            return this;
        }

        public ConfigBuilder isCache(Boolean cache) {
            isCache = cache;
            return this;
        }

        public Config build() {
            if (ip == null || ip.equals("")) {
                throw new RuntimeException("ip不能为空");
            }

            if (port == null || port.equals("")) {
                throw new RuntimeException("port不能为空");
            }

            if (username == null || username.equals("")) {
                this.username = "admin";
            }

            if (password == null || password.equals("")) {
                this.password = "123456";
            }

            if (isCache == null) {
                this.isCache = false;
            }

            return new Config(ip, port, username, password, isCache);
        }
    }
}
