package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerCarsTest {
    private ArrayList<Car> carList = new ArrayList<>();
    private ArrayList<Car> answerList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        carList.add(new Car("pobi"));
        carList.add(new Car("crong"));
        carList.add(new Car("abc"));
        carList.add(new Car("def"));

        carList.get(0).move(3);
        carList.get(1).move(5);
        carList.get(2).move(5);
        carList.get(2).move(5);
        carList.get(3).move(5);
        carList.get(3).move(5);

        answerList.add(new Car("abc"));
        answerList.add(new Car("def"));

        answerList.get(0).move(5);
        answerList.get(0).move(5);
        answerList.get(1).move(5);
        answerList.get(1).move(5);
    }

    @Test
    void 우승자확인() {
        WinnerCars winnerCars = new WinnerCars();
        ArrayList<Car> winnerList = winnerCars.determineWinners(carList);

        for (int i = 0; i < answerList.size(); i++) {
            assertThat(winnerList.get(i).getName()).isEqualTo(answerList.get(i).getName());
        }

    }
}
