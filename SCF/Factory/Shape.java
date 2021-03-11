import java.util.*;

class TimeStamp {
	public static int timeStamp = 1;
}

public interface Shape {
	public static enum ShapeType {
		Circle, Square, Triangle, Rectangle, RegularPolygon
	}

	public float getArea();

	public float getPerimeter();

	public Point getOrigin();

	public boolean isPointEnclosed(Point p);
	
	public int getTimeStamp();
}

class Circle implements Shape {

	public int timeStamp;
	public Point p;
	public int radius;

	Circle(Point p, List<Integer> lists) {
		this.p = p;
		this.timeStamp = TimeStamp.timeStamp++;
		this.radius = lists.get(0);
	}

	@Override
	public float getArea() {
		return (float) (3.14 * (float) radius * (float) radius);
	}

	@Override
	public float getPerimeter() {
		return (float) (2.0 * 3.14 * (float) radius);
	}

	@Override
	public Point getOrigin() {
		return p;
	}

	@Override
	public boolean isPointEnclosed(Point p) {
		return (float) Math.pow(this.p.getX() - p.getX(), 2)
				+ (float) Math.pow(this.p.getY() - p.getY(), 2) <= (float) Math
					.pow(radius, 2);
	}

	@Override
	public int getTimeStamp() {
		return timeStamp;
	}
}

class Square implements Shape {

	public int timeStamp;
	public Point p;
	public int length;

	Square(Point p, List<Integer> lists) {
		this.timeStamp = TimeStamp.timeStamp++;
		this.p = p;
		length = lists.get(0);
	}

	@Override
	public float getArea() {

		return (float) Math.pow(length, 2);
	}

	@Override
	public float getPerimeter() {

		return (float) 4 * length;
	}

	@Override
	public Point getOrigin() {

		return p;
	}

	@Override
	public int getTimeStamp() {
		return timeStamp;
	}
	
	@Override
	public boolean isPointEnclosed(Point p) {
		return (this.p.getX() <= p.getX() && p.getX() <= (this.p.getX() + this.length))
				&& (this.p.getY() <= p.getY() && p.getY() <= (this.p.getY() + this.length));
	}
}

class Triangle implements Shape {
	public int timeStamp;
	public Point p;
	public int base;
	public int height;
	public int a;
	public int b;
	public int c;

	Triangle(Point p, List<Integer> lists) {
		this.timeStamp = TimeStamp.timeStamp++;
		this.p = p;
		this.base = lists.get(0);
		this.height = lists.get(1);
		this.a = lists.get(2);
		this.b = lists.get(3);
		this.c = lists.get(4);
	}

	@Override
	public float getArea() {

		return (float) (base * height) / 2;
	}

	@Override
	public float getPerimeter() {

		return (float) (a + b + c);
	}

	@Override
	public Point getOrigin() {

		return p;
	}
	
	@Override
	public int getTimeStamp() {
		return timeStamp;
	}

	@Override
	public boolean isPointEnclosed(Point p1) {
		Point p2 = new Point(this.b, 0);
		Point p3 = new Point(0, 0);
		int x = ((int)Math.pow(p2.getX(), 2) + (int)Math.pow(a, 2) - (int)Math.pow(c, 2)) / (2*p2.getX());
		int y = ((int)Math.sqrt((int)Math.pow(a, 2) - (int)Math.pow(x, 2)));
		p2.x += p.x;
		p2.y += p.y;
		p3.x += x+p.x;
		p3.y += y+p.y;
		float A = areaOf(p.getX(),p.getY(),p2.getX(),p2.getY(),p3.getX(),p3.getY());
		float A1 = areaOf(p1.getX(),p1.getY(),p2.getX(),p2.getY(),p3.getX(),p3.getY());
		float A2 = areaOf(p.getX(),p.getY(),p1.getX(),p1.getY(),p3.getX(),p3.getY());
		float A3 = areaOf(p.getX(),p.getY(),p2.getX(),p2.getY(),p1.getX(),p1.getY());
		return (A == A1+A2+A3);
	}
	
	public static float areaOf(int x1,int y1,int x2,int y2,int x3,int y3) {
		return (float)Math.abs((x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2))/2.0);
	}
}

class Rectangle implements Shape {
	public int timestamp;
	public Point p;
	public int width;
	public int height;

	Rectangle(Point p, List<Integer> lists) {
		this.timestamp = TimeStamp.timeStamp++;
		this.p = p;
		this.width = lists.get(0);
		this.height = lists.get(1);
	}

	@Override
	public float getArea() {

		return (float) height * width;
	}

	@Override
	public float getPerimeter() {

		return (float) 2 * (height + width);
	}

	@Override
	public Point getOrigin() {

		return p;
	}
	
	@Override
	public int getTimeStamp() {
		return timestamp;
	}

	@Override
	public boolean isPointEnclosed(Point p) {

		return (this.p.getX() <= p.getX()
				&& p.getX() <= (this.p.getX() + width) && (this.p.getY() <= p
				.getY() && p.getY() <= (this.p.getY() + height)));
	}
}

class RegularPolygon implements Shape {
	public int timestamp;
	public Point p;
	public int side;
	public int length;

	RegularPolygon(Point p, List<Integer> lists) {
		this.p = p;
		this.timestamp = TimeStamp.timeStamp++;
		this.side = lists.get(0);
		this.length = lists.get(1);
	}

	@Override
	public float getArea() {

		return (float)((length*length*side)/(4*Math.tan(180 / side)));
	}

	@Override
	public float getPerimeter() {

		return (float) (length) * side;
	}

	@Override
	public Point getOrigin() {

		return p;
	}
	
	@Override
	public int getTimeStamp() {
		return timestamp;
	}

	@Override
	public boolean isPointEnclosed(Point p) {

		float a = length / (2*(float)Math.tan( 180 / side));
		return (float) Math.pow(this.p.getX() - p.getX(), 2)
				+ (float) Math.pow(this.p.getY() - p.getY(), 2) <= (float) Math
				.pow(a, 2);
	}
}

class Point {
	public int x;
	public int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}