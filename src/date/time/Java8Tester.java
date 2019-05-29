package date.time;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class Java8Tester {
    public static void main(String args[]) {
        Java8Tester java8Tester = new Java8Tester();
        java8Tester.testLocalDateTime();
        java8Tester.testZonedDateTime();
        java8Tester.testChromoUnits();
        java8Tester.testPeriod();
        java8Tester.testDuration();
        java8Tester.testAdjusters();
        java8Tester.testBackwardCompatability();

    }

    public void testLocalDateTime() {
        LocalDateTime currentyTime = LocalDateTime.now();
        System.out.println("Currency DateTime: " + currentyTime);

        LocalDate date1 = currentyTime.toLocalDate();
        System.out.println("date1 : " + date1);

        Month month = currentyTime.getMonth();
        int day = currentyTime.getDayOfMonth();
        int seconds = currentyTime.getSecond();

        System.out.println("month : " + month + " day : " + day + " seconds : " + seconds);

        LocalDateTime date2 = currentyTime.withDayOfMonth(10).withYear(2017);
        System.out.println("date2 : " + date2);

        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3 : " + date3);

        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4 : " + date4);

        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5:" + date5);
        System.out.println("***************************");

    }

    public void testZonedDateTime() {
        ZonedDateTime date1 = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Karachi]");
        System.out.println("date1: " + date1);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId : " + id);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("currentZone : " + currentZone);
        System.out.println("***************************");

    }

    public void testChromoUnits() {
        LocalDate today = LocalDate.now();
        System.out.println("Current date : " + today);

        LocalDate newtWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("nextWeek : " + newtWeek);

        LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
        System.out.println("nextMonth : " + nextMonth);

        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("nextYear : " + nextYear);

        LocalDate nextDEcade = today.plus(1, ChronoUnit.DECADES);
        System.out.println("nextDEcade : " + nextDEcade);
        System.out.println("***************************");


    }

    public void testPeriod() {
        LocalDate date1 = LocalDate.now();
        System.out.println("date1 : " + date1);

        LocalDate date2 = date1.plus(1, ChronoUnit.MONTHS);
        System.out.println("date2 : " + date2);

        Period period = Period.between(date2, date1);
        System.out.println("period : " + period);
        System.out.println("***************************");


    }

    public void testDuration() {
        LocalTime time1 = LocalTime.now();
        Duration twoHours = Duration.ofHours(2);
        System.out.println("twoHours : " + twoHours);

        LocalTime time2 = time1.plus(twoHours);
        Duration duration = Duration.between(time1, time2);
        System.out.println("Duration : " + duration);
        System.out.println("***************************");

    }

    public void testAdjusters() {
        LocalDate date1 = LocalDate.now();
        System.out.println("Currency Date : " + date1);

        LocalDate nextTuesday = date1.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        System.out.println("Next Tuesday on  : " + nextTuesday);

        LocalDate firstInYear = LocalDate.of(date1.getYear(), date1.getMonth(), 1);
        System.out.println("firstInYear  : " + firstInYear);
        LocalDate secondSaturdayy = firstInYear.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println("secondSaturdayy  : " + secondSaturdayy);
        System.out.println("***************************");

    }
    public void testBackwardCompatability(){
        Date currentDate = new Date();
        System.out.println("currentDate  : " + currentDate);

        Instant now = currentDate.toInstant();
        ZoneId currencyZone = ZoneId.systemDefault();

        LocalDateTime  localDateTime = LocalDateTime.ofInstant(now , currencyZone);
        System.out.println("Local date  : " + localDateTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, currencyZone);
        System.out.println("zonedDateTime  : " + zonedDateTime);




    }
}

