package streams.stream;


import streams.model.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamMapAPI {
    public static void main(String args[]){
        List<String> names = Arrays.asList("Ali","Veli","Selami","Cem");
         // Stream#map
        //Her bir ögenin harflerini büyütelim
        names.stream().map(name -> name.toUpperCase()).collect(Collectors.toList());
        names.forEach(System.out::println);

        System.out.println("****--------------**** ");

        // 1,5 arası sayıların karelerini hesaplayalım.
        IntStream.rangeClosed(1,5).map(s-> s*s).forEach(System.out::println);

        System.out.println("****--------------**** ");

        //Stream#reduce
        // bir
        //önceki adımda elde edilen sonuç bir sonraki adıma girdi olarak sunulmaktadır
        //1,2,3,4,5 sayıların toplamı
        int result = IntStream.of(1,2,3,4,5).reduce(0,(once,sonra)-> {
            System.out.println(once + " " + sonra);
            return once +sonra ;
        });
        System.out.println("result : "+result);

        System.out.println("****--------------**** ");

        //1,2,3,4,5 sayıların carpımı lambda ile
        int resultMultiply = IntStream.of(1,2,3,4,5).reduce(1,(once,sonra)-> once * sonra);
        System.out.println("resultMultiply : "+resultMultiply);

        System.out.println("****--------------**** ");

        //1,2,3,4,5 metod referans ile çarpma işlemi
        int resultMultiply2 = IntStream.of(1,2,3,4,5).reduce(1,Math:: multiplyExact);
        System.out.println("resultMultiply2 : "+resultMultiply2);

        System.out.println("****--------------**** ");

        // map & reduce
        Person p1 = new Person("Ahmet", 12);
        Person p2 = new Person("Ali", 16);
        Person p3 = new Person("Ayşe", 30);
        Person p4 = new Person("Murat", 51);
        Person p5 = new Person("Zeynep", null);
        List<Person> personList = Arrays.asList(p1, p2, p3, p4, p5);
        //personList yaş ortalaması
        Double subPersonAge= personList.stream().map(p -> p.getAge()).map(Double::valueOf).reduce(0.0,(a,b)-> (a+b)/2);
        System.out.println("person age sub "+ subPersonAge);

/*        yaş alanı null deger içerebilir
        Bu durumda çalışma
        zamanında nullpointerexception istisnası elde edilecektir*/
        Person p6 = new Person("Kader", null);
        personList.add(p6);
        Double subPersonAge2 = personList.stream().filter(Objects::nonNull).map(p->p.getAge()).map(Double::valueOf).reduce(0.0,(a,b)-> (a+b)/2);

        System.out.println("****--------------**** ");

    }

}
