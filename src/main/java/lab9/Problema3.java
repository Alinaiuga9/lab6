package lab9;

import java.util.*;
import java.util.stream.*;

class StudentLab9 {
    int id;
    String nume;
    String prenume;
    String grupa;
    double nota;

    public StudentLab9(int id, String nume, String prenume, String grupa, double nota) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.grupa = grupa;
        this.nota = nota;
    }
    @Override
    public String toString() {
        return nume + " " + prenume + " - Nota: " + nota;
    }
}

public class Problema3 {
    public static void main(String[] args) {
        List<StudentLab9> studentiCuNote = Arrays.asList(
                new StudentLab9(1025,"Andrei","Popa","ISM141/2", 8.70),
                new StudentLab9(1024,"Ioan","Mihalcea","ISM141/1", 10),
                new StudentLab9(1026,"Anamaria","Prodan","TI131/1", 8.90),
                new StudentLab9(1029,"Bianca","Popescu","TI131/1", 10),
                new StudentLab9(1029,"Maria","Pana","TI131/2", 4.10),
                new StudentLab9(1029,"Gabriela","Mohanu","TI131/2", 7.33),
                new StudentLab9(1029,"Marius","Nasta","TI131/2", 3.20),
                new StudentLab9(1029,"Marius","Nasta","TI131/1", 5.12),
                new StudentLab9(1029,"Andrei","Dobrescu","TI131/2", 2.22)
        );
        studentiCuNote.stream()
                .filter(s -> s.nota == 10.0)
                .forEach(System.out::println);
        studentiCuNote.stream()
                .filter(s -> s.nota < 5.0)
                .forEach(System.out::println);
        List<StudentLab9> mapati = studentiCuNote.stream()
                .map(s -> {
                    if (s.nota < 4.0) s.nota = 4.0;
                    return s;
                })
                .collect(Collectors.toList());
        mapati.forEach(System.out::println);
        double suma = studentiCuNote.stream()
                .map(s -> s.nota)
                .reduce(0.0, Double::sum);
        System.out.println(suma);
        double media = suma / studentiCuNote.size();
        System.out.println(media);

    }
}