package streams.stream;

import streams.model.Person;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class StreamAPI {
    public static void main(String[] args) {

        IntStream ıntStream = IntStream.of(1,2,3);//(1,2,3) içeren IntStream nesnesi
        IntStream ıntRange = IntStream.range(1,10);//(1,…,10) arasını içeren IntStream nesnesi
        DoubleStream doubleStream =  DoubleStream.of(1.0, 3.5, 6.6);//(1.0, 3.5, 6.6) içeren DoubleStream nesnesi
        LongStream longStream = LongStream.of(3, 5, Long.MAX_VALUE, 9);//(3, 5, Long.MAX_VALUE,9) içeren LongStream nesnesi
        LongStream longrange = LongStream.range(1,100);//(1,…,100) arasını içeren LongStream nesnesi
        ıntStream.forEach(System.out::println);
        System.out.println("****--------------**** ");

        List<String> names =
                Arrays.asList("Ali", "Veli", "Selami", "Cem", "Zeynel", "Can", "Hüseyin");
        //stream foreach
        names.stream().forEach(name -> {
            System.out.println("Stream foreach name " + name);
        });

        long nameCount = names.stream().filter(name->name=="Ali").count();
        System.out.println("Ali name count "+ nameCount);


        System.out.println("****--------------**** ");

/*      stream filter
        Stream içerisindeki yığınsal veri üzerinde süzme işlemi yapar*/
        names.stream().filter(name -> name.length() == 3).forEach(name -> {
            System.out.println("Stream filter name " + name);
        });

        System.out.println("****--------------**** ");

        /*      Stream  distinct
        stream içerisindeki tekrarlı verileri çıkarmak için kullnılır*/
        IntStream ıntStreamDistinct = IntStream.of(1, 1, 2, 3, 5, 8, 13, 13, 8);
        ıntStreamDistinct.distinct().forEach(System.out::println);

        System.out.println("****--------------**** ");

/*      stream sorted
        Stream içerindeki yığınsal verinin sıralanmış stream nesnesini döndürür  */
        IntStream ıntStreamSorted = IntStream.of(13, 1, 3, 5, 8, 1, 13, 2, 8);
        ıntStreamSorted.sorted().forEach(System.out::println);

        System.out.println("****--------------**** ");

/*      Stream limit
        Bir Stream yığını içerisindeki ilk N veri barındıran yeni bir Stream nesnesi sunmaktadır*/
        LongStream range = LongStream.range(1, 1000);
        range.limit(12).forEach(System.out::println);

        System.out.println("****--------------**** ");

/*      Stream count
        Stream içerisindeki eleman sayısını hesaplar.*/
        IntStream rangeCountList = IntStream.range(1,10);
        IntStream rangeCloseCountList = IntStream.rangeClosed(1,10);
        System.out.println("range count : " + rangeCountList.count());
        System.out.println("rangeClose count : " + rangeCloseCountList.count());

        System.out.println("****--------------**** ");

    /*  Stream#collect
        Stream nesnelerini başka biçimdeki
        bir nesneye, veri yapısına dönüştürmek için kullanılmaktadır*/
        List<String> list = names.stream().collect(Collectors.toList());//Stream nesnesinden List nesnesi üretir
        System.out.println(list);

        System.out.println("****--------------**** ");

        Set<String> set = names.stream().collect(Collectors.toSet());//Stream nesnesinden Set nesnesi üretir
        System.out.println(set);

        System.out.println("****--------------**** ");

        Long count = names.stream().collect(Collectors.counting());//Stream nesnesinin eleman sayısını üretir.
        System.out.println(count);

        System.out.println("****--------------**** ");

        String collect = names.stream().collect(Collectors.joining(" - "));//Stream nesnesini birleştirir
        System.out.println(collect);

        System.out.println("****--------------**** ");

        Map<Integer, List<String>> ıntegerListMap = names.stream().collect(Collectors.groupingBy(name-> name.length()));//Stream nesnesini isim uzunluğuna göre gruplar.
        System.out.println(ıntegerListMap);

        System.out.println("****--------------**** ");
        System.out.println("****-------Exercises -------**** ");

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("filtered : "+ filtered);

        System.out.println("****--------------**** ");

        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        System.out.println("****--------------**** ");

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> squareList = numbers.stream().map(i->i*i).distinct().collect(Collectors.toList());
        System.out.println("squareList : "+ squareList);

        System.out.println("****--------------**** ");

        long stringCount = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println("stringCount : "+ stringCount);

        //‘limit’ yöntemi, akışın boyutunu azaltmak için kullanılır.
        System.out.println("****--------------**** ");
        numbers.stream().limit(5).forEach(System.out::println);

        System.out.println("****--------------**** ");

        numbers.stream().sorted().forEach(System.out::println);

        System.out.println("****--------------**** ");

        //Paralel stream count
        long paralelStreamCount = strings.parallelStream().filter(s->s.isEmpty()).count();
        System.out.println("paralelStreamCount : "+ paralelStreamCount);

        System.out.println("****--------------**** ");

        //Statistics
        IntSummaryStatistics statistics = numbers.stream().mapToInt((x)->x).summaryStatistics();
        System.out.println("statistics max number : "+ statistics.getMax());
        System.out.println("statistics min number : "+ statistics.getMin());
        System.out.println("statistics sum number : "+ statistics.getSum());
        System.out.println("statistics average number : "+ statistics.getAverage());

        System.out.println("****--------------**** ");

        Person p1 = new Person("Ahmet", 12);
        Person p2 = new Person("Ali", 16);
        Person p3 = new Person("Ayşe", 30);
        Person p4 = new Person("Murat", 51);
        Person p5 = new Person("Zeynep", 15);
        List<Person> personList = Arrays.asList(p1, p2, p3, p4, p5);

        //Match Example
        boolean b1 = personList.stream().allMatch( s -> s.getName().startsWith("A"));
        System.out.println("stream allMatch b1 "+ b1);//false

        System.out.println("****--------------**** ");

         //noneMatch
        // herhangi bir akış öğesinin belirtilen yüklemeyle eşleşmemesi durumunda true döndürür, akış öğelerinin herhangi biri, belirtimle belirtilen koşulla eşleşirse false döndürür.
        boolean noneMatch1 = personList.stream().noneMatch(s->s.getName().startsWith("A"));
        System.out.println("stream noneMatch1 "+ noneMatch1);//false

        boolean noneMatch2 = personList.stream().noneMatch(s->s.getName().contains("Kader"));
        System.out.println("stream noneMatch2 "+ noneMatch2);//true

        boolean anyMatch = personList.stream().anyMatch(s->s.getName().startsWith("M"));
        System.out.println("stream anyMatch "+ anyMatch);//true

















    }
}
