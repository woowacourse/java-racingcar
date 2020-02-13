package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {
    List<Name> names;

    public Names(String carNames) throws IllegalArgumentException {
        this.names = Arrays.stream(carNames.split(","))
                .map(Name::new)
                .collect(Collectors.toList());
    }

    //테스트 코드를 위한 getter메소드
    public String get(int index) {
        return names.get(index).toString();
    }

}
