package lib.Model;

/**
 * Created by baron on 15-9-23.
 */
public class Relation {
    private String customer_id;
    private String company_id;


    public Relation() {
        super();
    }

    public Relation(String customer_id, String company_id) {
        this.customer_id = customer_id;
        this.company_id = company_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }
}
