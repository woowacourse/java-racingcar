package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.domain.Cars.ERROR_MESSAGE_OF_DUPLICATED_NAME;

class CarsTest {
    @Test
    @DisplayName("이름 리스트 생성 확인")
    void carNames() {
        final Cars cars = new Cars("1,2,3");
        assertThat(cars.toList().get(0).getName()).isEqualTo("1");
        assertThat(cars.toList().get(1).getName()).isEqualTo("2");
        assertThat(cars.toList().get(2).getName()).isEqualTo("3");
    }

    @Test
    @DisplayName("이름이 중복되는 경우")
    void carNames_duplicated() {
        assertThatThrownBy(() -> new Cars("1,1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE_OF_DUPLICATED_NAME);
        assertThatThrownBy(() -> new Cars("1,2,3,2")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Cars("1,,2,3")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Cars("1,,,,2,3")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("양 끝에 쉼표가 있는 경우")
    void carNames_both_end() {
        assertThatThrownBy(() -> new Cars(",샐리")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Cars("샐리,df,")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Cars(",샐리,")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("총합테스트")
    void carNames_comma_blank() {
        assertThatThrownBy(() -> new Cars(",")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Cars(" ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Cars(" , ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Cars(", ,  ,")).isInstanceOf(IllegalArgumentException.class);
    }
}