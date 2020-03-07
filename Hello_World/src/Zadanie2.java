/**
 * Created by Norbi on 2016-10-11.
 */
import java.util.Random;

public class Zadanie2 {
    public static void main(String[] args) {

        Animal a;
        Bird b = new Bird();
        Parrot p = new Parrot();
        Tiger t = new Tiger();
        Snake s = new Snake();
        Cow c = new Cow();
        Lion l = new Lion();

        a = b;
        System.out.println(a.getName());

        a = p;
        System.out.println(a.getName());

        b = p;
        b.fly();

        p.live(); //dziedziczone!

        System.out.println(l.getName());
        l.ability();

        Animal tablica[] = new Animal[100]; //tablica 100 zwierzat
        Random r = new Random();
        for(int i=0; i < 100; i++){
            int x = r.nextInt(4);
            if(x==0){ tablica[i] = p; }
            else if(x==1){  tablica[i] = c;}
            else if(x==2){  tablica[i] = l;}
            else if(x==3){  tablica[i] = t;}
            else if(x==4){  tablica[i] = s;}
        }
        for(int i=0; i < 100; i++){
            System.out.println(tablica[i].getName());
        }

    }
}