package date.time;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Set;

public class LocalDateTimeAPI {
    public static void main(String args[]) {

        System.out.println("---------------LocalDate---------------" + "\n");

        //LocalDate sınıfı ile tarihsel zaman temsil edilir. Örneğin: 10/10/2010
        //"of" metodu ile LocalDate nesnesi oluşturulabilir
        LocalDate localDate = LocalDate.of(2019, 04, 12);
        System.out.println("Local Date : " + localDate);

        //"now" metodu ile o anın tarihi elde edilir.
        LocalDate now = LocalDate.now();
        System.out.println("Now Date : " + now);

/*        LocalDate
        sınıfı immutable ’dir. Bu sebeple with ,plus,minus metodları farklı bir LocalDate nesne döndürür. O anki
        nesneyi düzenlemez.*/

        //"with*" metodu ile eldeki bir LocalDate için gün, ay, yıl alanları düzenlenebilir.
        //now.with(ChronoField.YEAR,2012).with(ChronoField.MONTH_OF_YEAR, 8).with(ChronoField.DAY_OF_MONTH, 8);
        LocalDate withDate = now.withYear(1994).withMonth(02).withDayOfMonth(20);
        System.out.println("withDate : " + withDate);

        //"plus*" metodu ile eldeki bir LocalDate için gün, ay, yıl alanları artırılabilir.
        //now.plusWeeks(2).plusDays(3).plusYears(3).plusDays(7);
        LocalDate plusDate = now.plus(2, ChronoUnit.WEEKS).plus(3, ChronoUnit.YEARS).plus(1, ChronoUnit.DAYS);
        System.out.println("plusDate : " + plusDate);

        //"minus*" metodu ile eldeki bir LocalDate için gün , ay , yıl alanları azaltılabilir
        // now.minusDays(5).minusMonths(2);
        LocalDate minusDate = now.minus(2, ChronoUnit.WEEKS).minus(3, ChronoUnit.YEARS).minus(33, ChronoUnit.DAYS);
        System.out.println("minusDate : " + minusDate);

        System.out.println("---------------LocalTime---------------" + "\n");

        //LocalTime sınıfı ile saatsel zaman temsil edilir. Örneğin: 20:11 , 18:15:55
        LocalTime localTime = LocalTime.now();
        System.out.println("Local Time now  : " + localTime);

        LocalTime time = LocalTime.of(18, 20, 55);
        System.out.println("Local Time : " + time);
        System.out.println("Local time getHour : " + time.getHour() + " time getMinute : " + time.getMinute() + " time getSecond : " + time.getSecond());

        System.out.println("Local Time  NOON: " + LocalTime.NOON);

        System.out.println("Local Time  MIDNIGHT: " + LocalTime.MIDNIGHT);

        System.out.println("Local Time Parse : " + LocalTime.parse("10:05"));

        LocalTime time1 = time.plusSeconds(45).minusSeconds(5).minus(5, ChronoUnit.SECONDS);
        System.out.println("Local Time1 : " + time1);

        System.out.println("---------------LocalDateTime---------------" + "\n");

        //LocalDateTime sınıfı ile hem tarihsel hem saatsel zaman temsil edilir. Örneğin: 10/10/2010  , 15:22:33
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Local Date Time now  : " + localDateTime);

        LocalDateTime dateTime = LocalDateTime.of(2014, Month.APRIL, 3, 4, 5, 45);
        System.out.println("Local date time getYear : " + dateTime.getYear() + " time getMonth : " + dateTime.getMonth() + " time getDayOfMonth : " + dateTime.getDayOfMonth());

        LocalDate date = dateTime.toLocalDate();
        System.out.println("dateTime.toLocalDate  : " + date);

        LocalTime time2 = dateTime.toLocalTime();
        System.out.println("dateTime.toLocalTime  : " + time2);

        LocalDateTime dateTime1 = dateTime
                .minusDays(3)
                .plusYears(3)
                .plusMinutes(3)
                .minusWeeks(5)
                .plusSeconds(2)
                .plus(3, ChronoUnit.DECADES)
                .minus(3, ChronoUnit.DECADES);
        System.out.println("dateTime1  : " + dateTime1);

        System.out.println("--------------- ZoneId---------------" + "\n");

        //ZoneId sınıfı, dünya üzerindeki saat dilimlerinin temsili için oluşturulmuştur.
        Set<String> zones = ZoneId.getAvailableZoneIds();
        zones.stream().sorted().forEach(System.out::println);

        System.out.println("my computer zone  : " +  ZoneId.systemDefault());

        System.out.println("--------------- ZonedDateTime---------------" + "\n");

/*        ZonedDateTime sınıfı aslında saat dilimi katıştırılmış LocalDateTime sınıfıdır desek yeridir.
        LocalDateTime sınıfından farkı genel olarak temsil ettiği zamanı saat dilimi içerir olarak
        sunmasıdır*/
       ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("zonedDateTime  : " + zonedDateTime);

        ZoneId istanbul = ZoneId.of("Europe/Istanbul");
        System.out.println("istanbul  : " + istanbul);
        System.out.println("ZonedDateTime istanbul  : " +  ZonedDateTime.now(istanbul));
        ZonedDateTime japan = ZonedDateTime.now(ZoneId.of("Japan"));
        System.out.println("ZonedDateTime Japan  : " +japan);

/*        Bir ZonedDateTime nesnesi LocalDateTime , LocalDate ve LocalTime
        karşılıklarına dönüştürülebilmektedir*/

        System.out.println("japan toLocalDateTime  : " + japan.toLocalDateTime());
        System.out.println("japan toLocalDate  : " + japan.toLocalDate());
        System.out.println("japan toLocalTime  : " + japan.toLocalTime());













    }
}
