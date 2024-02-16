package dto;

import domain.Car;
import domain.Winners;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WinnersResponse {
    private final List<String> names;

    public WinnersResponse(Winners winners) {
        this.names = convertToNames(winners);
    }

    private List<String> convertToNames(Winners winners) {
        return winners.winners().stream().map(Car::getName).collect(Collectors.toList());
    }

    public List<String> getNames() {
        return names;
    }
}
