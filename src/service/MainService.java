package service;
import model.Degree;
import model.Professor;
import model.Student;
import model.Course;
import model.Grade;
public class MainService {

	public static void main(String[] args) {
		Professor prof1 = new Professor(0, "Endijs", "Bertans", Degree.other);
		Student stud1 = new Student(12334, "Jekabs", "Berzins");
		Course course1 = new Course(100001, "OOP", 4, prof1);
		Grade grade1 = new Grade(10, stud1, course1);
		System.out.println(grade1.toString());
	}

}
