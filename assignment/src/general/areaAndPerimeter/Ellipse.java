package assignment.src.general.areaAndPerimeter;

public class Ellipse implements Shape{
    int radius1;

    int radius2;

    double pi = Math.PI;

    public Ellipse(){

    }

    public Ellipse(int shortRadius,int longRadius){
        this.radius1 =shortRadius;
        this.radius2=longRadius;
    }
    @Override
    public float getArea() {
        return (float)pi* radius1 *radius2;
    }
    @Override
    public float getPerimeter(){
        return (float) (2*pi*Math.sqrt((radius1 * radius1 +radius2*radius2)/2));
    }
}
