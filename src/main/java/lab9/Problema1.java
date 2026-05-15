package lab9;

import java.util.*;
import java.util.stream.*;

public class Problema1 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> numere = IntStream.range(0, 10)
                .map(i -> 5 + random.nextInt(21))
                .boxed()
                .collect(Collectors.toList());

        System.out.println(numere);

        int suma = numere.stream().mapToInt(Integer::intValue).sum();
        System.out.println(suma);

        int max = numere.stream().max(Comparator.naturalOrder()).orElseThrow();
        int min = numere.stream().min(Comparator.naturalOrder()).orElseThrow();
        System.out.println(max);
        System.out.println(min);

        List<Integer> filtrate = numere.stream()
                .filter(n -> n >= 10 && n <= 20)
                .collect(Collectors.toList());
        System.out.println(filtrate);

        List<Double> numereDouble = numere.stream()
                .map(Integer::doubleValue)
                .collect(Collectors.toList());
        System.out.println(numereDouble);

        boolean contine12 = numere.stream().anyMatch(n -> n == 12);
        System.out.println(contine12);
    }
}