package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.constant.Digit;
import racingcar.utils.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class CarsTest {
    private static Stream<Arguments> initializeDecideMovableCar() {
        int numberOfCars = 4;
        int numberOfMovableCar = 2;

        List<Integer> randoms = Arrays.stream(new int[numberOfCars])
                .boxed()
                .collect(Collectors.toList());
        List<String> carNames = new ArrayList<>();

        for (int i = 0; i < numberOfMovableCar; i++) {
            randoms.set(i, Digit.MOVEMENT_CRITERION.getDigit());
        }
        for (int i = 0; i < numberOfCars; i++) {
            carNames.add("pobi" + i);
        }

        Cars cars = new Cars(carNames);

        return Stream.of(Arguments.of(cars, randoms));
    }

    @DisplayName("이름이 중복되지 않는 경우 객체 생성 성공")
    @Test
    public void createCars_이름이_중복되지_않는_경우() {
        List<String> carNames = Arrays.asList(new String[]{"dani", "pobi", "bear"});

        assertThatCode(() -> new Cars(carNames))
                .doesNotThrowAnyException();
    }

    @DisplayName("이름이 중복되는 경우 예외 발생")
    @Test
    public void createCars_이름이_중복되는_경우() {
        List<String> carNames = Arrays.asList(new String[]{"dani", "pobi", "dani", "bear"});

        assertThatThrownBy(() -> {
            new Cars(carNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("조건을 만족하는 자동차는 전진 성공")
    @ParameterizedTest
    @MethodSource("initializeDecideMovableCar")
    void decideMovableCar_자동차가_전진할지_멈출지_판단(Cars cars, List<Integer> randoms) {
        int movedPosition = 1;
        int numberOfMovableCar = (int) randoms.stream()
                .filter(random -> random.compareTo(Digit.MOVEMENT_CRITERION.getDigit()) >= 0)
                .count();

        cars.decideMovableCar(randoms);

        int movedCount = (int) cars.getCars()
                .stream()
                .filter(car -> car.getPosition() == movedPosition)
                .count();

        assertThat(movedCount).isEqualTo(numberOfMovableCar);
    }

    @DisplayName("자동차가 조건을 만족하면 전진 성공")
    @ParameterizedTest
    @MethodSource("initializeDecideMovableCar")
    void moveIfPossible_자동차가_조건을_만족하면_전진(Cars cars) {
        int random = RandomUtils.nextInt(Digit.MINIMUM_RANDOM_VALUE.getDigit(),
                Digit.MAXIMUM_RANDOM_VALUE.getDigit());
        int expectedPosition = 0;

        Car car = new Car("pobi");

        if (random >= Digit.MOVEMENT_CRITERION.getDigit()) {
            expectedPosition++;
        }

        cars.moveIfPossible(car, random);

        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }


    @DisplayName("최종 우승자 판단 성공")
    @Test
    void getWinnerNames_최종_우승자를_판단() {
        final String winnerName = "dani";

        List<String> carNames = Arrays.asList("dani", "brown", "pobi");
        List<Integer> positions = Arrays.asList(8, 3, 6);

        Cars cars = new Cars(carNames, positions);

        assertThat(cars.giveWinners().get(0)).isEqualTo(winnerName);
    }
}