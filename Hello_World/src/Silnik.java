import java.util.concurrent.ThreadLocalRandom;

public class Silnik extends Komponent implements Runnable, Obserwowany{

    @Override
    public void run() {
        while(true) {
            if(this.obroty != 0){
                this.obroty = this.obroty + ThreadLocalRandom.current().nextInt(-5, 5);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(obserwator != null){
                obserwator.inform();
            }
        }
    }

    Obserwator obserwator;
    private int obroty = 0;
    private int max_obroty = 12000;

    public Silnik(String nazwa, int waga, float cena, int obroty, int max_obroty) {
        super(nazwa, waga, cena);
        this.max_obroty = max_obroty;
        this.obroty = obroty;
    }

    public int getObroty() {
        return obroty;
    }

    public int getMax_obroty() {
        return max_obroty;
    }

    public void uruchom(){
        obroty = 800;
        System.out.println("Silnik uruchomiony");
        System.out.println("Obroty = " + obroty);
    }

    public void zatrzymaj(){
        obroty = 0;
        System.out.println("Silnik zatrzymany");
        System.out.println("Obroty = " + obroty);
    }

    public void zwieksz_obroty(){
        if(obroty != 0) {
            obroty = obroty + 100;
            if (obroty >= max_obroty) obroty = max_obroty;
            System.out.println("Obroty = " + obroty);
        }
    }

    public void zmniejsz_obroty(){
        if(obroty != 0) {
            obroty = obroty - 100;
            if (obroty < 800) obroty = 800;
            System.out.println("Obroty = " + obroty);
        }
    }

    @Override
    public void subscribe(Obserwator o) {
        this.obserwator = o;
    }

    @Override
    public void unsubscribe(Obserwator o) {
        this.obserwator = o;
    }
}
