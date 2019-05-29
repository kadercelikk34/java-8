package consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class ConsumerAPI {
    public static void main(String args[]) {
        //Consumer
        Consumer<String> consumer = (String msg) -> {
            System.out.println(msg);
        };
        //T tipinde parametre alır geriye deger döndürmez.
        consumer.accept("Merhaba Dünya");

/*        Consumer<String> consumer1 = (msg) -> {
            System.out.println(msg);

        };*/
/*        Consumer<String> consumer2 = e -> {
            System.out.println(e);

        };*/
        List<String> names = Arrays.asList("A","B","C");
        names.forEach(consumer);

        Consumer<String> consumer1 = App::listele;
        consumer1.accept("Deneme");

        names.forEach(App::listele);
        names.forEach(System.out::println);

        //BiConsumer
        //T ve U tipinde  parametreler alır ve geriye değer döndürmez.
        BiConsumer<String, Integer> biConsumer = (name, age)->{
            System.out.println(name +" "+ age);
        };
        biConsumer.accept("Lusi" ,25);

        //Function
        //T tipinde bir parametre alır ve R tipinde deger döndürür
        Function<Integer, Integer> function = t-> Math.min(t,7);
        Integer result = function.apply(5);
        System.out.println(result);

        //UnaryOperator
        //Function türündedir. R ve T  tipleri aynı türden ise UnaryOperator olur.
        UnaryOperator<Integer> unaryOperator = a -> Math.max(a,5);
        Integer result1 = unaryOperator.apply(9);
        System.out.println(result1);

        //BiFunction
        //T ve U tipinde iki parametre alır R tipinde deger döndürür.Function farkı iki parametre almasıdır.
        BiFunction<Integer, Integer ,String> biFunction = (a, b)-> "Sonuç :"+(a+b);
        String result2 = biFunction.apply(3,5);
        System.out.println(result2);

        //BinaryOperator
        //BiFunction türündedir.T,U, R aynı tipde ise BinaryOperator kulanılabilir.
        BinaryOperator<Integer> binaryOperator = (a, b)->a+b;
        Integer result3 =binaryOperator.apply(3,5);
        System.out.println(result3);

        //Predicate
        //T tipinde parametre alır ve şarta bağlı olarak true -false  döndürür.
        Predicate<Integer> predicate = a -> (a >0);
        boolean pos = predicate.test(5);
        boolean neg = predicate.test(-5);
        System.out.println("pos : "+pos +" neq : "+ neg);

        //BiPredicate
        // T ve U tipinde parametre alır şartlı olarak true/ false döndürür.
        BiPredicate<Integer, Integer> biPredicate = (a, b) -> (a>b);
        boolean bigger = biPredicate.test(5,4);
        boolean lower = biPredicate.test(5, 7);
        System.out.println("bigger : "+bigger +" lower : "+ lower);

        //Supplier
        // hiç parametre almaz T tipinde deger  döndürür.Factory patern için uygundur.
        Supplier<List> supplier = () -> new ArrayList<>();
        List<String> liste =supplier.get();
        liste.add("Ali");
        liste.add("veli");
        liste.add("selami");
        System.out.println("bigger : "+liste );








    }
}
