package calculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateQueueTest {

    CalculateQueue calculateQueue;
    @Test
    void 계산_검사(){
        assertThat(new CalculateQueue("1 + 3 - 2 * 10 / 2".split(" ")).calculate()).isEqualTo(10);
        assertThat(new CalculateQueue("100 * 10 / 50 + 10 - 30".split(" ")).calculate()).isEqualTo(0);
    }

}