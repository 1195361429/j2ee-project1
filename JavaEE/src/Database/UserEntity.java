package Database;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "homework", catalog = "")
public class UserEntity {
    private String uaccount;
    private String upwd;
    private String uname;
    private String urole;
    private String ustate;

    @Id
    @Column(name = "u_account", nullable = false, length = 10)

    public String getUaccount() {
        return uaccount;
    }

    public void setUaccount(String uaccount) {
        this.uaccount = uaccount;
    }

    @Basic
    @Column(name = "u_pwd", nullable = true, length = 40)
    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    @Basic
    @Column(name = "u_name", nullable = true, length = 10)
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Basic
    @Column(name = "u_role", nullable = true, length = 10)
    public String getUrole() {
        return urole;
    }

    public void setUrole(String urole) {
        this.urole = urole;
    }

    @Basic
    @Column(name = "u_state", nullable = true, length = 10)
    public String getUstate() {
        return ustate;
    }

    public void setUstate(String ustate) {
        this.ustate = ustate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (uaccount != null ? !uaccount.equals(that.uaccount) : that.uaccount != null) return false;
        if (upwd != null ? !upwd.equals(that.upwd) : that.upwd != null) return false;
        if (uname != null ? !uname.equals(that.uname) : that.uname != null) return false;
        if (urole != null ? !urole.equals(that.urole) : that.urole != null) return false;
        if (ustate != null ? !ustate.equals(that.ustate) : that.ustate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uaccount != null ? uaccount.hashCode() : 0;
        result = 31 * result + (upwd != null ? upwd.hashCode() : 0);
        result = 31 * result + (uname != null ? uname.hashCode() : 0);
        result = 31 * result + (urole != null ? urole.hashCode() : 0);
        result = 31 * result + (ustate != null ? ustate.hashCode() : 0);
        return result;
    }
}
