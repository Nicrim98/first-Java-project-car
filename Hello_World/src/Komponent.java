public class Komponent {

    private String nazwa;
    private int waga;
    private float cena;

    public Komponent(String nazwa, int waga, float cena) {
        this.nazwa = nazwa;
        this.waga = waga;
        this.cena = cena;
    }

    public String getNazwa(){
        return nazwa;
    }

    public int getWaga(){
        return waga;
    }

    public float getCena(){
        return cena;
    }



}
