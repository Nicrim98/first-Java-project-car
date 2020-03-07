import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class SamochodGUI implements Obserwator {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTabbedPane tabbedPane2;
    private JTabbedPane tabbedPane3;
    private JTabbedPane tabbedPane4;
    private JTabbedPane tabbedPane5;
    private JTextField nazwa_silnika;
    private JTextField obroty_silnika;
    private JTextField cena_silnika;
    private JTextField waga_silnika;
    private JButton dodajGazuButton;
    private JButton ujmijGazuButton;
    private JButton włącz_sprzęgło;
    private JButton wyłącz_sprzęgło;
    private JTextField nazwa_samochodu;
    private JTextField waga_samochodu;
    private JTextField waga_skrzyni;
    private JSlider aktualny_bieg;
    private JTextField nazwa_skrzyni;
    private JTextField cena_skrzyni;
    private JTextField bieg_skrzyni;
    private JTextField waga_sprzęgła;
    private JTextField cena_sprzęgła;
    private JTextField stan_sprzęgła;
    private JTextField nazwa_sprzegla;
    private JButton wyłącz_samochód;
    private JButton włącz_samochód;
    private JTextField predkosc;

    private Samochod samochod;

    public SamochodGUI(Samochod s) {

        this.samochod = s;
        s.getSilnik().subscribe(this);



        dodajGazuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.getSilnik().zwieksz_obroty();
                samochod.oblicz_predkosc_plus();
                refresh();
            }
        });
        ujmijGazuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.getSilnik().zmniejsz_obroty();
                samochod.oblicz_predkosc_minus();
                refresh();
            }
        });
        włącz_sprzęgło.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.getSprzeglo().zalacz();
                refresh();
            }
        });
        wyłącz_sprzęgło.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.getSprzeglo().rozlacz();
                refresh();
            }
        });
        aktualny_bieg.addComponentListener(new ComponentAdapter() {
        });
        aktualny_bieg.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                try {
                    if(aktualny_bieg.getValue() != samochod.getSkrzynia_biegow().getAktualnyBieg()){
                        if(aktualny_bieg.getValue() > samochod.getSkrzynia_biegow().getAktualnyBieg()){
                            samochod.oblicz_predkosc_plus();
                            samochod.getSkrzynia_biegow().zmienBieg(aktualny_bieg.getValue());
                        }
                        else {
                            samochod.oblicz_predkosc_minus();
                            samochod.getSkrzynia_biegow().zmienBieg(aktualny_bieg.getValue());
                        }
                    }
                } catch (SprzegloException sprzegloexception){
                      JOptionPane.showMessageDialog(null,"Najpierw wciśnij sprzęgło !");
                      //sprzegloexception.printStackTrace();
                }
                refresh();
            }
        });
        nazwa_skrzyni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.getSkrzynia_biegow().getNazwa();
                refresh();
            }
        });

        waga_skrzyni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.getSkrzynia_biegow().getWaga();
                refresh();
            }
        });
        cena_skrzyni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.getSkrzynia_biegow().getCena();
                refresh();
            }
        });

        nazwa_samochodu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.getMarka();
                samochod.getModel();
                refresh();
            }
        });
        waga_samochodu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.obliczWage();
                refresh();
            }
        });
        włącz_samochód.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samochod.getSprzeglo().getStanSprzegla() == true && samochod.getSkrzynia_biegow().getAktualnyBieg() < 3) {
                    samochod.wlacz();
                    refresh();
                }
                if(samochod.getSprzeglo().getStanSprzegla() == false){
                    JOptionPane.showMessageDialog(null,"Najpierw wciśnij sprzęgło, aby uruchomic silnik");
                }
                if(samochod.getSkrzynia_biegow().getAktualnyBieg() >= 3){
                    JOptionPane.showMessageDialog(null,"Wiem, że to Tico, ale z trojki to i on nie wystartuje ;)");
                }
            }
        });
        wyłącz_samochód.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.wylacz();
                samochod.oblicz_predkosc_minus();
                refresh();
            }
        });
        bieg_skrzyni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod.getSkrzynia_biegow().getAktualnyBieg();
                refresh();
            }
        });
    }


    public static void main(String[] args) {

        Silnik silnik = new Silnik("F8CV", 50, 1000, 800, 8000);
        Sprzeglo sprzeglo1 = new Sprzeglo("VALEO 828922", 50, 100, false);
        SkrzyniaBiegow piatka = new SkrzyniaBiegow("Daewoo Tico 800", 50, 300, 5, 0, sprzeglo1);
        Samochod opel = new Samochod("pomarańczowy", "R1 JOKER", "Tico", "Daewoo", 140, sprzeglo1, silnik, piatka);
        silnik.zatrzymaj();

        Thread t = new Thread(opel.getSilnik());
        t.start();

        JFrame frame = new JFrame("SamochodGUI");
        frame.setContentPane(new SamochodGUI(opel).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
    public void inform(){ refresh();}

    public void refresh(){
        nazwa_silnika.setText(samochod.getSilnik().getNazwa());
        waga_silnika.setText(samochod.getSilnik().getWaga() + "");
        cena_silnika.setText(samochod.getSilnik().getCena() + "");
        obroty_silnika.setText(samochod.getSilnik().getObroty() + "");
        predkosc.setText(samochod.getPredkosc() + "");

        nazwa_sprzegla.setText(samochod.getSprzeglo().getNazwa());
        waga_sprzęgła.setText(samochod.getSprzeglo().getWaga() + "");
        cena_sprzęgła.setText(samochod.getSprzeglo().getCena() + "");
        if( samochod.getSprzeglo().getStanSprzegla() == true){
            stan_sprzęgła.setText("Załączone");
        }
        else{
            stan_sprzęgła.setText("Rozłączone");
        }

        nazwa_skrzyni.setText(samochod.getSkrzynia_biegow().getNazwa());
        waga_skrzyni.setText(samochod.getSkrzynia_biegow().getWaga() + "");
        cena_skrzyni.setText(samochod.getSkrzynia_biegow().getCena() + "");
        bieg_skrzyni.setText(samochod.getSkrzynia_biegow().getAktualnyBieg() + "");

        waga_samochodu.setText(samochod.obliczWage() + "");
        nazwa_samochodu.setText(samochod.getMarka() + " " + samochod.getModel());

    }
    public void setData(Samochod data) {
    }

    public void getData(Samochod data) {
    }

    public boolean isModified(Samochod data) {
        return false;
    }
}