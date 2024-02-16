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
    @DisplayName("생성에 성공한다.")
    public void createVehiclesTest() {
        //given
        String userInput = "choco";
        String name = "choco";

        //when
        Vehicles vehicles = Vehicles.from(userInput);
        List<Car> cars = vehicles.getCars();

        //then
        assertEquals(cars.get(0).getName(), name);
    }

    @Test
    @DisplayName("생성된 자동차들 중 변경 시, 예외가 발생한다.")
    public void changeListCarTest() {
        //given
        String userInput = "choco";
        String addInput = "seyan";

        //when
        Vehicles vehicles = Vehicles.from(userInput);
        Vehicles addVehicles = Vehicles.from(addInput);

        List<Car> cars = vehicles.getCars();
        Car toAddCar = addVehicles.getCars().get(0);

        //then
        assertThrows(UnsupportedOperationException.class, () -> cars.add(toAddCar));
    }

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
        int power = 1;

        final CarMoveStrategy carMoveStrategy = new CarMoveStrategy() {
            @Override
            public boolean isMovable(int value) {
                return false;
            }
        };

        //when
        vehicles.move(carMoveStrategy, power);
        List<Car> cars = vehicles.getCars();

        //then
        assertAll(
                () -> assertEquals(cars.get(0).getDistance(), initialDistance),
                () -> assertEquals(cars.get(1).getDistance(), initialDistance),
                () -> assertEquals(cars.get(2).getDistance(), initialDistance)
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
        int power = 4;

        final CarMoveStrategy carMoveStrategy = new CarMoveStrategy() {
            @Override
            public boolean isMovable(int value) {
                return true;
            }
        };

        //when
        IntStream.range(0, iteratorCounts).forEach(i -> vehicles.move(carMoveStrategy, power));

        //then
        assertEquals(vehicles.getCars().get(0).getDistance(), distanceResult);
    }
}