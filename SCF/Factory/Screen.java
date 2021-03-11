import java.util.*;

class sortTimeStamp implements Comparator<Shape>{
	@Override
	public int compare(Shape s1, Shape s2) {
		if(s1.getTimeStamp() > s2.getTimeStamp()){
			return 1;
		} else if (s1.getTimeStamp() < s2.getTimeStamp()) {
			return -1;
		}
		return 0;
	}
}
public class Screen {

	private int XMAX;
	private int YMAX;
	public  List<Shape> list;

	Screen(int xmax, int ymax) {
		this.XMAX = xmax;
		this.YMAX = ymax;
		this.list = new ArrayList<>();
	}

	public void addShape(Shape.ShapeType type, Point p, List<Integer> dimensions) {
		Shape S = ShapeFactory.create(type, p, dimensions);
		if ((p.getX() < XMAX && p.getX() >= 0)
				&& (p.getY() < YMAX && p.getY() >= 0)) {
			System.out.println("Sucessfully Added");
			list.add(S);
		}

	}

	public void deleteShape() {
		if (list.size() > 0) {
			list.remove(list.size() - 1);
			System.out.println("Sucessfully Delete!!!");
		}

	}

	public void deleteAll(Shape.ShapeType type) {
		int i = 0;
		while (i < list.size()) {
			if (list.get(i).getClass() == Circle.class
					&& type == Shape.ShapeType.Circle) {
				list.remove(i);
			} else if (list.get(i).getClass() == Triangle.class
					&& type == Shape.ShapeType.Triangle) {
				list.remove(i);
			} else if (list.get(i).getClass() == Rectangle.class
					&& type == Shape.ShapeType.Rectangle) {
				list.remove(i);
			} else if (list.get(i).getClass() == Square.class
					&& type == Shape.ShapeType.Square) {
				list.remove(i);
			} else if (list.get(i).getClass() == RegularPolygon.class
					&& type == Shape.ShapeType.RegularPolygon) {
				list.remove(i);
			}
		}
	}

	public List<Shape> enclosedShapes(Point p) {
		List<Shape> listShape = new ArrayList<Shape>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).isPointEnclosed(p)) {
				listShape.add(list.get(i));
			}
		}
		return listShape;
	}
	
	public void sortShapes(){
		Collections.sort(list,new sortTimeStamp());
	}

	public void displayShapeList() {
		for (int i = 0; i < this.list.size(); i++) {
			System.out.println(list.get(i).getTimeStamp() + "->" + list.get(i).getClass() + " ->Area-> " + list.get(i).getArea() + "->Perimeter-> " + list.get(i).getPerimeter());
		}
	}
}
