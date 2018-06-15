package Database;

import javax.persistence.*;

@Entity
@Table(name = "customer", schema = "homework", catalog = "")
public class CustomerEntity {
    private String ccode;
    private String cname;
    private String clinkphone;
    private String caddress;
    private String cdescription;
    private String cstate;

    @Id
    @Column(name = "c_code", nullable = false, length = 10)
    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    @Basic
    @Column(name = "c_name", nullable = true, length = 10)
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Basic
    @Column(name = "c_linkphone", nullable = true, length = 11)
    public String getClinkphone() {
        return clinkphone;
    }

    public void setClinkphone(String clinkphone) {
        this.clinkphone = clinkphone;
    }

    @Basic
    @Column(name = "c_address", nullable = true, length = 10)
    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    @Basic
    @Column(name = "c_description", nullable = true, length = 10)
    public String getCdescription() {
        return cdescription;
    }

    public void setCdescription(String cdescription) {
        this.cdescription = cdescription;
    }

    @Basic
    @Column(name = "c_state", nullable = true, length = 10)
    public String getCstate() {
        return cstate;
    }

    public void setCstate(String cstate) {
        this.cstate = cstate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerEntity that = (CustomerEntity) o;

        if (ccode != null ? !ccode.equals(that.ccode) : that.ccode != null) return false;
        if (cname != null ? !cname.equals(that.cname) : that.cname != null) return false;
        if (clinkphone != null ? !clinkphone.equals(that.clinkphone) : that.clinkphone != null) return false;
        if (caddress != null ? !caddress.equals(that.caddress) : that.caddress != null) return false;
        if (cdescription != null ? !cdescription.equals(that.cdescription) : that.cdescription != null) return false;
        if (cstate != null ? !cstate.equals(that.cstate) : that.cstate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ccode != null ? ccode.hashCode() : 0;
        result = 31 * result + (cname != null ? cname.hashCode() : 0);
        result = 31 * result + (clinkphone != null ? clinkphone.hashCode() : 0);
        result = 31 * result + (caddress != null ? caddress.hashCode() : 0);
        result = 31 * result + (cdescription != null ? cdescription.hashCode() : 0);
        result = 31 * result + (cstate != null ? cstate.hashCode() : 0);
        return result;
    }
}
