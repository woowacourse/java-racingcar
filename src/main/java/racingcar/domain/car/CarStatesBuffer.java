package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarStatesBuffer {
    private final List<CarStates> carStatesLog;

    public CarStatesBuffer() {
        this.carStatesLog = new ArrayList<>();
    }

    public void append(CarStates carStates) {
        carStatesLog.add(carStates);
    }

    public List<CarStates> getCarStatesLog() {
        return Collections.unmodifiableList(carStatesLog);
    }
}