import controller.RacingController;
import domain.Race;

public class RacingMain {
    static RacingController racingController = new RacingController();

    public static void main(String[] args) {
        Race race = racingController.moveAllCar(racingController.setCarName(), racingController.setRoundCount());
        racingController.printWinners(race);
    }

}
