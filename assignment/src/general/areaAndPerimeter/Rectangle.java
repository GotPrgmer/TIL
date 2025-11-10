package assignment.src.general.areaAndPerimeter;

public class Rectangle implements Shape{
    int horizonalSide;
    int verticalSide;
    public Rectangle(){

    }

    public Rectangle(int horizonalSide,int verticalSide){
        this.horizonalSide=horizonalSide;
        this.verticalSide = verticalSide;

    }
    @Override
    public float getArea() {
        return (horizonalSide*verticalSide);
    }
    @Override
    public float getPerimeter(){
        return 2*horizonalSide+2*verticalSide;
    }
}
