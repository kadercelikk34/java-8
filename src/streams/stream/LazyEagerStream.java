package streams.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class LazyEagerStream {
    public static void main(String args[]) {
        /*Lazy davranışlı olan zincirli görevler, bir Eager operasyona gelene kadar koşturulmamaktadır.
        Fakat bu hazırlanan Stream nesnesi, yukarıdaki gibi bir Eager operasyonla karşılaşırsa,
        önceki zincirlerde biriken Lazy işlemleri de harekete geçirecektir */
        List<Integer> names = Arrays.asList(1, 2, 3, 6, 7, 8, 9);
        Stream<Integer> ıntegerStream =
                names.stream()
                        .filter(Objects::nonNull)//Lazy
                        .filter(s -> s % 2 == 1)//Lazy
                        .map(n -> n * 2);//Lazy
        ıntegerStream.forEach(System.out::println);//Eager


    }
}
