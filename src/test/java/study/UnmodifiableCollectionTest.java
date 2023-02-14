package study;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UnmodifiableCollectionTest {
    @Test
    public void unmodifiableCollectionTest() {
        List<Car> originalNames = new ArrayList<>();
        originalNames.add(new Car("Fafi", 0));
        originalNames.add(new Car("Kevin", 0));

        List<Car> streamNames =
                originalNames.stream()
                        .collect(Collectors.toUnmodifiableList());// crewNames: Fafi, Kevin

        List<Car> collectionNames = Collections.unmodifiableList(originalNames);

        originalNames.add(new Car("Sally", 0)); //crewNames: Fafi, Kevin, Sally

        assertThat(streamNames.stream()
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList()))
                .isEqualTo(List.of("Fafi","Kevin"));

        assertThat(collectionNames.stream()
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList()))
                .isEqualTo(List.of("Fafi","Kevin","Sally"));
    }

}
