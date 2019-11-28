package me.tcpackfrequency.Warehouse.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Integer USER_ID;
    @Column(name = "USER_NAME")
    private String USER_NAME;
    @Column(name = "USER_PASSWORD")
    private String USER_PASSWORD;
    @Column(name = "USER_ADMIN")
    private boolean USER_ADMIN;

    public User(){
        super();
    }

    public User(Integer USER_ID, String USER_NAME, String USER_PASSWORD) {
        this.USER_ID = USER_ID;
        this.USER_NAME = USER_NAME;
        this.USER_PASSWORD = USER_PASSWORD;
    }

    public Integer getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(Integer USER_ID) {
        this.USER_ID = USER_ID;
    }


    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getUSER_PASSWORD() {
        return USER_PASSWORD;
    }

    public void setUSER_PASSWORD(String USER_PASSWORD) {
        this.USER_PASSWORD = USER_PASSWORD;
    }

    public boolean isUSER_ADMIN() {
        return USER_ADMIN;
    }

    public void setUSER_ADMIN(boolean USER_ADMIN) {
        this.USER_ADMIN = USER_ADMIN;
    }
}
