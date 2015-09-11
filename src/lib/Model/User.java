package lib.Model;

import java.util.ResourceBundle;
import java.util.StringTokenizer;

/**
 * Created by baron on 15-9-10.
 */
public class User {
    private String password;
    private String phone;
    public User() {
        super();
    }

//    public User(String username, String password, String phone, String sex, String resume) {
//        this.username = username;
//        this.password = password;
//        this.phone = phone;
//        this.sex = sex;
//        this.resume = resume;
//    }

    public User(String password, String phone) {
        this.password = password;
        this.phone = phone;

    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
