package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자동차들")
class VehiclesTest {
    @Test
    @DisplayName("중복된 자동차 이름이 있을 경우 예외가 발생한다.")
    public void verifyNonDuplicateCarNames() {
        //given
        String userInput = "choco,seyan,choco";

        //when & then
        assertThrows(IllegalArgumentException.class, () -> Vehicles.from(userInput));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "    "})
    @DisplayName("사용자 입력이 빈칸이면, 예외가 발생한다.")
    public void verifyBlankUserInput(String userInput) {
        //given&when & then
        assertThrows(IllegalArgumentException.class, () -> Vehicles.from(userInput));
    }

    @Test
    @DisplayName("모든 랜덤값이 4보다 작으면, 움직이지 않는다.")
    public void vehicleNotMoveTest() {
        //given
        String userInput = "choco, seyan, solar";
        Vehicles vehicles = Vehicles.from(userInput);
        int initialDistance = 0;

        final CarMoveStrategy carMoveStrategy = new CarMoveStrategy() {
            @Override
            public boolean isMovable() {
                return false;
            }
        };

        //when
        vehicles.move(carMoveStrategy);
        List<Car> cars = vehicles.getCars();

        //then
        assertAll(
                () -> assertEquals(cars.get(0).getForward(), initialDistance),
                () -> assertEquals(cars.get(1).getForward(), initialDistance),
                () -> assertEquals(cars.get(2).getForward(), initialDistance)
        );
    }

    @Test
    @DisplayName("모든 랜덤값이 4보다 큰 경우, move 횟수만큼 움직인다.")
    public void vehicleMoveTestIterator() {
        //given
        String userInput = "choco, seyan, solar";
        Vehicles vehicles = Vehicles.from(userInput);
        int iteratorCounts = 3;
        int distanceResult = 3;

        final CarMoveStrategy carMoveStrategy = new CarMoveStrategy() {
            @Override
            public boolean isMovable() {
                return true;
            }
        };

        //when
        IntStream.range(0, iteratorCounts).forEach(i -> vehicles.move(carMoveStrategy));

        //then
        assertEquals(vehicles.getCars().get(0).getForward(), distanceResult);
    }
}