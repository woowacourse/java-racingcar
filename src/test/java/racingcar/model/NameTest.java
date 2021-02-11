package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "longName"})
    public void Name_생성자_테스트(String invalidName) {
        assertThatThrownBy(() -> new Name(invalidName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[Error] 자동차 이름은 1자 이상, 5자 이하여야 합니다.");
    }

    @Test
    public void Name_내부_인스턴스_name_불변_테스트() {
        String playerName = "hello";
        Name name = new Name(playerName);
        System.out.println(name.getName());
        //String 클래스가 불변 객체인지를 Test
        name.getName().replace("hello", "ATTACK!");
        assertThat(playerName == name.getName());
    }

    @ParameterizedTest
    @ValueSource(strings = {"joel", "woogi", "city"})
    public void Name_getName_테스트(String testName) {
        String playerName = testName;
        Name name = new Name(playerName);
        assertThat(playerName == name.getName()).isTrue();
    }

    @Test
    public void Name_equals_테스트() {
        Name testName1 = new Name("test");
        Name testName2 = new Name("test");
        assertThat(testName1).isEqualTo(testName2);
    }

    @Test
    public void Name_equals_테스트2() {
        Name testName1 = new Name("test");
        Name testName2 = new Name("test");
        assertThat(testName1.equals(testName2)).isTrue();
    }

    @Test
    public void Name_hashCode_테스트() {
        Name testName1 = new Name("test");
        Name testName2 = new Name("test");
        assertThat(testName1.hashCode() == testName2.hashCode()).isTrue();
    }

    @Test
    public void Name_hashCode_테스트2() {
        Name testName1 = new Name("test");
        Name testName2 = new Name("test");
        Set<Name> testSet = new HashSet<>();

        testSet.add(testName1);
        testSet.add(testName2);
        assertThat(testSet.size()).isEqualTo(1);
    }
}
