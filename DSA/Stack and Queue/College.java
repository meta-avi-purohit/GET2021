import java.io.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.*;

class Student {
	private String name;
	public String preference[];
	private String course;
	
	Student(String name,String preference[]){
		this.name = name;
		this.preference = new String[preference.length];
		for (int i = 0; i < preference.length; i++) {
			this.preference[i] = preference[i];
		}
		this.course = "";
	}
	
	public String getName() {
		return name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getPreference(int i) {
		return preference[i];
	}
	
	public void display(){
		System.out.println("------------------------------------------------------------------");
		System.out.println(name);
		System.out.println(course);
		System.out.println(preference[0] + " " + preference[1] + " " + preference[2] + " " + preference[3]);
		System.out.println("------------------------------------------------------------------");
	}
	
}

class Course {
	private String name;
	private int capacity;
	
	Course( String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
	}
	
	public int getCapacity() {
		return capacity;
	}
	public String getName(){
		return name;
	}
	public void setCapacity(){
		this.capacity -= 1;
	}
	public void display(){
		System.out.println("------------------------------------------------------------------");
		System.out.println(name);
		System.out.println(capacity);
		System.out.println("------------------------------------------------------------------");
	}
}

public class College{
	public static Course courseoffer[];
	public static Student students[];
	public static Queue<Student> studentQueue = new ArrayDeque<Student>();
	
	public static void getStudents() throws IOException{
		FileInputStream fileinput = new FileInputStream( new File ("C:\\Users\\avi.purohit_metacube\\Downloads\\Student.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fileinput);
		List<Student> student = new ArrayList<Student>();
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> itr = sheet.iterator();
		while(itr.hasNext()) {
			Row row = itr.next();
			int check = 0;
			String name = "";
			Iterator<Cell> celliterator = row.cellIterator();
			String preference[] = new String[5];
			int index = 0;
			while(celliterator.hasNext()) {
				Cell cell = celliterator.next();
				if(check == 0) {
					name = cell.getStringCellValue();
					check = 1;
				} else {
					preference[index++] = cell.getStringCellValue();
				}
			}
			student.add(new Student(name, preference));
			students = new Student[student.size()];
			for (int i = 0; i < student.size(); i++) {
				students[i] = student.get(i);
			}
		}
		for (int i = 0; i < student.size(); i++) {
			students[i].display();
		}
		workbook.close();
	}
	
	public static void getPrograms() throws IOException {
		FileInputStream fileinput = new FileInputStream( new File ("C:\\Users\\avi.purohit_metacube\\Downloads\\College.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fileinput);
		List<Course> courses = new ArrayList<>();
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> itr = sheet.iterator();
		while(itr.hasNext()) {
			Row row = itr.next();
			int capacity = 0, check = 0;
			String program = "";
			Iterator<Cell> celliterator = row.cellIterator();
			while(celliterator.hasNext()) {
				Cell cell = celliterator.next();
				if(check == 1) {
					capacity = (int) cell.getNumericCellValue();
				} else {
					check = 1;
					program = cell.getStringCellValue();
				}
			}
			courses.add(new Course(program, capacity));
		}
		courseoffer = new Course[courses.size()];
		for (int i = 0; i < courses.size(); i++) {
			courseoffer[i] = courses.get(i);
		}
		for (int i = 0; i < courses.size(); i++) {
			courseoffer[i].display();
		}
		workbook.close();
	}
	
	public static void assignPrograms() throws Exception {
		getPrograms();
		getStudents();
		for (int i = 0; i < students.length; i++) {
			studentQueue.add(students[i]);
		}
		int n =studentQueue.size();
		for (int i = 0; i < n; i++) {
			Student student = studentQueue.poll();
			int assign = 0;
			for (int j = 0; j < student.preference.length; j++) {
				for (int k = 0; k < courseoffer.length; k++) {
					if(student.getPreference(j).equals(courseoffer[k].getName())){
						int capacity = courseoffer[k].getCapacity();
						if(capacity > 0) {
							student.setCourse(student.getPreference(j));
							courseoffer[k].setCapacity();
							assign = 1;
							break;
						}
					}
				}
				if(assign == 1) {
					break;
				}
			}
		}
		putDataInExcel();
	}
	
	public static void putDataInExcel() throws Exception {
		FileInputStream fileinput = new FileInputStream( new File ("C:\\Users\\avi.purohit_metacube\\Downloads\\Final.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fileinput);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowno = 0;
		for (int i = 0; i < students.length; i++) {
			Row row = sheet.createRow(rowno++);
			Cell cell1 = row.createCell(0);
			cell1.setCellValue(students[i].getName());
			Cell cell2 = row.createCell(1);
			cell2.setCellValue(students[i].getCourse());
		}
		try {
			FileOutputStream output = new FileOutputStream( new File ("C:\\Users\\avi.purohit_metacube\\Downloads\\Final.xlsx"));
			workbook.write(output);
		} catch (Exception e) {
			e.printStackTrace();
		}
		workbook.close();
	}
	public static void main(String[] args) throws Exception{
		assignPrograms();
	}
	
}
