package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("이름 리스트 생성 확인")
    void cars_create() {
        Cars cars = Cars.enrollCarsWithNames("1,2,3");
        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("null 혹은 공백 입력 테스트")
    void cars_null_or_blank_exception() {
        assertThatThrownBy(() -> Cars.enrollCarsWithNames(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Cars.enrollCarsWithNames(" ")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 중복되는 경우")
    void cars_duplicate_exception() {
        assertThatThrownBy(() -> Cars.enrollCarsWithNames("1,,2,3")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Cars.enrollCarsWithNames("1,,,,2,3")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("양 끝에 쉼표가 있는 경우")
    void cars_양_끝_예외처리() {
        assertThatThrownBy(() -> Cars.enrollCarsWithNames(",샐리")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Cars.enrollCarsWithNames("샐리,df,")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Cars.enrollCarsWithNames(",샐리,")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("예외처리 총합테스트")
    void cars_연속된_쉼표_예외처리() {
        assertThatThrownBy(() -> Cars.enrollCarsWithNames(",")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Cars.enrollCarsWithNames(" ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Cars.enrollCarsWithNames(" , ")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Cars.enrollCarsWithNames(", ,  ,")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("우승자 생성 확인")
    void winners_make() {
        AssertionsForClassTypes.assertThat(
            Cars.enrollCarsWithNames("1,2,3").findWinners().size())
            .isEqualTo(3);
    }
}