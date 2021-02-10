package view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.Car;
import racingCar.Cars;
import racingCar.Name;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private List<Car> testCars;

    @BeforeEach
    public void setUp() {
        testCars = new ArrayList<>();
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        testCars.add(car1);
        testCars.add(car2);
        testCars.add(car3);

        car1.move(4);
        car2.move(4);
        car3.move(0);
    }

    @Test
    @DisplayName(" '-' 생성 확인 테스트")
    public void barTest() {
        String bars = OutputView.bar(3);

        assertThat(bars.length()).isEqualTo(3);
    }

    @Test
    @DisplayName("게임 승리자 반환 테스트")
    public void winnerTest() {
        Cars cars = new Cars(testCars);

        List<Name> winners = OutputView.getWinners(1, cars);

        assertThat(winners).isEqualTo(Arrays.asList(new Name("car1"), new Name("car2")));
    }

}