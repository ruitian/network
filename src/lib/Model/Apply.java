package lib.Model;

/**
 * Created by baron on 15-9-16.
 */
public class Apply {
    private String dataid;
    private String apply_username;
    private String apply_mess;
    private String role;

    public Apply() {
        super();
    }

    public Apply(String dataid, String apply_username, String apply_mess) {
        this.dataid = dataid;
        this.apply_username = apply_username;
        this.apply_mess = apply_mess;
    }

    public String getDataid() {
        return dataid;
    }

    public void setDataid(String dataid) {
        this.dataid = dataid;
    }

    public String getApply_mess() {
        return apply_mess;
    }

    public void setApply_mess(String apply_mess) {
        this.apply_mess = apply_mess;
    }

    public String getApply_username() {
        return apply_username;
    }

    public void setApply_username(String apply_username) {
        this.apply_username = apply_username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
