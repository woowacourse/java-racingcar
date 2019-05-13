package controller;

import domain.Car;
import domain.CarsFactory;
import domain.Race;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.InputView;
import view.OutputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingControllerTest {
    private String carNamesInput = "pobi,crong,hee,iba";
    private List<String> carNames;

    @BeforeEach
    void setUp() {
        carNames = Arrays.asList(carNamesInput.split(","));
    }

    @Test
    void Car_리스트_만들기() {
        InputStream in = new ByteArrayInputStream(carNamesInput.getBytes());
        System.setIn(in);

        List<Car> cars = new CarsFactory(InputView.inputCarNames()).createCars();
        for (int i = 0; i < carNames.size(); i++) {
            assertThat(cars).isEqualTo(new CarsFactory(carNames).createCars());
        }
    }

    @Test
    void 횟수_입력_확인() {
        String rountCount = "5";
        InputStream in = new ByteArrayInputStream(rountCount.getBytes());
        System.setIn(in);

        assertThat(RacingController.setRoundCount()).isEqualTo(5);
    }

    @Test
    void 횟수_1이상_숫자이외_예외처리_확인() {
        String roundCountEx = "0";
        InputStream in = new ByteArrayInputStream(roundCountEx.getBytes());
        System.setIn(in);

        assertThrows(StackOverflowError.class, () -> {
            RacingController.setRoundCount();
        });
    }

    @Test
    void 횟수_숫자_이외_문자_예외처리_확인() {
        String roundCountEx = "asdf";
        InputStream in = new ByteArrayInputStream(roundCountEx.getBytes());
        System.setIn(in);

        assertThrows(StackOverflowError.class, () -> {
            RacingController.setRoundCount();
        });
    }

    @Test
    void 횟수_정수_이외_예외처리_확인() {
        String roundCountEx = "1.2";
        InputStream in = new ByteArrayInputStream(roundCountEx.getBytes());
        System.setIn(in);

        assertThrows(StackOverflowError.class, () -> {
            RacingController.setRoundCount();
        });
    }

    @AfterEach
    void tearDown() {
        carNames = null;
    }
}