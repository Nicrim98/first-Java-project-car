public class Samochod {

    private String kolor;
    private String nrRejest;
    private String model;
    private String marka;
    private int vmax;
    private boolean stan_samochodu = false;
    private int predkosc = 0;

    private Sprzeglo sprzeglo;
    private Silnik silnik;          // kompozycja
    private SkrzyniaBiegow skrzynia_biegow;


    public Samochod(String kolor, String nrRejest, String model, String marka, int vmax, Sprzeglo sprzeglo, Silnik silnik, SkrzyniaBiegow skrzynia_biegow) {
        this.kolor = kolor;
        this.nrRejest = nrRejest;
        this.model = model;
        this.marka = marka;
        this.vmax = vmax;
        this.sprzeglo = sprzeglo;
        this.silnik = silnik;
        this.skrzynia_biegow = skrzynia_biegow;
    }

    public String getMarka() {
        return marka;
    }

    public Silnik getSilnik() {
        return silnik;
    }

    public SkrzyniaBiegow getSkrzynia_biegow() {
        return skrzynia_biegow;
    }

    public Sprzeglo getSprzeglo() {
        return sprzeglo;
    }

    public void wlacz(){
        stan_samochodu = true;
        silnik.uruchom();
    }

    public void wylacz(){
        stan_samochodu = false;
        silnik.zatrzymaj();
    }

    public int obliczWage(){
        return skrzynia_biegow.getWaga() + sprzeglo.getWaga() + silnik.getWaga();
    }
    public String getModel(){
        return model;
    }
    public int getPredkosc(){
        return predkosc;
    }

    public int oblicz_predkosc_plus(){
        if(stan_samochodu == true){
            if (getSkrzynia_biegow().getAktualnyBieg() == 0) {
                predkosc = 0;
            }
            if (getSilnik().getObroty() > 1000) {
                predkosc = predkosc + (getSilnik().getObroty() * getSkrzynia_biegow().getAktualnyBieg()) / 1000;
            }
            if (getSilnik().getObroty() > 0 && getSilnik().getObroty() < 1000) {
                predkosc = predkosc++;
            }
        }
        else{
            predkosc = 0;
        }
        return predkosc;
    }
    public int oblicz_predkosc_minus(){
        if(stan_samochodu == true) {
            if (getSkrzynia_biegow().getAktualnyBieg() == 0) {
                predkosc = 0;
            }
            if (getSilnik().getObroty() > 1000) {
                predkosc = predkosc - (getSilnik().getObroty() * getSkrzynia_biegow().getAktualnyBieg()) / 1000;
            }
            if (getSilnik().getObroty() > 0 && getSilnik().getObroty() < 1000) {
                predkosc = predkosc--;
            }
        }
        else{
            predkosc = 0;
        }
        return predkosc;
    }
}