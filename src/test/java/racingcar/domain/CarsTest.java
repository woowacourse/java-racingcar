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
import racingcar.util.RandomUtils;

@DisplayName("자동차들")
class CarsTest {
    @Test
    @DisplayName("생성에 성공한다.")
    public void createCarsTest() {
        //given
        String name = "choco";
        List<String> carName = List.of(name);

        //when
        Cars cars = Cars.from(carName);
        List<Car> carList = cars.getCars();

        //then
        assertEquals(carList.get(0).getName(), name);
    }

    @Test
    @DisplayName("생성된 자동차들 중 변경 시, 예외가 발생한다.")
    public void changeListCarTest() {
        //given
        List<String> userInput = List.of("choco");
        List<String> addInput = List.of("seyan");

        //when
        Cars cars = Cars.from(userInput);
        Cars addCars = Cars.from(addInput);

        List<Car> carList = cars.getCars();
        Car toAddCar = addCars.getCars().get(0);

        //then
        assertThrows(UnsupportedOperationException.class, () -> carList.add(toAddCar));
    }

    @Test
    @DisplayName("중복된 자동차 이름이 있을 경우 예외가 발생한다.")
    public void verifyNonDuplicateCarNames() {
        //given
        List<String> userInput = List.of("choco", "seyan", "choco");

        //when & then
        assertThrows(IllegalArgumentException.class, () -> Cars.from(userInput));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "    "})
    @DisplayName("사용자 입력이 빈칸이면, 예외가 발생한다.")
    public void verifyBlankUserInput(String userInput) {
        //given
        List<String> carName = List.of(userInput);
        //when & then
        assertThrows(IllegalArgumentException.class, () -> Cars.from(carName));
    }

    @Test
    @DisplayName("랜덤값이 4보다 작으면 움직이지 않는다")
    public void carsNotMoveTest() {
        //given
        List<String> carNames = List.of("choco", "seyan", "solar");
        Cars cars = Cars.from(carNames);
        int initialDistance = 0;

        final CarMoveStrategy carMoveStrategy = new CarMoveStrategy() {
            @Override
            public boolean isMovable(int value) {
                return false;
            }
        };

        final RandomUtils randomUtil = new RandomUtils() {
            @Override
            public int generate(int minLimit, int maxLimit) {
                return 1;
            }
        };

        //when
        cars.move(carMoveStrategy, randomUtil);
        List<Car> carList = cars.getCars();

        //then
        assertAll(
                () -> assertEquals(carList.get(0).getDistance(), initialDistance),
                () -> assertEquals(carList.get(1).getDistance(), initialDistance),
                () -> assertEquals(carList.get(2).getDistance(), initialDistance)
        );
    }

    @Test
    @DisplayName("랜덤값이 4보다 큰 경우 자동차가 움직인다")
    public void carsMoveTestIterator() {
        //given
        List<String> carNames = List.of("choco", "seyan", "solar");
        Cars cars = Cars.from(carNames);
        int iteratorCounts = 3;
        int distanceResult = 3;

        final CarMoveStrategy carMoveStrategy = new CarMoveStrategy() {
            @Override
            public boolean isMovable(int value) {
                return true;
            }
        };

        final RandomUtils randomUtil = new RandomUtils() {
            @Override
            public int generate(int minLimit, int maxLimit) {
                return 5;
            }
        };

        //when
        IntStream.range(0, iteratorCounts).forEach(i -> cars.move(carMoveStrategy, randomUtil));

        //then
        assertEquals(cars.getCars().get(0).getDistance(), distanceResult);
    }
}