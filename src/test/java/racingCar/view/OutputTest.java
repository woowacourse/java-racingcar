package racingCar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingCar.domain.CarDto;
import racingCar.domain.Cars;

@SuppressWarnings("NonAsciiCharacters")
public class OutputTest {
    @Test
    void 시작메세지_검사() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //when
        OutputView.printStartMessage();

        //then
        assertThat(out.toString())
                .isEqualTo("\n실행 결과\n");
    }

    @Test
    void 실행결과출력_검사() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //when
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        result.put("jiwoo",2);
        result.put("juri",0);

        OutputView.printRoundResult(result);

        //then
        assertThat(out.toString())
                .isEqualTo("jiwoo : --\njuri : \n" + System.lineSeparator());
    }

    @Test
    void 위너출력_검사_1명() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //when
        OutputView.printWinner(List.of("hunch"));

        //then
        assertThat(out.toString())
                .isEqualTo("hunch가 최종 우승했습니다.\n");
    }

    @Test
    void 위너출력_검사_2명() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        //when
        OutputView.printWinner(Arrays.asList("jiwoo","juri"));

        //then
        assertThat(out.toString())
                .isEqualTo("jiwoo, juri가 최종 우승했습니다.\n");
    }
}