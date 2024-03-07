package service;
import model.Degree;
import model.Professor;
import model.Student;

import java.util.ArrayList;

import model.Course;
import model.Grade;
public class MainService {

	private static ArrayList<Professor> allProfessors = new ArrayList<Professor>();
	private static ArrayList<Student> allStudents = new ArrayList<Student>();
	private static ArrayList<Course> allCourses = new ArrayList<Course>();
	private static ArrayList<Grade> allGrades = new ArrayList<Grade>();
	
	public static void main(String[] args) {

		
		Professor prof1 = new Professor("Endijs", "Bertans", Degree.other);
		Professor prof2 = new Professor("Daniels", "Kalnavs", Degree.phd);
		allProfessors.add(prof1);
		allProfessors.add(prof2);
		for(Professor temp : allProfessors) {
			System.out.println(temp);
		}
		System.out.println();
		
		Student stud1 = new Student("Jekabs", "Berzins");
		Student stud2 = new Student("Janis", "Baltais");
		allStudents.add(stud1);
		allStudents.add(stud2);
		for(Student temp : allStudents) {
			System.out.println(temp);
		}
		System.out.println();
		
		Course course1 = new Course("OOP", 4, prof1);
		Course course2 = new Course("Diskreta mat.", 2, prof1);
		Course course3 = new Course("Mat Analize", 4, prof2);
		allCourses.add(course1);
		allCourses.add(course2);
		for(Course temp : allCourses) {
			System.out.println(temp);
		}
		System.out.println();
		
		Grade grade1 = new Grade(10, stud1, course1);		
		Grade grade2 = new Grade(3, stud2, course2);
		allGrades.add(grade1);
		allGrades.add(grade2);
		for(Grade temp : allGrades) {
			System.out.println(temp);
		}
		System.out.println();
		
		try {

			for(Student stud : allStudents) {
				System.out.println(calcAvgGrade(stud));
				System.out.println(calcWeightedAvg(stud));
				
			}
			System.out.println(calcAvgGradeOfCourse(course1));
			System.out.println(calcCoursesForProfessor(prof1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static float calcAvgGrade(Student student) throws Exception {
		if(student == null) throw new Exception("Input student has a problem");
		float sum = 0;
		int howMany = 0;
		
		for(Grade temp : allGrades) {
			if(temp.getStudent().equals(student)) {
				sum += temp.getValue();
				howMany++;
			}
		}
		return sum/howMany;
	}
	public static float calcWeightedAvg(Student student) throws Exception {
		if(student == null) throw new Exception("Input student has a problem");
		float sum = 0;
		int howMany = 0;
		for(Grade temp : allGrades) {
			if(temp.getStudent().equals(student)) {
				sum += temp.getValue() * temp.getCourse().getCreditPoints();
				howMany += temp.getCourse().getCreditPoints();
				
			}
			
		}
		return sum/howMany;
	}
	public static float calcAvgGradeOfCourse(Course course) throws Exception {
		if(course == null) throw new Exception("Input course has a problem");
		float sum = 0;
		int howMany = 0;
		for(Grade temp : allGrades) {
			if(temp.getCourse().equals(course)) {
				sum += temp.getValue();
				howMany++;
			}
		}
		if(howMany == 0)throw new Exception("No grades for course");
		return sum/howMany;
	}
	public static int calcCoursesForProfessor(Professor professor) throws Exception {
		if(professor== null) throw new Exception("Input professor has a problem");
		int count = 0;
		for(Course temp : allCourses) {
			if(temp.getProfessor().equals(professor)) {
				count++;
			}
		}
		if(count == 0)throw new Exception("No courses for professor");
		return count;
	}
	// TODO add person code as necessary input
	public static void createStudent(String name, String surname) throws Exception {
		if(name == null || surname == null) throw new Exception("Input name or surname has a problem!");
		for(Student temp : allStudents) {
			if(temp.getName().equals(name) && temp.getSurname().equals(surname)) {
				throw new Exception("Student with that name and surname already exists!");
			}
		}
		Student st = new Student(name, surname);
		allStudents.add(st);
	}
	// retrieve by surname
	//TODO retrieve by personCode
	public static Student retrieveStudentBySurname(String surname) throws Exception {
		if(surname == null) throw new Exception("Input name or surname has a problem!");
		for(Student temp : allStudents) {
			if(temp.getSurname().equals(surname)) return temp;
		}
		throw new Exception("Student By surname not Found");
	}
	public static void sortStud() throws Exception{
		if(allGrades == null) throw new Exception("No grades");
		if(allStudents == null) throw new Exception("No grades");
        
	}
	
	
}
