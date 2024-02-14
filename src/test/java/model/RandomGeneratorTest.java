package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
class RandomGeneratorTest {

    @DisplayName("0에서 9 사이에서 random한 값을 구할 수 있다.")
    @RepeatedTest(100)
    void run(){
        assertThat(RandomGenerator.run()).isBetween(0,9);
    }
}