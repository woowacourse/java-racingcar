package view;

import model.Car;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InputViewTest {
    @Test
    void 자동차이름_형식검사() {
        assertThrows(IllegalArgumentException.class,()->{
           InputView.checkFormCarNames("abcd,");
        });
        assertThrows(IllegalArgumentException.class,()->{
            InputView.checkFormCarNames(" ");
        });
        assertThrows(IllegalArgumentException.class,()->{
            InputView.checkFormCarNames(",asd,asd");
        });
        assertThrows(IllegalArgumentException.class,()->{
            InputView.checkFormCarNames("asd, asd");
        });
        assertThrows(IllegalArgumentException.class,()->{
            InputView.checkFormCarNames("asd,asd ");
        });
    }

    @Test
    void 자동차이름_중복검사() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("aaa"));
        cars.add(new Car("bbb"));
        cars.add(new Car("bbb"));

        Car car = new Car("bbb");

        assertThrows(IllegalArgumentException.class,()->{
           InputView.checkCarNamesDuplication(cars, car);
        });
    }

    @Test
    void 시도횟수_범위검사() {
        assertThrows(IllegalArgumentException.class,()->{
           InputView.checkArrangeLapCount(0);
        });
        assertThrows(IllegalArgumentException.class,()->{
            InputView.checkArrangeLapCount(-1);
        });
    }
}