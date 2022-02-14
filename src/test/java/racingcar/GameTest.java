package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

    List<Car> cars;
    @BeforeEach
    void setup() {
        List<Car> cars =
    }



    @Test
    void findWinnerByPosition_위너_찾기() {
        //given
        int maxPosition = 5;

    }

    private List<String> findWinnerByPosition(int maxPosition, List<Car> cars) {
        return cars.stream()
            .filter(car -> car.isSamePosition(maxPosition))
            .map(Car::getName)
            .collect(Collectors.toList());
    }

}
