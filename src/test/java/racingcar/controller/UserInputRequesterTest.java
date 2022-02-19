package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.ErrorMessage;

public class UserInputRequesterTest {

    @DisplayName("getCarName() 테스트")
    @ParameterizedTest()
    @ValueSource(strings = {"name1,name2", "name1"})
    public void getCarName_test(String inputNames) throws Exception {
        String input = inputNames;
        byte[] buf = input.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        UserInputRequester userInputRequester = new UserInputRequester();
        assertThat(userInputRequester.getCarName()).isEqualTo(inputNames);
    }

    @DisplayName("getAttempt() 테스트")
    @ParameterizedTest()
    @ValueSource(strings = {"100", "1"})
    public void getAttempt_test(String inputAttempt) throws Exception {
        String input = inputAttempt;
        byte[] buf = input.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        UserInputRequester userInputRequester = new UserInputRequester();
        assertThat(userInputRequester.getAttempt()).isEqualTo(inputAttempt);
    }

    @DisplayName("getCarName() 자동차 이름이 공백으로 입력되었을 때 예외 테스트")
    @Test
    public void getCarName_Empty_exception_test() throws Exception {
        String input = "";
        byte[] buf = input.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        UserInputRequester userInputRequester = new UserInputRequester();
        assertThatThrownBy(() -> userInputRequester.getCarName())
                .hasMessageContaining(ErrorMessage.INPUT_EMPTY.getMessage());
    }

    @DisplayName("getAttempt() 시도 회수가 공백으로 입력되었을 때 예외 테스트")
    @Test
    public void getAttempt_Empty_exception_test() throws Exception {
        String input = "";
        byte[] buf = input.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        UserInputRequester userInputRequester = new UserInputRequester();
        assertThatThrownBy(() -> userInputRequester.getAttempt())
                .hasMessageContaining(ErrorMessage.INPUT_EMPTY.getMessage());
    }
}
