package racinggame.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.domain.TestMovableStrategy;
import racinggame.domain.car.Cars;
import racinggame.domain.data.Names;
import racinggame.domain.data.GameStatus;
import racinggame.domain.car.Car;

public class CarsTest {
    private Cars cars = new Cars(new TestMovableStrategy());

    @ParameterizedTest
    @CsvSource(value = {"pobi,true", "kim,false"})
    void 이동_테스트(String name, boolean expected) {
        GameStatus gameStatus = new GameStatus(new Names("pobi,kim").splitNamesByComma());
        cars.add(new Car("pobi", 0));
        cars.moveCars(gameStatus);
        cars.add(new Car("kim", 0));
        cars.moveCars(gameStatus);
        cars.moveCars(gameStatus);
        gameStatus.makeWinnerNames();
        //boolean result = cars.get(0).match(position);
        boolean result = gameStatus.makeWinnerNames().contains(name);
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
