package com.hdc.zs.art.empty;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String power;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public User(Integer id, String username, String password, String power) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.power = power;
    }
    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", power='" + power + '\'' +
                '}';
    }
}
