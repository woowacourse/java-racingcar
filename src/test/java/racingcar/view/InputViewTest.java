package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.TestUtil.setInput;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

class InputViewTest {

    InputView inputView = new InputView();

    @AfterEach
    void closeInput() {
        Console.close();
    }


    @DisplayName("자동차 이름을 입력한다.")
    @Test
    void inputCarNames() {
        // given
        setInput("자동차1,자동차2,자동차3");
        List<Car> expected = List.of(new Car("자동차1"), new Car("자동차2"), new Car("자동차3"));

        // when
        Cars cars = inputView.askCarNames();

        // then
        assertThat(cars.stream().toList()).isEqualTo(expected);
    }


}