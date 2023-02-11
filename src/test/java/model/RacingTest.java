package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingTest {

    @Test
    @DisplayName("자동차 이동 결과 확인")
    void moveAll() {
        LinkedHashMap<MovableStrategy, Integer> scoreBoard = new LinkedHashMap<>();
        scoreBoard.put(new TestCarSuccess("TestTrue"), 0);
        scoreBoard.put(new TestCarFail("TestFail"), 0);

        Racing racing = new Racing(scoreBoard);
        racing.moveAll();
        racing.moveAll();

        assertThat(racing.toString()).isEqualTo("TestTrue : --\n"
                + "TestFail : \n");
    }

    @Test
    @DisplayName("경주 우승자 확인")
    void winner() {
        LinkedHashMap<MovableStrategy, Integer> scoreBoard = new LinkedHashMap<>();
        scoreBoard.put(new TestCarSuccess("TestTrue"), 0);
        scoreBoard.put(new TestCarFail("TestFail"), 0);

        Racing racing = new Racing(scoreBoard);
        racing.moveAll();
        racing.moveAll();

        assertThat(racing.getWinner().toString()).isEqualTo("[TestTrue]");
    }


    public class TestCarSuccess implements MovableStrategy {

        private final String name;

        public TestCarSuccess(String name) {
            this.name = name;
        }

        @Override
        public boolean isMove() {
            return true;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public class TestCarFail implements MovableStrategy {

        private final String name;

        public TestCarFail(String name) {
            this.name = name;
        }

        @Override
        public boolean isMove() {
            return false;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
