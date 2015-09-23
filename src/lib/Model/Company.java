package lib.Model;

/**
 * Created by baron on 15-9-13.
 */
public class Company{

    private String com_desc;
    private String com_name;
    public Company() {
        super();
    }
    public Company(String com_name, String com_desc) {
        this.com_name = com_name;
        this.com_desc = com_desc;
    }

    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public String getCom_desc() {
        return com_desc;
    }

    public void setCom_desc(String com_desc) {
        this.com_desc = com_desc;
    }
}
