package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.SoftAssertions.*;

public class CarsTest{

    @Test
    void 자동차_우승_1명_성공() {
        Cars cars = new Cars(new String[]{"jae","rick"});

        moveForward(cars.getCars(), 1);

        assertSoftly(softAssertions -> {
            List<String> winners = cars.findWinners();
            softAssertions.assertThat(winners).contains("rick");
            softAssertions.assertThat(winners.size()).isEqualTo(1);
        });
    }

    @Test
    void 자동차_우승_2명_성공() {
        Cars cars = new Cars(new String[]{"jae", "rick"});

        List<Car> carList = cars.getCars();
        moveForward(carList, 0);
        moveForward(carList, 1);

        assertSoftly(softAssertions -> {
            List<String> winners = cars.findWinners();
            softAssertions.assertThat(winners).contains("rick");
            softAssertions.assertThat(winners).contains("jae");
            softAssertions.assertThat(winners.size()).isEqualTo(2);
        });
    }

    private void moveForward(List<Car> cars, int i) {
        cars.get(i).goForward(4);
    }
}