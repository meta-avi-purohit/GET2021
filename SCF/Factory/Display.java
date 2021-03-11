import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Display {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Screen S = new Screen(100, 100);
		int enter = 1;
		while(enter > 0) {
		System.out.println("##############################");
		System.out.println("1-> ADD SHAPE TO SCREEN");
		System.out.println("2-> DELETE A SHAPE FROM SCREEN");
		System.out.println("3-> DELETE ALL SHAPE OF A TYPE");
		System.out.println("4-> LIST OF SHAPES A POINT ENCLOSED IN");
		System.out.println("5-> DISPLAY");
		System.out.println("##############################");
		int choice = scan.nextInt();
		switch (choice) {
		case 1: 
		{
			System.out.println("------------------------");
			System.out.println("Circle");
			System.out.println("Square");
			System.out.println("Triangle");
			System.out.println("Rectangle");
			System.out.println("RegularPolygon");
			System.out.println("------------------------");
			System.out.println("Enter the Shape : ");
			String type = scan.next();
			switch (type) {
			case "Circle":
				List<Integer> l = new ArrayList<>();
				System.out.println("Enter Radius of Circle : ");
				int radius = scan.nextInt();
				l.add(radius);
				System.out.println("Enter X and Y Points : ");
				int x = scan.nextInt();
				int y = scan.nextInt();
				Point p = new Point(x, y);
				S.addShape(Shape.ShapeType.Circle, p, l);
				break;
			case "Rectangle":
				l = new ArrayList<>();
				System.out.println("Enter Width and Height of Rectangle : ");
				int width = scan.nextInt();
				int height = scan.nextInt();
				l.add(width);
				l.add(height);
				System.out.println("Enter X and Y Points : ");
				x = scan.nextInt();
				y = scan.nextInt();
				p = new Point(x, y);
				S.addShape(Shape.ShapeType.Rectangle, p, l);
				break;
			case "Square":
				l = new ArrayList<>();
				System.out.println("Enter Width  of Square : ");
				width = scan.nextInt();
				l.add(width);
				System.out.println("Enter X and Y Points : ");
				x = scan.nextInt();
				y = scan.nextInt();
				p = new Point(x, y);
				S.addShape(Shape.ShapeType.Square, p, l);
				break;
			case "Triangle":
				l = new ArrayList<>();
				System.out.println("Enter Base and Height of Triangle : ");
				width = scan.nextInt();
				height = scan.nextInt();
				l.add(width);
				l.add(height);
				System.out.println("Enter length of sides (a,b,c) :");
				int a = scan.nextInt();
				int b = scan.nextInt();
				int c = scan.nextInt();
				l.add(a);
				l.add(b);
				l.add(c);
				System.out.println("Enter X and Y Points : ");
				x = scan.nextInt();
				y = scan.nextInt();
				p = new Point(x, y);
				S.addShape(Shape.ShapeType.Triangle, p, l);
				break;
			case "Regular Polygon":
				l = new ArrayList<>();
				System.out.println("Enter Length and Sides of Triangle : ");
				width = scan.nextInt();
				int sides = scan.nextInt();
				l.add(width);
				l.add(sides);
				System.out.println("Enter X and Y Points : ");
				x = scan.nextInt();
				y = scan.nextInt();
				p = new Point(x, y);
				S.addShape(Shape.ShapeType.RegularPolygon, p, l);
				break;
			default:
				System.out.println("Wrong Shape!!");
			}
		}
		break;
		case 2:
			S.deleteShape();
			break;
		case 3:
			System.out.println("Enter type to detele");
			String typedelete = scan.next();
			switch(typedelete) {
			case "Circle":
					S.deleteAll(Shape.ShapeType.Circle);
					break;
			case "Rectangle":
				S.deleteAll(Shape.ShapeType.Rectangle);
				break;
			case "Square":
				S.deleteAll(Shape.ShapeType.Square);
				break;
			case "Trinagle":
				S.deleteAll(Shape.ShapeType.Triangle);
				break;
			case "Regular Polygon":
				S.deleteAll(Shape.ShapeType.RegularPolygon);
			}
			break;
		case 4:
			System.out.println("Enter Point to find : ");
			int x1 = scan.nextInt();
			int y1 = scan.nextInt();
			Point findp = new Point(x1, y1);
			List<Shape> result = S.enclosedShapes(findp);
			for (int i = 0; i < result.size(); i++) {
				System.out.println(result.get(i).getTimeStamp() + "    " + result.get(i).getClass());
			}
			break;
		case 5:
			S.sortShapes();
			S.displayShapeList();
			break;
		default :
			System.out.println("Wrong Value Entered!!!!!");
				
		}
		System.out.println("Want To peform more(Press 1 else Press 0 ): ");
		enter = scan.nextInt();
		}
		scan.close();
	}
}
