package lib.Model;

/**
 * Created by baron on 15-9-13.
 */
public class Company extends User{

    private String com_desc;
    public Company() {
        super();
    }
    public Company(String com_name, String com_desc) {
        this.com_desc = com_desc;
    }

    public String getCom_desc() {
        return com_desc;
    }

    public void setCom_desc(String com_desc) {
        this.com_desc = com_desc;
    }
}
