package metod.defaulth;

public interface Arac {
/*    Varsayılan metodlar default anahtar kelimesiyle tanımlanmaktadır.
    Varsayılan metodlar arayüzlere iş mantığı
    yerleştirmeye müsade eden özel metodlardır.*/
   //Defender metod
    default void gazla(){
        System.out.println("Araç: çalışıyor..");
    }
    void dur();
}
