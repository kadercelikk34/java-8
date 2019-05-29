package lambda;

public class LambdaExpressions {
    final static String salutation = "Hello!";
    public static void main(String args[]){

        LambdaExpressions tester = new LambdaExpressions();

        // a ve b değişkenlerinin type bilgisi verilmiştir
        MathOperation addition = (int a, int b)-> a + b;

        //type verilmeden
        MathOperation subtraction = (a, b) -> a - b;

        //type bilgisi ve parantez içerirde return verilmiştir
        MathOperation multiplication = (int a, int b) -> {return a*b; };
        //type belirtilmiş ,return edilmemiş
        MathOperation division = (int a, int b)-> a/b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = "+tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " +tester.operate(10, 5, division));

        //parametre parantez içinde verilmemiştir.
        GreetingService greetService1 = message ->
                System.out.println("hello " + message);

        //parametre parantezsiz verilmiştir
        GreetingService greetingService2 = (message)->
                System.out.println(salutation + message);

        greetService1.sayMessage("Burcu");
        greetingService2.sayMessage("Bilge");

        System.out.println("***************************");

        MathOperation operation = (int a, int b)-> a + b;
        int addition1 = operation.operation(10,5);
        System.out.println("10 + 5 = "+ addition1);
    }
    interface MathOperation{
        int operation(int a, int b);
    }
    interface GreetingService{
        void sayMessage(String message);
    }
    private int operate(int a,int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
