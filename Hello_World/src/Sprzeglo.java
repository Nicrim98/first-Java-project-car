public class Sprzeglo extends Komponent{

    private boolean stanSprzegla;

    public Sprzeglo(String nazwa, int waga, float cena, boolean stanSprzegla) {
        super(nazwa, waga, cena);
        this.stanSprzegla = stanSprzegla;
    }

    public void zalacz(){
        stanSprzegla = true;
        System.out.println("Sprzeglo zalaczone");
    }

    public void rozlacz(){
        stanSprzegla = false;
        System.out.println("Sprzeglo rozlaczone");
    }

    public boolean getStanSprzegla(){
        return stanSprzegla;
    }

}
