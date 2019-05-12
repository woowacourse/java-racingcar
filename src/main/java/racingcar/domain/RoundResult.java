package racingcar.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RoundResult {
    private Map<String, StringBuffer> roundResult = new LinkedHashMap<>();

    public void addParticipant(Car car) {
        addParticipant(car, 0);
    }

    public void addParticipant(Car car, int initialPosition) {
        roundResult.put(car.toString(), drawPositionLine(initialPosition));
    }

    public StringBuffer drawPositionLine(int position) {
        StringBuffer positionLine = new StringBuffer();
        for (int i = 0; i < position; i++) {
            positionLine.append("-");
        }
        return positionLine;
    }

    public void updateResult(Car car) {
        roundResult.replace(car.toString(), roundResult.get(car.toString()).append("-"));
    }

    public List<String> getFormattedRoundResult() {
        List<String> formattedResult = new ArrayList<>();
        roundResult.keySet().forEach(x -> formattedResult.add(x + " : " + roundResult.get(x)));
        return formattedResult;
    }

    @Override
    public boolean equals(Object obj) {
        Map<String, StringBuffer> objRoundResult = ((RoundResult) obj).roundResult;
        if (objRoundResult.size() != roundResult.size()) {
            return false;
        }
        return objRoundResult.entrySet().stream()
                .allMatch(e -> e.getValue().toString().equals(
                        roundResult.get(e.getKey()).toString()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((roundResult.size() == 0) ? 0 : roundResult.keySet().hashCode());
        return result;
    }
}