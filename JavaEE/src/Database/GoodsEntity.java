package Database;

import javax.persistence.*;

@Entity
@Table(name = "goods", schema = "homework", catalog = "")
public class GoodsEntity {
    private String gcode;
    private String gname;
    private String gtype;
    private String ggrand;
    private String gunit;
    private String ginprice;
    private String goutprice;
    private String gdescription;
    private int gstoreNum;

    @Id
    @Column(name = "g_code", nullable = false, length = 10)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String getGcode() {
        return gcode;
    }

    public void setGcode(String gcode) {
        this.gcode = gcode;
    }

    @Basic
    @Column(name = "g_name", nullable = false, length = 50)
    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    @Basic
    @Column(name = "g_type", nullable = true, length = 50)
    public String getGtype() {
        return gtype;
    }

    public void setGtype(String gtype) {
        this.gtype = gtype;
    }

    @Basic
    @Column(name = "g_grand", nullable = true, length = 50)
    public String getGgrand() {
        return ggrand;
    }

    public void setGgrand(String ggrand) {
        this.ggrand = ggrand;
    }

    @Basic
    @Column(name = "g_unit", nullable = true, length = 10)
    public String getGunit() {
        return gunit;
    }

    public void setGunit(String gunit) {
        this.gunit = gunit;
    }

    @Basic
    @Column(name = "g_inprice", nullable = true, length = 10)
    public String getGinprice() {
        return ginprice;
    }

    public void setGinprice(String ginprice) {
        this.ginprice = ginprice;
    }

    @Basic
    @Column(name = "g_outprice", nullable = false, length = 10)
    public String getGoutprice() {
        return goutprice;
    }

    public void setGoutprice(String goutprice) {
        this.goutprice = goutprice;
    }

    @Basic
    @Column(name = "g_description", nullable = true, length = 10)
    public String getGdescription() {
        return gdescription;
    }

    public void setGdescription(String gdescription) {
        this.gdescription = gdescription;
    }

    @Basic
    @Column(name = "g_storeNum", nullable = false)
    public int getGstoreNum() {
        return gstoreNum;
    }

    public void setGstoreNum(int gstoreNum) {
        this.gstoreNum = gstoreNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsEntity that = (GoodsEntity) o;

        if (gstoreNum != that.gstoreNum) return false;
        if (gcode != null ? !gcode.equals(that.gcode) : that.gcode != null) return false;
        if (gname != null ? !gname.equals(that.gname) : that.gname != null) return false;
        if (gtype != null ? !gtype.equals(that.gtype) : that.gtype != null) return false;
        if (ggrand != null ? !ggrand.equals(that.ggrand) : that.ggrand != null) return false;
        if (gunit != null ? !gunit.equals(that.gunit) : that.gunit != null) return false;
        if (ginprice != null ? !ginprice.equals(that.ginprice) : that.ginprice != null) return false;
        if (goutprice != null ? !goutprice.equals(that.goutprice) : that.goutprice != null) return false;
        if (gdescription != null ? !gdescription.equals(that.gdescription) : that.gdescription != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gcode != null ? gcode.hashCode() : 0;
        result = 31 * result + (gname != null ? gname.hashCode() : 0);
        result = 31 * result + (gtype != null ? gtype.hashCode() : 0);
        result = 31 * result + (ggrand != null ? ggrand.hashCode() : 0);
        result = 31 * result + (gunit != null ? gunit.hashCode() : 0);
        result = 31 * result + (ginprice != null ? ginprice.hashCode() : 0);
        result = 31 * result + (goutprice != null ? goutprice.hashCode() : 0);
        result = 31 * result + (gdescription != null ? gdescription.hashCode() : 0);
        result = 31 * result + gstoreNum;
        return result;
    }
}
