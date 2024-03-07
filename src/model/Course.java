package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Course {
    private static long idCounter = 100000;
    private long c_ID;
    private String title;
    private int creditPoints;
    private ArrayList<Professor> professors = new ArrayList<Professor>();
    
    public Course() {
    	setC_ID();
        this.title = "Title Required";
        this.creditPoints = 1;
        setProfessors(professors);
    }

    public Course(String title, int creditPoints, ArrayList<Professor> professors) {

        setC_ID();
        setTitle(title);
        setCreditPoints(creditPoints);
        setProfessors(professors);
    }


    public boolean checkForSpecChar(String s){
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)) && !Character.isLetter(s.charAt(i)) && !Character.isWhitespace(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    public long getC_ID() {
        return c_ID;
    }

    public void setC_ID() {
        idCounter++;
        this.c_ID = idCounter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (checkForSpecChar(title)) return;
        this.title = title;
    }

    public int getCreditPoints() {
        return creditPoints;
    }

    public void setCreditPoints(int creditPoints) {
        if (creditPoints < 0 || creditPoints > 10) return;
        this.creditPoints = creditPoints;
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(ArrayList<Professor> professors) {
    	if(professors != null) 
    		this.professors = professors;
    	else
    		this.professors = new ArrayList<Professor>(Arrays.asList(new Professor()));
    }
  
    @Override
    public String toString() {
        return "Course{" +
                "c_ID=" + c_ID +
                ", title='" + title + '\'' +
                ", creditPoints=" + creditPoints +
                ", professor=" + professors +
                '}';
    }
    // other func
    public void addProfessor(Professor professor) {
    	if(!professors.contains(professor)){
    		professors.add(professor);
    	}
    }
    public void removeProfessor(Professor professor) {
    	if(professors.contains(professor)){
    		professors.remove(professor);
    	}
    }
}