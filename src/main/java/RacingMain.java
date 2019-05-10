import controller.RacingController;
import domain.Race;

/**
 * Created by Heebg
 * User: heebg
 * Date: 2019-05-08
 */
public class RacingMain {
    public static void main(String[] args) {
        Race race = RacingController.moveAllCar(RacingController.setCarName(), RacingController.setRoundCount());
        RacingController.printWinners(race);
    }
}
