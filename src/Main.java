public class Main {
    public static void main(String[] args) {
        System.out.println("Gara Atletica");
        for (int i = 3; i > 0;i--) {
            System.out.println("inizio in:" +i);
        }
        System.out.println("Caratteristiche Main"+Thread.currentThread().getName());
    }
}