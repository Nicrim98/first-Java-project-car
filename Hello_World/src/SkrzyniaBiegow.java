public class SkrzyniaBiegow extends Komponent{

    private int iloscBiegow;
    private int aktualnyBieg;
    private int aktualnePrzelozenie;
    private Sprzeglo sprzeglo;

    public SkrzyniaBiegow(String nazwa, int waga, float cena, int iloscBiegow, int aktualnyBieg, Sprzeglo s) {
        super(nazwa, waga, cena);
        this.iloscBiegow = iloscBiegow;
        this.aktualnyBieg = aktualnyBieg;
        sprzeglo = s;
    }

    public void zmienBieg(int nr_biegu) throws SprzegloException{
        if(!sprzeglo.getStanSprzegla()){
            throw new SprzegloException("Sprzeglo musi byc zalaczone");
        }
        else{
            aktualnyBieg = nr_biegu;
            System.out.println("Bieg zmieniony");
        }

    }

    public int getAktualnyBieg(){
        return aktualnyBieg;
    }

    public void obliczPrzelozenie(){

    }

}

