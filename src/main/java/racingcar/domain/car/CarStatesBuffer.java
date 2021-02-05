package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarStatesBuffer {
    private static final String DELIMITER = "\n\n";
    private static final String EXECUTION_RESULT = "실행 결과\n";

    private List<CarStates> carStatesLog;

    public CarStatesBuffer() {
       this.carStatesLog = new ArrayList<>();
    }

    public void append(CarStates carStates) {
        carStatesLog.add(carStates);
    }

    public void clear() {
        carStatesLog.clear();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(EXECUTION_RESULT);
        stringBuffer.append(String.join(DELIMITER,
                carStatesLog.stream()
                        .map(CarStates::toString)
                        .collect(Collectors.toList())));

        return stringBuffer.toString();
    }

}