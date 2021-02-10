package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.exception.DuplicateNameException;
import racingcar.utils.exception.NotEnoughCarException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    @Test
    public void Cars_객체_생성_테스트() {
        Cars cars = new Cars(new String[]{"포비", "제이슨"});
        assertThat(cars.carList().size()).isEqualTo(2);
    }

    @DisplayName("이름이 중복되는 경우 예외처리")
    @Test
    public void duplicateCarsCreate() {
        String[] duplicateInput = {"pobi", "brown", "pobi"};
        assertThatThrownBy(() -> new Cars(duplicateInput))
                .isInstanceOf(DuplicateNameException.class);
    }

    @DisplayName("자동차가 1대인 경우 예외처리")
    @Test
    public void notEnoughCarsCreate() {
        String[] input = {"pobi"};
        assertThatThrownBy(() -> new Cars(input))
                .isInstanceOf(NotEnoughCarException.class);
    }
}