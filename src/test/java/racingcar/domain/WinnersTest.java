package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @Test
    @DisplayName("가장 많이 이동한 자동차들을 반환한다.")
    void test_1() {
        // given
        Cars cars = new Cars("채채,말랑,시카");
        List<Car> carList = cars.getCars();
        carList.get(0).tryMove(3);
        carList.get(1).tryMove(4);
        carList.get(2).tryMove(4);

        //when
        Winners winners = new Winners(carList);

        // then
        assertThat(winners.getWinners()).containsExactlyInAnyOrder(carList.get(1), carList.get(2));
    }

    //getWinPosition
    @Test
    @DisplayName("getWinPosition()시 우승차의 위치를 반환한다.")
    void test_2() {
        // given
        Cars cars = new Cars("채채,말랑,시카");
        List<Car> carList = cars.getCars();
        carList.get(0).tryMove(3);
        carList.get(1).tryMove(4);
        carList.get(2).tryMove(4);

        //when
        Winners winners = new Winners(carList);
        int winPosition = winners.getWinPosition(carList);

        // then
        assertThat(winPosition).isEqualTo(1);
    }
}
