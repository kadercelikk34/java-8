package metod.defaulth;

public class Minibus implements Arac ,Tasit {
    @Override
    public void dur() {
        System.out.println("Minibus: duruyor..");
    }
    @Override
    public void gazla() {
        Arac.super.gazla();
        Tasit.super.gazla();

    }
}
