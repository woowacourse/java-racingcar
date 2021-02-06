package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("이름 리스트 생성 확인")
    void carNames() {
        Cars cars = new Cars("1,2,3");
        assertThat(cars.getCars().get(0).getName()).isEqualTo("1");
        assertThat(cars.getCars().get(1).getName()).isEqualTo("2");
        assertThat(cars.getCars().get(2).getName()).isEqualTo("3");
    }

    @Test
    @DisplayName("null 혹은 공백 입력 테스트")
    void carNames_null_or_blank_exception() {
        assertThatThrownBy(() -> new Cars(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Cars(" ")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 중복되는 경우")
    void carNames_duplicate_exception() {
        assertThatThrownBy(() -> new Cars("1,,2,3")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Cars("1,,,,2,3")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("양 끝에 쉼표가 있는 경우")
    void carNames_양_끝_예외처리() {
        assertThatThrownBy(() -> new Cars(",샐리")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Cars("샐리,df,")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Cars(",샐리,")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("총합테스트")
    void carNames_연속된_쉼표_예외처리() {
        assertThatThrownBy(() -> new Cars(",")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Cars(" ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Cars(" , ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Cars(", ,  ,")).isInstanceOf(IllegalArgumentException.class);
    }
}