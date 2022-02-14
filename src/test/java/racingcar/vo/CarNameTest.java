package racingcar.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameTest {

    @DisplayName("new CarName() 테스트")
    @Test
    public void 생성자_test() throws Exception {
        String carName = "name1";
        CarName name = new CarName(carName);
        assertThat(name.getName()).isEqualTo(carName);
    }

    @DisplayName("new CarName() 공백이 입력되었을 때 예외 테스트")
    @Test
    public void 생성자_공백_test() throws Exception {
        String carName = "";
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("new CarName() 글자 수 초과 값이 입력되었을 때 예외 테스트")
    @Test
    public void 생성자_6자리_입력_test() throws Exception {
        String carName = "abcdef";
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(RuntimeException.class);
    }
}
