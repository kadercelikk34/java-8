package annotations;
import java.lang.annotation.*;

//@Target notasyonun neteye ve nerelere uyg. belirtir.
//ElementType.METHOD ; Metod başlarına
//,ElementType.TYPE ; Sınıf , arayüz , soyut sınıf başlarına
//@Retention notasyona hangi zamanlarda erişebileceğini belirtir.

/*      SOURCE
           Notasyonlar derleme zamanında yok sayılır.
        CLASS
           Notasyonlar derleme zamanında sınıf içerisinde bulundurulur, fakat çalışma zamanında
           bulunması zorunlu değildir. Varsayılan hal budur.
        RUNTIME
           Notasyonlar çalışma zamanında erişilmek üzere sınıf içerisinde bulundurulur. Çalışma
           zamanında erişim Java Reflection API ile yapılır. Sık kullanılan hal budur.*/
@Repeatable(Multiple.class)// @Repeatable notasyonu tekrarlayacak notasyona uygulanmaktadır
@Target({ElementType.METHOD, ElementType.TYPE}) //Metod ve Sınıfların başına uygulanabilir.
@Retention(RetentionPolicy.RUNTIME)//Çalışma zamanında bu notasyona erişilebilir
public @interface Single {
    String value();


}
