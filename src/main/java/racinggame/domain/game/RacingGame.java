package racinggame.domain.game;

import racinggame.domain.car.Cars;
import racinggame.domain.car.movable.MovAbleStrategy;
import racinggame.domain.data.Names;
import racinggame.domain.data.GameStatus;
import racinggame.domain.car.Car;

import java.util.List;
import java.util.Map;

/**
 * RacingGame 클래스는 자동차 리스트를 만들어 경주를 진행하고 그 결과를 출력한다.
 * 클래스 메서드를 통해 수행되도록 설계되었다.
 */
public class RacingGame {
    private Cars cars;
    private final GameStatus gameStatus;

    public RacingGame(Names names, MovAbleStrategy movAbleStrategy) {
        cars = new Cars(movAbleStrategy);
        gameStatus = new GameStatus(names.splitNamesByComma());
        initCars(names);
    }

    private void initCars(Names names) {
        List<String> splitName = names.splitNamesByComma();

        for (String name : splitName) {
            cars.add(new Car(name));
        }
    }

    /**
     * moveCars는 Cars가 보유한 자동차들에 대해서 이동을 수행하고, 이를 gameStatus에 기록하는 메서드이다.
     * 이후 gameStatus에서 정리된 기록값을 Map형태로 컨트롤러에 반환한다.
     *
     * @return 게임 기록이 정리된 Map<String, Integer> 인스턴스를 반환한다.
     */
    public Map<String, Integer> moveCars() {
        cars.moveCars(gameStatus);
        return gameStatus.getStatusLog();
    }

    public List<String> getWinners() {
        return gameStatus.makeWinnerNames();
    }
}