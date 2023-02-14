package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import validation.ErrorMessage;

import static org.assertj.core.api.Assertions.*;

class CarNameTest {

    @ParameterizedTest
    @CsvSource(value = {"gray:gray", " hoi:hoi", "a2 :a2", " jason :jason"}, delimiter = ':')
    @DisplayName("자동차 이름에서 공백은 모두 제거하여 이름으로 설정한다.")
    public void removeSpaceInCarName(String inputName, String expectedName) {
        CarName carName = new CarName(inputName);

        assertThat(carName.getName()).isEqualTo(expectedName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"gray1234", "hoi1234", "", " "})
    @DisplayName("1 ~ 5 크기의 이름이 아닌 경우 예외가 발생한다.")
    public void carNameCreateFail(String name) {
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.WRONG_CAR_NAME.getMessage());
    }
}
