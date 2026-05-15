package lab9;
import java.util.*;
import java.util.stream.*;
public class Problema2 {
    public static void main(String[] args)
    {
        String text="Acesta este un program scris in java pentru expresii lambda";
        List<String> cuvinte = Arrays.asList(text.split(" "));
        List<String> filtrare= cuvinte.stream()
                .filter(c->c.length() >=5)
                .collect(Collectors.toList());
        System.out.println(filtrare);
        List<String> sortare=filtrare.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortare);
        String incepeCuP=cuvinte.stream()
                .filter(c->c.startsWith("p"))
                .findFirst()
                .orElse("");
        System.out.println(incepeCuP);

    }
}
