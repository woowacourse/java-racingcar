package controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import model.NumberGenerator;

class RaceTest {

    private ByteArrayOutputStream outputStreamCaptor;
    private TestNumberGenerator testNumberGenerator = new TestNumberGenerator();
    private Race race = new Race(testNumberGenerator);

    class TestNumberGenerator implements NumberGenerator {
        private int number;
        @Override
        public int generateNumber() {
            return this.number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }


    @Test
    void 차가_전진하지_않는_메인_로직_테스트() {
        // given
        System.setIn(new ByteArrayInputStream("mark,prin\n1".getBytes()));
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        testNumberGenerator.setNumber(1);

        // when
        race.start();

        // then
        assertThat(outputStreamCaptor.toString()).contains("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분).",
                "시도할 회수는 몇 회인가요?",
                "mark : ",
                "prin : ",
                "mark, prin가 최종 우승했습니다."
                );
    }




}