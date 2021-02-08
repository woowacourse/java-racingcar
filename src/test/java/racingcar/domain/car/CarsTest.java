package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.exception.EmptyCarException;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class CarsTest {
    @Test
    @DisplayName("자동차는 적어도 한대 이상 있어야 한다.")
    public void 자동차는_적어도_한대_이상_있어야_한다() {
        assertThatExceptionOfType(EmptyCarException.class)
                .isThrownBy(() -> Cars.of(Collections.EMPTY_LIST))
                .withMessageContaining(new EmptyCarException().getMessage());
    }

    @ParameterizedTest
    @DisplayName("가장 많이 움직인 자동차를 판별한다")
    @MethodSource("provideInputsFor_가장_많이_움직인_자동차를_판별한다")
    public void 가장_많이_움직인_자동차를_판별한다(List<Car> raceFinishedCars, List<String> expected) {
        Cars cars = Cars.of(raceFinishedCars);
        List<CarName> winners = cars.getWinners();

        assertArrayEquals(expected.toArray(), winners.toArray());
    }

    private static Stream<Arguments> provideInputsFor_가장_많이_움직인_자동차를_판별한다() {
        return Stream.of(
                Arguments.of(createRaceFinishedCars(createCarNameAndPositions1()), Arrays.asList(new CarName("포비"))),
                Arguments.of(createRaceFinishedCars(createCarNameAndPositions2()), Arrays.asList(new CarName("포비"), new CarName("씨유"))),
                Arguments.of(createRaceFinishedCars(createCarNameAndPositions3()), Arrays.asList(new CarName("브라운")))
        );
    }

    private static List<CarNameAndPosition> createCarNameAndPositions1() {
        return new ArrayList<>(
                Arrays.asList(new CarNameAndPosition("포비", 3),
                        new CarNameAndPosition("씨유", 2),
                        new CarNameAndPosition("브라운", 1))
        );
    }

    private static List<CarNameAndPosition> createCarNameAndPositions2() {
        return new ArrayList<>(
                Arrays.asList(new CarNameAndPosition("포비", 4),
                        new CarNameAndPosition("씨유", 4),
                        new CarNameAndPosition("브라운", 1))
        );
    }

    private static List<CarNameAndPosition> createCarNameAndPositions3() {
        return new ArrayList<>(
                Arrays.asList(new CarNameAndPosition("포비", 1),
                        new CarNameAndPosition("씨유", 2),
                        new CarNameAndPosition("브라운", 3))
        );
    }

    private static List<Car> createRaceFinishedCars(List<CarNameAndPosition> carNameAndPositions) {
        List<Car> raceFinishedCars = new ArrayList<>();

        for (CarNameAndPosition carNameAndPosition : carNameAndPositions) {
            Car raceFinishedCar = createRaceFinishedCar(carNameAndPosition);
            raceFinishedCars.add(raceFinishedCar);
        }

        return raceFinishedCars;
    }

    private static Car createRaceFinishedCar(CarNameAndPosition carNameAndPosition) {
        Car car = new Car(carNameAndPosition.name, () -> true);

        for (int i = 0; i < carNameAndPosition.position; i++) {
            car.move();
        }

        return car;
    }

    private static class CarNameAndPosition {
        String name;
        int position;

        public CarNameAndPosition(String name, int position) {
            this.name = name;
            this.position = position;
        }
    }
}