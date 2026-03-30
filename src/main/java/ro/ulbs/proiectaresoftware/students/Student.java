package ro.ulbs.proiectaresoftware.students;

import java.util.Objects;

public class Student {
    int numarMatricol;
    String prenume;
    String nume;
    String formatieDeStudiu;
    double medie;


    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu, double medie) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
        this.medie = medie;
    }

    public int getNumarMatricol() {
        return numarMatricol;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getNume() {
        return nume;
    }

    public String getFormatieDeStudiu() {
        return formatieDeStudiu;
    }

    public double getMedie() {
        return medie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return numarMatricol == student.numarMatricol &&
                Double.compare(student.medie, medie) == 0 &&
                Objects.equals(prenume, student.prenume) &&
                Objects.equals(nume, student.nume) &&
                Objects.equals(formatieDeStudiu, student.formatieDeStudiu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numarMatricol, prenume, nume, formatieDeStudiu, medie);
    }

    @Override
    public String toString() {
        return String.format("%5d %10s %10s %10s %5.2f", numarMatricol, prenume, nume, formatieDeStudiu, medie);
    }
}