package dto;

import domain.Car;
import domain.Winners;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinnersResponse {
    private final List<String> names;

    public WinnersResponse(Winners winners) {
        this.names = convertToNames(winners);
    }

    private List<String> convertToNames(Winners winners) {
        List<String> names = new ArrayList<>();
        for (Car winner : winners.winners()) {
            names.add(winner.getName().getName());
        }
        return names;
    }

    public List<String> getNames() {
        return Collections.unmodifiableList(names);
    }
}
