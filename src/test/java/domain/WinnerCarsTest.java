package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerCarsTest {
    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<Car> answers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        cars.add(new Car("pobi"));
        cars.add(new Car("crong"));
        cars.add(new Car("abc"));
        cars.add(new Car("def"));

        cars.get(0).move(3);
        cars.get(1).move(4);
        cars.get(2).move(4);
        cars.get(2).move(4);
        cars.get(3).move(4);
        cars.get(3).move(4);

        answers.add(new Car("abc"));
        answers.add(new Car("def"));

        answers.get(0).move(4);
        answers.get(0).move(4);
        answers.get(1).move(4);
        answers.get(1).move(4);
    }

    @Test
    void 우승자_확인() {
        WinnerCars winnerCars = new WinnerCars();
        ArrayList<Car> winnerList = winnerCars.determineWinners(cars);

        for (int i = 0; i < answers.size(); i++) {
            assertThat(winnerList.get(i)).isEqualTo(answers.get(i));
        }

    }
}
