package lib.Model;

/**
 * Created by baron on 15-9-14.
 */
public class Customer extends User{
    private String resume;
    private String sex;

    public Customer() {
        super();
    }
    public Customer(String phone, String password) {
        super(phone, password);
    }

    public Customer(String username, String password, String phone, String sex, String resume, String sex1) {
        super(username, password, phone);
        this.resume = resume;
    }

    public Customer(String phone, String password, String resume, String sex) {
        super(phone, password);
        this.resume = resume;
        this.sex = sex;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
