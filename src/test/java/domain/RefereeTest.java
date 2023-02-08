package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {
    private Cars cars;

    @BeforeEach
    void init() {
        Car carA = new Car("carA");
        Car carB = new Car("carB");

        carA.move(4);
        carA.move(4);

        carB.move(4);
        carB.move(4);
        carB.move(4);

        cars = new Cars(List.of(
                carA,
                carB
        ));
    }

    @DisplayName("우승자가 carB일 때 findByName으로 carB를 찾을 수 있다.")
    @Test
    void judgeWinnerTest1() {
        //given

        //when
        Cars winningCars = Referee.judgeWinner(cars);

        //then
        assertThatThrownBy(() -> winningCars.findByName("carB"))
                .doesNotThrowAnyException();
    }

    @DisplayName("우승자가 carB일 때 findByName으로 carA를 찾을 수 없다.")
    @Test
    void judgeWinnerTest2() {
        //given

        //when
        Cars winningCars = Referee.judgeWinner(cars);

        //then
        assertThatThrownBy(() -> winningCars.findByName("carA"))
                .isInstanceOf(RuntimeException.class);
    }

}