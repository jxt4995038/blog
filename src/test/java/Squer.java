/**
 * Created by Administrator on 2017/11/23 0023.
 */
public class Squer {
    private Integer bianchang;

    private Double s;

    public Integer getBianchang() {
        return bianchang;
    }

    public void setBianchang(Integer bianchang) {
        this.bianchang = bianchang;
    }

    public Double getS() {
        return s;
    }

    public void setS(Double s) {
        this.s = s;
    }
    //有参构造函数，设置面积
    public Squer(int bianchang){
        this.bianchang = bianchang;
        this.s = Double.valueOf(bianchang*bianchang);
    }
    public Squer(){}
}
