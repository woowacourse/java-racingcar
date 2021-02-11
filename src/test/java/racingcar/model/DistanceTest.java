package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DistanceTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, -100})
    public void Name_생성자_테스트(int invalidDistance) {
        assertThatThrownBy(() -> new Distance(invalidDistance))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 거리는 0 미만으로 초기화 할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 15})
    public void Name_getDistance_테스트(int testDistance) {
        Distance distance = new Distance(testDistance);
        assertThat(testDistance == distance.getDistance()).isTrue();
    }

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