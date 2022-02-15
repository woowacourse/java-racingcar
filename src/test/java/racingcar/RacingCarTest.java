package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.ErrorMessage;

public class RacingCarTest {

    @DisplayName("play() 입력 값에 중간에 공백이 있는 경우 예외 테스트")
    @Test
    public void play_middle_empty_test() throws Exception {
        String[] input = {"name1,,name3", "5"};
        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        Scanner scanner = new Scanner(System.in);
        RacingCar racingCar = new RacingCar();
        assertThatThrownBy(() -> racingCar.play(scanner))
                .hasMessageContaining(ErrorMessage.CAR_NAME_EMPTY.toString());
    }

    @DisplayName("play() 입력 값에 처음에 공백이 있는 경우 예외 테스트")
    @Test
    public void play_first_empty_test() throws Exception {
        String[] input = {",name1", "5"};
        byte[] buf = String.join("\n", input).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        Scanner scanner = new Scanner(System.in);
        RacingCar racingCar = new RacingCar();
        assertThatThrownBy(() -> racingCar.play(scanner))
                .hasMessageContaining(ErrorMessage.CAR_NAME_EMPTY.toString());
    }
}
