package lab10;

public class Student {
    private int id;
    private String prenume;
    private String nume;
    private String grupa;
    private double medie;

    public Student(int id, String prenume, String nume, String grupa, double medie)
    {
        this.id=id;
        this.prenume=prenume;
        this.nume=nume;
        this.grupa=grupa;
        this.medie=medie;
    }
    @Override
    public String toString()
    {
        return id+" "+nume+" "+prenume+" "+grupa+" "+medie;
    }
}
