package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandLineTest {

    CommandLine command ;

    @Test
    void 입력값을_배열로_변환_확인() {
        String inputText = "1 + 2 * 3";
        command = new CommandLine(inputText);
        String[] result = command.getCommand();
        String[] arr = {"1", "+", "2", "*", "3"};
        assertThat(result).isEqualTo(arr);
    }
}
