package controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import model.NumberGenerator;
import view.InputView;
import view.OutputView;


class RaceTest {

    private ByteArrayOutputStream outputStreamCaptor;
    private TestNumberGenerator testNumberGenerator;
    private Race race;

    static class TestNumberGenerator implements NumberGenerator {

        private final int number;

        public TestNumberGenerator(int number) {
            this.number = number;
        }

        @Override
        public int generateNumber() {
            return this.number;
        }
    }

    @Test
    void 차가_전진하지_않는_메인_로직_테스트() {
        // given
        System.setIn(new ByteArrayInputStream("mark,prin\n1".getBytes()));
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        race = new Race(new InputView(), new OutputView(), new TestNumberGenerator(1));

        // when
        race.run();

        // then
        assertThat(outputStreamCaptor.toString()).contains("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분).",
                "시도할 회수는 몇 회인가요?",
                "mark : ",
                "prin : ",
                "mark, prin가 최종 우승했습니다."
        );
    }
}
