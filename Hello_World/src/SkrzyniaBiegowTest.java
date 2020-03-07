import static org.junit.Assert.*;

public class SkrzyniaBiegowTest {

        @org.junit.Test
        public void zmienBieg () {
        Sprzeglo s = new Sprzeglo("Siema", 200, 100, false);
        Silnik si = new Silnik("nowy_silnik", 500, 150, 0,3000);
        SkrzyniaBiegow a = new SkrzyniaBiegow("Skrzynia", 200, 300, 4, 0, s);

        try {
            a.zmienBieg(1);
            System.out.println(a.getAktualnyBieg());
            assertEquals(1, a.getAktualnyBieg());
        }catch (SprzegloException e){

        }
        }
    @org.junit.Test
    public void obliczPrzelozenie() {
    }
}