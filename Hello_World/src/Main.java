public class Main {

    public static void main(String[] args) { System.out.println("Hello World!"); }

    class Bird extends Animal {

        public String getName() {
            return "bird";
        }

        public void fly() {
            System.out.println("I can fly!");
        }
    }
}
