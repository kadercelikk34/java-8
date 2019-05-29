package metod.reference;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MetodReferenceAPI {
    static List<String> names = Arrays.asList("Kader", "Burcu", "Bilge");
    static List<Integer> numbers = Arrays.asList(5, 10, 1, 5, 6);

    public static void main(String args[]) {
        names.forEach(MetodReferenceAPI::herhangiBirMetod);
        System.out.println("*************************");

        //veya

        MetodReferenceAPI apı = new MetodReferenceAPI();
        names.forEach(apı::digeBirMetod);
        System.out.println("*************************");

        //veya

        names.forEach(System.out::println);
        System.out.println("*************************");

/*        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });*/
        //Comparator türünden nesneyi lambda ifadeleriyle yeniden yazalım
        Collections.sort(numbers, (o1, o2) -> o1 - o2);
        System.out.println(numbers);

    }

    //static metod
    public static void herhangiBirMetod(String s) {
        System.out.println(s);
    }

    //Non-stat,c metod
    public void digeBirMetod(String s) {
        System.out.println(s);
    }

    //lambda yerine metod referans kullanmak
    public Integer sirala(Integer o1, Integer o2) {
        return o1 - o2;

    }

    public void birMetod() {
        List<Integer> numbers1 = Arrays.asList(5, 10, 1, 5, 6);
        Collections.sort(numbers1, this::sirala);

    }
}
