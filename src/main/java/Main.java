import controller.Race;
import util.RandomNumberGenerator;

public class Main {
    public static void main(String[] args) {
        Race race = new Race(new RandomNumberGenerator());
        race.start();
    }
}
