package ro.ulbs.proiectaresoftware.students;

import java.util.Objects;

public class StudentBursieri extends Student {
    private double cuantumBursa;


    public StudentBursieri(int id, String prenume, String nume, String grupa, double medie, double cuantumBursa) {
        super(id, prenume, nume, grupa, medie);
        this.cuantumBursa = cuantumBursa;
    }

    public double getCuantumBursa() {
        return cuantumBursa;
    }

    public void setCuantumBursa(double cuantumBursa) {
        this.cuantumBursa = cuantumBursa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;


        StudentBursieri that = (StudentBursieri) o;
        return Double.compare(that.cuantumBursa, cuantumBursa) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cuantumBursa);
    }

    @Override
    public String toString() {
        return super.toString() + " | Bursa: " + cuantumBursa + " RON";
    }
}