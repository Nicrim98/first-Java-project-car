public class CodingBat {


    public static void main(String[] args){
        System.out.println(helloName.helloName("Marcin"));
       // System.out.println(bobthere.bobThere.bobThere("bb3buhdowniczy"));
       // System.out.println(gHappy.gHappy("123g"));
        Silnik silnik = new Silnik("V8", 50, 1000, 800, 1200);
        Silnik V12 = new Silnik("V12", 120, 1000, 800, 1200);
        Sprzeglo sprzeglo = new Sprzeglo("sprzeglo", 50, 100, true);
        Sprzeglo sprzeglo1 = new Sprzeglo("sprzeglo1", 50, 100, true);
        SkrzyniaBiegow szostka = new SkrzyniaBiegow("szostka", 50, 300, 6, 0, sprzeglo);
        Samochod opel = new Samochod("czerwony", "RZE 5PP5", "Astra", "Opel", 220, sprzeglo, silnik, szostka);
        Samochod mercedes = new Samochod("niebieski", "RZE", "R320", "Mercedes", 300, sprzeglo1, V12, szostka);
        System.out.println(opel.obliczWage());
        System.out.println(mercedes.obliczWage());
        mercedes.wlacz();
        SkrzyniaBiegow a = new SkrzyniaBiegow("Skrzynia", 200, 300, 4, 0, sprzeglo1);
        try {
            a.zmienBieg(1);
        } catch (SprzegloException e) {
            e.printStackTrace();
        }

        silnik.zwieksz_obroty();
    }
}
