package racingcar.domain;

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDto;
import racingcar.util.DeterminedIntGenerator;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("전체 자동차 이동 요청")
    void shouldTryMoveEachCarWhenRequest() {
        // given
        List<String> names = List.of("phobi", "tele", "chan");
        Cars cars = new Cars(names, new DeterminedIntGenerator(4));
        List<CarDto> carDtosBeforeRequestMove = cars.getStatuses();
        // when
        cars.repeatRequestMoveBy(1);
        List<CarDto> carDtosAfterRequestMove = cars.getStatuses();
        // then
        for (int index = 0; index < carDtosAfterRequestMove.size(); index++) {
            assertThat(carDtosAfterRequestMove.get(index).getName()).isEqualTo(
                    carDtosBeforeRequestMove.get(index).getName()).as("이름은 같아야 한다.");
            assertThat(carDtosAfterRequestMove.get(index).getMovedCount()).isEqualTo(
                    carDtosBeforeRequestMove.get(index).getMovedCount() + 1).as("이동 횟수는 1이 더해진다.");
        }
    }

    @Test
    @DisplayName("우승자 정보 반환")
    void shouldReturnWinnerDataWhenRequest() {
        // given
        Car winnerCar = new Car("1th", new DeterminedIntGenerator(5));
        Car loserCar = new Car("2nd", new DeterminedIntGenerator(3));
        List<Car> carsInput = List.of(winnerCar, loserCar);
        Cars cars = new Cars(carsInput, true);
        // when
        cars.repeatRequestMoveBy(1);
        List<CarDto> winners = cars.getWinner();
        // then
        assertThat(winners.get(0).getName()).isEqualTo("1th").as("우승자 이름과 같아야 한다.");
        assertThat(winners.size()).isEqualTo(1).as("우승자는 1명이어야 한다.");
    }


    @Test
    @DisplayName("예외 발생 - 잘못된 시도 횟수 입력")
    void shouldReturnIllegalArgumentExceptionWhenWrongTryCount() { // TODO: BeforeEach 사용하기
        // given
        Car winnerCar = new Car("1th", new DeterminedIntGenerator(5));
        Car loserCar = new Car("2nd", new DeterminedIntGenerator(3));
        List<Car> carsInput = List.of(winnerCar, loserCar);
        Cars cars = new Cars(carsInput, true);
        // when
        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    cars.repeatRequestMoveBy(-1);
                }); }

}