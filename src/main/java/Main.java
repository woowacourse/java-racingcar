import controller.Race;
import model.RandomNumberGenerator;

public class Main {
    public static void main(String[] args) {
        Race race = new Race(new RandomNumberGenerator());
        race.start();
    }
}
