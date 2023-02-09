package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarsTest {

    Cars cars;

    @BeforeEach
    void init() {
        Car carA = new Car("carA");
        Car carB = new Car("carB");
        Car carC = new Car("carC");

        carA.move(4);
        carA.move(4);

        carB.move(4);
        carB.move(4);
        carB.move(4);

        carC.move(4);
        carC.move(4);
        carC.move(4);

        cars = new Cars(List.of(
                carA,
                carB,
                carC
        ));
    }

    @Test
    void findByNameTest1() {
        //given

        //when
        String carName = "carA";
        Car findedCar = cars.findByName(carName);

        //then
        assertThat(findedCar.getName()).isEqualTo(carName);
    }

    @Test
    void findByNameTest2() {
        //given

        //when
        String carName = "carD";

        //then
        assertThatThrownBy(() -> cars.findByName(carName))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("우승자가 carB, carC일 때 findByName으로 carB, carC를 찾을 수 있다.")
    @ParameterizedTest
    @CsvSource({"carB", "carC"})
    void judgeWinnerTest1(String name) {
        //given

        //when
        Cars winningCars = cars.judgeWinner();

        //then
        assertThatCode(() -> winningCars.findByName(name))
                .doesNotThrowAnyException();
    }

    @DisplayName("우승자가 carB, carC일 때 findByName으로 carA를 찾을 수 없다.")
    @Test
    void judgeWinnerTest2() {
        //given

        //when
        Cars winningCars = cars.judgeWinner();

        //then
        assertThatThrownBy(() -> winningCars.findByName("carA"))
                .isInstanceOf(RuntimeException.class);
    }
}