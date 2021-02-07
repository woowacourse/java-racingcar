package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.Car;
import racingcar.dto.CarDto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OutputViewTest {
    @DisplayName("스틱이 제대로 만들어 지는지 확인")
    @ParameterizedTest
    @CsvSource({"포비,3,---", "웨지,2,--", "삭정,1,-"})
    void makeStick_givenProperCarNameAndPosition_returnStickAccordingToTheValueOfPosition(String name, int position, String stick) {
        CarDto car = new CarDto(new Car(name));
        car.setPosition(position);
        assertThat(OutputView.makeStick(car)).isEqualTo(stick);
    }
}