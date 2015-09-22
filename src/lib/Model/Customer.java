package lib.Model;

/**
 * Created by baron on 15-9-14.
 */
public class Customer extends User{
    private String dataid;
    private String resume;
    private String sex;

    public Customer() {
        super();
    }

    public Customer(String dataid, String resume) {
        this.dataid = dataid;
        this.resume = resume;
    }

    public Customer(String dataid, String resume, String sex) {
        this.dataid = dataid;
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

    public String getDataid() {
        return dataid;
    }

    public void setDataid(String dataid) {
        this.dataid = dataid;
    }
}
