package lib.Model;

import javax.swing.*;
import java.security.PrivateKey;
import java.util.PriorityQueue;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

/**
 * Created by baron on 15-9-10.
 */
public abstract class User {
    private String password;
    private String phone;
    private String username;
    private String level;

    public User() {
        super();
    }

    public User(String username, String password, String phone, String sex) {
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public User(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
