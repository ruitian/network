package lib.Model;

import java.security.PrivateKey;
import java.util.PriorityQueue;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

/**
 * Created by baron on 15-9-10.
 */
public class User {
    private String password;
    private String phone;
    private String username;
    private String sex;

    public User() {
        super();
    }

    public User(String username, String password, String phone, String sex) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.sex = sex;
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

    public String getSex() {
        return sex;
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

    public void setSex(String sex) {
        this.sex = sex;
    }

}
