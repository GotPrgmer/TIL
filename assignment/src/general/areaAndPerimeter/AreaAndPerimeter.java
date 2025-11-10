package assignment.src.general.areaAndPerimeter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AreaAndPerimeter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("직사각형의 두 변을 띄어쓰기를 구분하여 입력해주세요.");
        String[] rectangularSides = br.readLine().split(" ");
        Rectangle rt = new Rectangle(Integer.parseInt(rectangularSides[0]),Integer.parseInt(rectangularSides[1]));
        System.out.println(rt.getArea());
        System.out.println(rt.getPerimeter());

        System.out.println("정사각형의 한 변을 띄어쓰기를 구분하여 입력해주세요.");
        String squareSide = br.readLine();
        Square sq = new Square(Integer.parseInt(squareSide));
        System.out.println(sq.getArea());
        System.out.println(sq.getPerimeter());

        System.out.println("타원의 두 반경을 띄어쓰기를 구분하여 입력해주세요.");
        String[] ellipsicalRadiuses = br.readLine().split(" ");
        Ellipse ellipse = new Ellipse(Integer.parseInt(ellipsicalRadiuses[0]),Integer.parseInt(ellipsicalRadiuses[1]));
        System.out.println(ellipse.getArea());
        System.out.println(ellipse.getPerimeter());

        System.out.println("원의 반경을 띄어쓰기를 구분하여 입력해주세요.");
        String circularRadius = br.readLine();
        Circle circle = new Circle(Integer.parseInt(circularRadius));
        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());


    }

}
