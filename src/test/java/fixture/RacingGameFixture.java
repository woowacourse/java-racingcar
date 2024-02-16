package fixture;

import java.util.List;
import model.Car;
import model.RacingGame;

public class RacingGameFixture {
    public static RacingGame 레이싱게임(Car... cars) {
        return new RacingGame(List.of(cars));
    }
}
