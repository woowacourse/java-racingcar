package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarNamesTest {
    @Test
    @DisplayName("이름 리스트 생성 확인")
    void carNames() {
        CarNames carNames = new CarNames("1,2,3");
        assertThat(carNames.getNames().get(0).getName()).isEqualTo("1");
        assertThat(carNames.getNames().get(1).getName()).isEqualTo("2");
        assertThat(carNames.getNames().get(2).getName()).isEqualTo("3");
    }

    @Test
    @DisplayName("이름이 중복되는 경우")
    void carNames_duplicate_exception() {
        assertThatThrownBy(()->new CarNames("1,1,2,3")).isInstanceOf(IllegalArgumentException.class);
    }
}