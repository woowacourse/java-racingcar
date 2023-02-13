package view;

import utils.InputReader;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class MockingInputReader implements InputReader {
    private final Iterator<String> inputs;

    public MockingInputReader(String... inputs) {
        List<String> input = Arrays
                .stream(inputs)
                .collect(Collectors.toList());
        this.inputs = input.iterator();
    }

    @Override
    public String readInput() {
        if (inputs.hasNext()) {
            return inputs.next();
        }
        throw new RuntimeException("다음으로 실행할 모킹 값이 없습니다.");
    }
}
