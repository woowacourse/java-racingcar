package racingcar.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RoundResult {
    private Map<String, Integer> roundResult = new LinkedHashMap<>();

    public RoundResult(List<Car> cars) {
        cars.forEach(car -> roundResult.put(car.toString(), car.getPosition()));
    }

    public List<String> getWinners() {
        return roundResult.keySet().stream()
                .filter(x -> roundResult.get(x) == Collections.max(roundResult.values()))
                .collect(Collectors.toList());
    }

    public String getFormattedRoundResult() {
        StringBuffer formattedRoundResult = new StringBuffer();
        for (String carName : roundResult.keySet()) {
            formattedRoundResult.append(carName);
            formattedRoundResult.append(" : ");
            formattedRoundResult.append(drawPositionLine(roundResult.get(carName)));
            formattedRoundResult.append("\n");
        }
        return formattedRoundResult.toString();
    }

    private String drawPositionLine(int position) {
        StringBuffer positionLine = new StringBuffer();
        for (int i = 0; i < position; i++) {
            positionLine.append("-");
        }
        return positionLine.toString();
    }

    @Override
    public boolean equals(Object obj) {
        Map<String, Integer> objRoundResult = ((RoundResult) obj).roundResult;
        if (!objRoundResult.keySet().equals(roundResult.keySet())) {
            return false;
        }
        return objRoundResult.keySet().stream()
                .allMatch(x -> roundResult.get(x) == objRoundResult.get(x));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((roundResult.size() == 0) ? 0 : roundResult.keySet().hashCode());
        return result;
    }
}
