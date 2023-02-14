package racingcar.domain;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDto;
import util.DeterminedIntGenerator;
import racingcar.util.IntGenerator;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    List<String> names;

    @BeforeEach
    void setUp() {
        names = List.of("phobi", "tele", "chan");
    }

    @Test
    @DisplayName("전체 자동차 이동 요청")
    void shouldTryMoveEachCarWhenRequest() {
        // given
        List<IntGenerator> intGenerators = List.of(new DeterminedIntGenerator(4), new DeterminedIntGenerator(4),
                new DeterminedIntGenerator(4));
        Cars cars = new Cars(names, intGenerators);
        List<CarDto> carDtosBeforeRequestMove = cars.getStatuses();
        // when
        cars.requestMoveEachCar();
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
        List<String> names = List.of("1th", "tele", "chan");
        List<IntGenerator> intGenerators = List.of(new DeterminedIntGenerator(4), new DeterminedIntGenerator(3),
                new DeterminedIntGenerator(3));
        Cars cars = new Cars(names, intGenerators);
        // when
        cars.requestMoveEachCar();
        List<CarDto> winners = cars.getWinner();
        // then
        assertThat(winners.get(0).getName()).isEqualTo("1th").as("우승자 이름과 같아야 한다.");
        assertThat(winners.size()).isEqualTo(1).as("우승자는 1명이어야 한다.");
    }

}
