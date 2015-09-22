package lib.Model;

import javax.swing.*;
import java.security.PrivateKey;
import java.util.PriorityQueue;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

/**
 * Created by baron on 15-9-10.
 */
public class User {
    private String dataid;
    private String password;
    private String phone;
    private String username;
    private String role;
    private String resume;

    public User() {
        super();
    }

    public User(String username, String password, String phone) {
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public User(String username, String phone, String password, String role, String dataid) {
        this.username = username;
        this.phone = phone;
        this.password = password;
        this.role = role;
        this.dataid = dataid;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDataid() {
        return dataid;
    }

    public void setDataid(String dataid) {
        this.dataid = dataid;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}
