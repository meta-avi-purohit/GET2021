import java.util.*;

public class ShapeFactory {

	public static Shape create(Shape.ShapeType type, Point p, List<Integer> list){
		Shape shape = null;
		if( type == Shape.ShapeType.Circle){
			System.out.println("Circle ");
			shape = new Circle(p,list);
			return shape;
		} else if (type == Shape.ShapeType.Rectangle){
			shape = new Rectangle(p,list);
		} else if (type == Shape.ShapeType.Square){
			shape = new Square(p,list);
		} else if (type == Shape.ShapeType.RegularPolygon){
			shape = new RegularPolygon(p,list);
		} else if (type == Shape.ShapeType.Triangle) {
			shape = new Triangle(p,list);
		}
		return shape;
	}
}
