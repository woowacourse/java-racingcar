package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Racers {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String DUPLICATE_NAME = ERROR_PREFIX + "이름이 중복되었습니다";
    private static final String COMMA = ",";
    private static final String WHITESPACE = " ";
    private static final String EMPTY = "";

    private final List<Racer> racers;

    public Racers(String names) {
        List<Racer> carRacers = splitNames(names);
        checkDuplicate(carRacers);
        this.racers = carRacers;
    }

    private void checkDuplicate(List<Racer> carRacers) {
        boolean duplicated = carRacers.stream()
                .distinct()
                .count() != carRacers.size();

        if (duplicated) {
            throw new IllegalArgumentException(DUPLICATE_NAME);
        }
    }

    private List<Racer> splitNames(String names) {
        return Stream.of(names.split(COMMA))
                .map(s -> s.replaceAll(WHITESPACE, EMPTY))
                .map(Racer::new)
                .collect(Collectors.toList());
    }

    public Stream<Racer> streams() {
        return racers.stream();
    }
}
