package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.ErrorMessage;

class UserInputRequesterTest {

    @DisplayName("getCarName() 테스트")
    @Test
    void getCarName_test() {
        String input = "name1";
        byte[] buf = input.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        UserInputRequester userInputRequester = new UserInputRequester();
        assertThat(userInputRequester.getCarName()).isEqualTo(input);
    }

    @DisplayName("getAttempt() 테스트")
    @Test
    void getAttempt_test() {
        String input = "1";
        byte[] buf = input.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        UserInputRequester userInputRequester = new UserInputRequester();
        assertThat(userInputRequester.getAttempt()).isEqualTo(input);
    }

    @DisplayName("getCarName() 자동차 이름이 공백으로 입력되었을 때 예외 테스트")
    @Test
    void getCarName_Empty_exception_test() {
        String input = "";
        byte[] buf = input.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        UserInputRequester userInputRequester = new UserInputRequester();
        assertThatThrownBy(userInputRequester::getCarName)
                .hasMessageContaining(ErrorMessage.INPUT_EMPTY.getMessage());
    }

    @DisplayName("getAttempt() 시도 회수가 공백으로 입력되었을 때 예외 테스트")
    @Test
    void getAttempt_Empty_exception_test() {
        String input = "";
        byte[] buf = input.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        UserInputRequester userInputRequester = new UserInputRequester();
        assertThatThrownBy(userInputRequester::getAttempt)
                .hasMessageContaining(ErrorMessage.INPUT_EMPTY.getMessage());
    }
}
