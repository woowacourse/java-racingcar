package racingcar.domain;

import java.util.List;

//todo: TestNumberGenerator 클래스를 따로 분리해서 사용하기
public class TestNumberGenerator implements NumberGenerator {

    private final List<Integer> numbers;

    public TestNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public int generate() {
        return numbers.remove(0);
    }
}
