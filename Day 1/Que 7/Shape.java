package kundan;

public class Shape {
    public void draw() {
        System.out.println("Drawing Shape");
    }
	

}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
    
    public void draw(double radius) {
        System.out.println("Drawing Circle with radius " + radius);
    }
}

class Rectangle  extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
    
    public void draw(double radius) {
        System.out.println("Drawing Circle with radius " + radius);
    }
}

