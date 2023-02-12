package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
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
        List<CarDto> carDtosBeforeRequestMove = cars.getCars().stream().
                map(CarDto::new)
                .collect(Collectors.toList());
        // when
        cars.requestMoveEachCar();
        List<CarDto> carDtosAfterRequestMove = cars.getCars().stream().
                map(CarDto::new)
                .collect(Collectors.toList());;
        // then
        for (int index = 0; index < carDtosAfterRequestMove.size(); index++) {
            assertThat(carDtosAfterRequestMove.get(index).getName()).isEqualTo(
                    carDtosBeforeRequestMove.get(index).getName());
            assertThat(carDtosAfterRequestMove.get(index).getMovedCount()).isEqualTo(
                    carDtosBeforeRequestMove.get(index).getMovedCount() + 1);
        }
    }

    @Test
    @DisplayName("우승자 정보 반환 - 1명의 우승자")
    void shouldReturnWinnerDataWhenRequest() {
        // given
        Car winnerCar = new Car("1th", new DeterminedIntGenerator(5));
        Car loserCar = new Car("2nd", new DeterminedIntGenerator(3));
        List<Car> carsInput = List.of(winnerCar, loserCar);
        Cars cars = new Cars(carsInput, true);
        // when
        cars.requestMoveEachCar();
        List<CarDto> winners = cars.getWinner();
        // then
        assertThat(winners.get(0).getName()).isEqualTo("1th").as("우승자 이름과 같아야 한다.");
        assertThat(winners.size()).isEqualTo(1).as("우승자는 1명이어야 한다.");
    }

    @Test
    @DisplayName("우승자 정보 반환 - 2명의 우승자")
    void shouldReturnTwoWinnerDataWhenRequest() {
        // given
        Car winnerCar1 = new Car("1th-1", new DeterminedIntGenerator(5));
        Car winnerCar2 = new Car("1th-2", new DeterminedIntGenerator(6));
        Car loserCar = new Car("2nd", new DeterminedIntGenerator(3));
        List<Car> carsInput = List.of(winnerCar1, winnerCar2, loserCar);
        Cars cars = new Cars(carsInput, true);
        // when
        cars.requestMoveEachCar();
        List<CarDto> winners = cars.getWinner();
        // then
        assertThat(winners.size()).isEqualTo(2);
    }

}