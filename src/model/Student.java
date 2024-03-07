package model;

public class Student extends Person{
	
	private static long idCount = 1000;
    private long st_ID;
    private static long counter = 10000;

    public Student() {
    	super();
    	setSt_ID();
    }

    public Student(String name, String surname) {
    	super(name, surname);
    	setSt_ID();
    }
    public long getSt_ID() {
        return st_ID;
    }

    public void setSt_ID() {
    	idCount++;
        this.st_ID = idCount;
    }

    @Override
    public String toString() {
        return "Student{" +
                "st_ID=" + st_ID +
                ", name='" + super.toString() + '\'' +
                '}';
    }
}