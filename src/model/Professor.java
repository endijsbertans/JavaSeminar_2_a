package model;

public class Professor extends Person{

	private static long idC = 13212;
    private long p_ID;
    private Degree degree;
    

    public Professor() {
    	super(); // izsauc Person() konstruktoru
    	setPid();
        this.degree = Degree.bsc;
    }
    public Professor(String name, String surname, Degree degree) {
    	super(name, surname);
        setPid();
        setDegree(degree);
    }

    public long getP_ID() {
        return p_ID;
    }
  
    public void setPid() {
       	idC++;
        this.p_ID = idC;
    }
    

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
    	if(degree != null)
    		this.degree = degree;
    	else 
    		this.degree = Degree.other;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "p_ID=" + p_ID +
                ", name='" + super.toString() + '\'' +
                ", degree='" + degree + '\'' +
                '}';
    }
}