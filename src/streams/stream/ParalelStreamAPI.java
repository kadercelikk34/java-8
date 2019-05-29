package streams.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParalelStreamAPI {
    public static void main(String args[]){
        //Paralel Stream
        List<Integer> ints = Arrays.asList(1, 5, 3, 7, 11, 9, 15, 13);
        Stream<Integer> stream = ints.stream().parallel();
        Stream<Integer>  ıntegerStream = ints.parallelStream();

        System.out.println("****--------------**** ");

        // Aşağıda bir dizi sayısal ifadeyi filtreleyen, sıralayan ve çıktılayan bir kod parçası
        //görmekteyiz
       List<Integer>  sortedList = ints.parallelStream() // Paralel Stream
                .filter(Objects::nonNull) // null değilse
                .filter(n -> n > 0) // pozitif sayı ise
                .sorted() // sırala
                .collect(Collectors.toList());
       sortedList.forEach(System.out::println);

    }
}
