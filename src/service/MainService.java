package service;
import model.Degree;
import model.Person;
import model.Professor;
import model.Student;

import java.util.ArrayList;
import java.util.Arrays;

import model.Course;
import model.Grade;
public class MainService {

	private static ArrayList<Person> allPersons = new ArrayList<Person>();
	private static ArrayList<Course> allCourses = new ArrayList<Course>();
	private static ArrayList<Grade> allGrades = new ArrayList<Grade>();
	
	public static void main(String[] args) {

		
		Professor prof1 = new Professor("Endijs", "Bertans", Degree.other);
		Professor prof2 = new Professor("Daniels", "Kalnavs", Degree.phd);
		allPersons.add(prof1);
		allPersons.add(prof2);
		for(Person temp : allPersons) {
			System.out.println(temp);
		}
		System.out.println();
		
		Student stud1 = new Student("Jekabs", "Berzins");
		Student stud2 = new Student("Janis", "Baltais");
		allPersons.add(stud1);
		allPersons.add(stud2);
		for(Person temp : allPersons) {
			System.out.println(temp);
		}
		System.out.println();
		
		Course course1 = new Course("OOP", 4, new ArrayList<Professor>(Arrays.asList(prof1)));
		Course course2 = new Course("Diskreta mat.", 2, new ArrayList<Professor>(Arrays.asList(prof1)));
		Course course3 = new Course("Mat Analize", 4, new ArrayList<Professor>(Arrays.asList(prof2)));
		Course course4 = new Course("Datorsist. arhitektura", 4, new ArrayList<Professor>(Arrays.asList(prof2, prof1)));
		allCourses.add(course1);
		allCourses.add(course2);
		allCourses.add(course3);
		allCourses.add(course4);
		for(Course temp : allCourses) {
			System.out.println(temp);
		}
		System.out.println();
		
		Grade grade1 = new Grade(7, stud1, course1);		
		Grade grade2 = new Grade(10, stud2, course2);
		allGrades.add(grade1);
		allGrades.add(grade2);
		for(Grade temp : allGrades) {
			System.out.println(temp);
		}
		System.out.println();
		
		try {

			for(Person stud : allPersons) {
				if(stud instanceof Student) {
				System.out.println(stud);
				System.out.println(stud);
				}
			}
			System.out.println(calcAvgGradeOfCourse(course1));
			System.out.println(calcCoursesForProfessor(prof1));
			sortStudentsByAvgGrade();

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
			if(temp.getProfessors().contains(professor)) {
				count++;
			}
		}
		if(count == 0)throw new Exception("No courses for professor");
		return count;
	}
	// TODO add person code as necessary input
	public static void createStudent(String name, String surname) throws Exception {
		if(name == null || surname == null) throw new Exception("Input name or surname has a problem!");
		for(Person temp : allPersons) {
			if(temp.getName().equals(name) && temp.getSurname().equals(surname) && temp instanceof Student) {
				throw new Exception("Student with that name and surname already exists!");
			}
		}
		Student st = new Student(name, surname);
		allPersons.add(st);
	}
	// retrieve by surname
	//TODO retrieve by personCode
	public static Student retrieveStudentBySurname(String surname) throws Exception {
		if(surname == null) throw new Exception("Input name or surname has a problem!");
		for(Person temp : allPersons) {
			if(temp.getSurname().equals(surname) && temp instanceof Student) return (Student)temp;
		}
		throw new Exception("Student By surname not Found");
	}
	public static void updateStudentByNameAndSurname(String name, String surname, String newSurname) throws Exception{
		if(name == null || surname == null) throw new Exception("Input name or surname has a problem!");
		for(Person temp : allPersons) {
			if(temp.getName().equals(name) && temp.getSurname().equals(surname) && !surname.equals(newSurname) && temp instanceof Student) {
				temp.setSurname(newSurname);
				break;
			}
		}
		throw new Exception("Student By surname and name not Found!");
	}
	
	public static void deleteStudentByNameAndSurname(String name, String surname) throws Exception{
		if(name == null || surname == null) throw new Exception("Input name or surname has a problem!");
		for(Person temp : allPersons) {
			if(temp.getName().equals(name) && temp.getSurname().equals(surname)&& temp instanceof Student) {
				allPersons.remove(temp);
					break;
			}
		}
		throw new Exception("Student By surname and name not Found!");
	}
	public static ArrayList<Student> sortStudentsByAvgGrade() throws Exception{
		ArrayList<Student> result = new ArrayList<Student>();
		for(Person student : allPersons) {
			if(student instanceof Student) {
				try {
					
					calcAvgGrade((Student)student);
					result.add((Student)student);
			
				}catch(Exception e) {
					System.out.println(e);
				}
			}
		}
		
		for(int i = 0; i< result.size(); i++) {
			try {
			for(int j = 0; j < result.size(); j++) {
				if(calcAvgGrade(result.get(i)) < calcAvgGrade(result.get(j))) {
					Student temp = result.get(i);
					result.set(i, result.get(j));
					result.set(i, temp);
				}
			}
			}catch(Exception e) {
			System.out.println(e);
			}
		}
		
        return result;
	}
	
	
}
