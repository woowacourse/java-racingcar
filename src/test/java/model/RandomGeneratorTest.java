package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
class RandomGeneratorTest {

    @DisplayName("0에서 9 사이에서 random한 값을 구할 수 있다.")
    @RepeatedTest(100)
    void run(){
        assertThat(RandomGenerator.run(1)).containsAnyOf(0,1,2,3,4,5,6,7,8,9);
    }
}