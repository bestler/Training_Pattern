import java.util.Random;

public class Application {
    public static void main (String[] args){
        Rock rock = new Rock();
        Blasting destroyer = new E02();
        destroyer.setComposition();
        destroyer.blast(rock);
        System.out.println("Test");
    }
}
