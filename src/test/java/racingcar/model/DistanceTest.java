package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class DistanceTest {
    @Test
    public void Distance_equals_테스트() {
        Distance test1 = new Distance(3);
        Distance test2 = new Distance(3);
        assertThat(test1).isEqualTo(test2);
    }

    @Test
    public void Distance_equals_테스트2() {
        Distance test1 = new Distance(3);
        Distance test2 = new Distance(3);
        assertThat(test1.equals(test2)).isTrue();
    }

    @Test
    public void Distance_hashCode_테스트() {
        Distance test1 = new Distance(3);
        Distance test2 = new Distance(3);
        assertThat(test1.hashCode() == test2.hashCode()).isTrue();
    }

    @Test
    public void Distance_hashCode_테스트2() {
        Distance test1 = new Distance(3);
        Distance test2 = new Distance(3);
        Set<Distance> testSet = new HashSet<>();

        testSet.add(test1);
        testSet.add(test2);
        assertThat(testSet.size()).isEqualTo(1);
    }
}