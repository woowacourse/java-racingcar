package racingcar.domain;

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

}