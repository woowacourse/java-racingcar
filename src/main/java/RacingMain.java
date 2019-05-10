import controller.RacingController;
import domain.Race;

public class RacingMain {
    public static void main(String[] args) {
        Race race = RacingController.moveAllCar(RacingController.setCarsOnRace(), RacingController.setRoundCount());
        RacingController.printWinners(race);
    }
}
