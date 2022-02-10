package racingcar.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * - [ ] [ 예외 ] : `공백` - *(입력받은 문자열의 앞 뒤를 제거해준다.)*
 * - [ ] [ 예외 ] : 자동차가 `2대 미만`
 * - [ ] [ 예외 ] : 이름이 `중복`
 * - [ ] [ 예외 ] : `5글자 초과`
 */
class InputTest {
    @Test
    void 자동차_이름_공백_테스트() {
        String inputValue = "";
        validateName(inputValue);
    }

    @Test
    void 자동차_개수_테스트() {
        String names = "pobi";
        validateName(names);
    }

    @Test
    void 자동차_이름_중복_테스트() {
        String names = "pobi,pobi";
        validateName(names);
    }

    @Test
    void 자동차_이름_길이_테스트() {
        String names = "good";
        validateName(names);
    }

    void validateName(String names) {
        assertThatThrownBy(() -> {
            Input.carName(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}