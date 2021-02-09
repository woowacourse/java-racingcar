package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarNameTest {

    @DisplayName("CarName 생성자 테스트")
    @Test
    void testCreate() {
        //given
        CarName carName = new CarName("test");

        //when //then
        assertThat(carName.toStringName()).isEqualTo(new CarName("test").toStringName());
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