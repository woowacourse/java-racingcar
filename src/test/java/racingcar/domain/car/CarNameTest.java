package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarNameTest {

    @DisplayName("CarName 생성자 테스트")
    @Test
    void testCreate() {
        //given
        CarName carName = new CarName("test");

        //when //then
        assertThat(carName).isEqualTo(new CarName("test"));
    }

    @DisplayName("CarName 유효성 판별 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"test123", "", "+"})
    void testNameValidate(String name) {
        //given //when //then
        assertThatIllegalArgumentException().isThrownBy(() -> new CarName(name));
    }

    @DisplayName("toStringName 메서드 테스트")
    @Test
    void testToStringName() {
        //given
        CarName carName = new CarName("test");

        //when //then
        assertThat(carName.toStringName()).isEqualTo("test");
    }
}