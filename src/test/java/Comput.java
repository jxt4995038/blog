import java.util.Scanner;

/**
 * Created by Administrator on 2017/11/23 0023.
 */
public class Comput {
    private static final double PI = 3.14;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int d = scanner.nextInt();
        comput(d);
    }

    public static double comput(int d){
        //正方形的面积
        Squer squer = new Squer(d);
        double squer_s = squer.getS();

        //大圆的面积
        Circle circle_big = new Circle(d,PI);
        double circle_s_big =circle_big.getS();

        //小圆的面积
        Circle circle_small = new Circle(d/2,PI);
        double circle_s_small =circle_small.getS();


        return 1231.1;
    }
}
