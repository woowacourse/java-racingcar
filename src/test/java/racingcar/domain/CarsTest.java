package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    @Test
    @DisplayName("모든 자동차들이 조건에 의해 전진한다.")
    void moveAllCarsTest() {
        //given
        Cars cars = new Cars(List.of("미아", "메이슨"));

        //when
        cars.moveAllCars(new RandomNumberForward());

        //then
        List<Car> movedCars = cars.getCars();
        assertThat(movedCars)
                .extracting(Car::getCount)
                .containsExactly(1, 1);
    }

    @Test
    @DisplayName("모든 자동차들이 조건에 의해 정지한다.")
    void dontMoveAllCarsTest() {
        //given
        Cars cars = new Cars(List.of("미아", "메이슨"));

        //when
        cars.moveAllCars(new RandomNumberStop());

        //then
        List<Car> movedCars = cars.getCars();
        assertThat(movedCars)
                .extracting(Car::getCount)
                .containsExactly(0, 0);
    }

    @Test
    @DisplayName("빈 Cars 리스트가 입력된 경우 테스트")
    void newCarsTest() {
        List<String> carNames = Collections.emptyList();
        final Cars cars = new Cars(carNames);

        assertThatThrownBy(cars::determineWinner)
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    @DisplayName("단일의 우승자가 발생하는 지 확인한다.")
    void determineUniqueWinnerTest() {
        //given
        Cars cars = new Cars(List.of("미아", "메이슨"));
        List<Car> createdCars = cars.getCars();
        createdCars.get(0).move(1);
        createdCars.get(1).move(8);

        //when
        List<Car> winners = cars.determineWinner();

        //then
        assertThat(winners)
                .extracting(Car::getName)
                .isEqualTo(List.of("메이슨"));
    }

    @Test
    @DisplayName("다수의 우승자가 발생하는 지 확인한다.")
    void determineMultipleWinnerTest() {
        //given
        Cars cars = new Cars(List.of("미아", "메이슨", "조조", "감자", "도라"));
        List<Car> createdCars = cars.getCars();
        createdCars.get(0).move(9);
        createdCars.get(1).move(8);
        createdCars.get(2).move(7);
        createdCars.get(3).move(3);
        createdCars.get(4).move(2);

        //when
        List<Car> winners = cars.determineWinner();

        //then
        assertThat(winners)
                .extracting(Car::getName)
                .isEqualTo(List.of("미아", "메이슨", "조조"));
    }
}