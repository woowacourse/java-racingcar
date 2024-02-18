package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("입력")
class InputViewTest {
    @Test
    @DisplayName("구분자로 이름 파싱에 성공한다.")
    public void testCarNameParsing() {
        //given
        String name1 = "choco";
        String name2 = "seyan";
        ByteArrayInputStream in = new ByteArrayInputStream((name1 + "," + name2 + "\n").getBytes());
        System.setIn(in);

        //when
        List<String> carNames = InputView.readCarNames();

        //then
        assertEquals(carNames.get(0), name1);
        assertEquals(carNames.get(1), name2);
    }

    @Test
    @DisplayName("이름 앞뒤 공백 제거에 성공한다.")
    public void testNameTrim() {
        //given
        String name1 = "choco";
        String name2 = "seyan";
        ByteArrayInputStream in = new ByteArrayInputStream((name1 + " , " + name2 + " \n").getBytes());
        System.setIn(in);

        //when
        List<String> carNames = InputView.readCarNames();

        //then
        assertEquals(carNames.get(0), name1);
        assertEquals(carNames.get(1), name2);
    }

    @Test
    @DisplayName("숫자 입력에 성공한다")
    public void testReadTryCountValidInput() {
        //given
        ByteArrayInputStream in = new ByteArrayInputStream("5\n".getBytes());
        System.setIn(in);

        //when
        int tryCount = InputView.readTryCount();

        //then
        assertEquals(5, tryCount);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "1 2", "hi"})
    @DisplayName("숫자가 아닐 경우 예외가 발생한다")
    public void testReadTryCountInvalidInput(final String userInput) {
        //given
        ByteArrayInputStream in = new ByteArrayInputStream((userInput + "\n").getBytes());
        System.setIn(in);

        //when&then
        assertThrows(IllegalArgumentException.class, InputView::readTryCount);
    }
}