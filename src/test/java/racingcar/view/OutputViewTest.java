package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.dto.CarResponseDto;
import racingcar.dto.CarsResponseDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OutputViewTest {
    @DisplayName("스틱이 제대로 만들어 지는지 확인")
    @Test
    void makeStick_스틱_생성_제대로_되는지() {

        CarsResponseDto carsResponseDto = new CarsResponseDto();
        CarResponseDto car1 = new CarResponseDto("포비", 3);
        CarResponseDto car2 = new CarResponseDto("웨지", 2);
        CarResponseDto car3 = new CarResponseDto("삭정", 1);

        List<CarResponseDto> dtoList = Arrays.asList(car1, car2, car3);
        List<String> sticks = Arrays.asList("---","--","-");

        for (int i = 0; i < dtoList.size(); i++) {
            assertThat(OutputView.makeStick(dtoList.get(i))).isEqualTo(sticks.get(i));
        }
    }
}