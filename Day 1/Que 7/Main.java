package kundan;

public class Main {
     
	public static void main(String[] args) {
	    Shape shape = new Shape();
	    shape.draw(); 
	    
	    Circle circle = new Circle();
	    circle.draw(); 
	    circle.draw(5.0); 
	    
	    Rectangle rectangle = new Rectangle();
	    rectangle.draw(); 
	    rectangle.draw(10.0); 
	}
}
