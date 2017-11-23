/**
 * Created by Administrator on 2017/11/23 0023.
 */
public class Circle {

    private Integer banjing;

    private Double s;

    public Integer getBanjing() {
        return banjing;
    }

    public void setBanjing(Integer banjing) {
        this.banjing = banjing;
    }

    public Double getS() {
        return s;
    }

    public void setS(Double s) {
        this.s = s;
    }

    public Circle(int d,double pi){
        this.banjing = d;
        this.s = pi*d*d;
    }
    public Circle(){}
}
