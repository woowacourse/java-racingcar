package racingcar.ui;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("출력 문구")
class OutputCommandTest {
    @Test
    @DisplayName("정확성을 검증한다.")
    public void testOutputCommands() {
        //given
        String requestCarNames = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
        String requestTryCount = "시도할 회수는 몇회인가요?";
        String inputErrorMessage = "입력 중 오류가 발생했습니다.";
        String resultTile = "실행 결과";
        String winnerDelimiter = ", ";
        String errorPrefix = "[ERROR] ";

        //when & then
        assertAll(
                () -> assertEquals(requestCarNames, OutputCommand.ASK_CAR_NAMES),
                () -> assertEquals(requestTryCount, OutputCommand.ASK_TRY_COUNT),
                () -> assertEquals(errorPrefix, OutputCommand.ERROR_PREFIX),
                () -> assertEquals(resultTile, OutputCommand.RESULT_TITLE),
                () -> assertEquals(winnerDelimiter, OutputCommand.WINNERS_DELIMITER),
                () -> assertEquals(inputErrorMessage, OutputCommand.INPUT_ERROR_MESSAGE)
        );
    }
}