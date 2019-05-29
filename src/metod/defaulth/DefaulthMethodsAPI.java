package metod.defaulth;

public class DefaulthMethodsAPI {
    public static void main(String args[]){
        Minibus minibus = new Minibus();
/*        Minibus sınıfı türünden nesneler `Arac arayüzü içerisindeki
        gazla() metodunu koşturabilecektir.*/
        minibus.gazla(); //Arac içindeki gazla() varsayılan metodu koşturuluyor.
        minibus.dur(); //Minibus içindeki dur() metodu koşturuluyor.
        System.out.println("***************************");
        Arac otobus = () -> System.out.println("Otobüs duruyor..");
        otobus.gazla();
        otobus.dur();

    }
}
