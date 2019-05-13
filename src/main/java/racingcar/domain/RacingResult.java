/*package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingResult {
    private Map<String, List<Integer>> racingResult = new LinkedHashMap<>();

    public void addParticipant(Car car) {
        addParticipant(car, 0);
    }

    public void addParticipant(Car car, int initialPosition) {
        racingResult.put(car.toString(), new ArrayList<>(Arrays.asList(initialPosition)));
    }

    public void updateResult(Car car, boolean move) {
        int increase = move ? 1 : 0;
        List<Integer> carResult = racingResult.get(car.toString());
        int beforeResult = carResult.get(carResult.size() - 1);
        carResult.add(beforeResult + increase);
    }

    public List<String> getFormattedRacingResult() {
        List<String> formattedResult = new ArrayList<>();
        int numOfRound = getNumOfRound();
        for (int i = 1; i <= numOfRound; i++) {
            formattedResult.add(getFormattedRoundResult(i));
        }
        return formattedResult;
    }

    int getNumOfRound() {
        int numOfRound = 0;
        for (List<Integer> result : racingResult.values()) {
            numOfRound = Math.max(result.size(), numOfRound);
        }
        return numOfRound - 1;
    }

    String getFormattedRoundResult(int i) {
        StringBuffer formattedRoundResult = new StringBuffer();
        for (String carName : racingResult.keySet()) {
            if (racingResult.get(carName).size() <= i) {
                continue;
            }
            formattedRoundResult.append(carName);
            formattedRoundResult.append(" : ");
            formattedRoundResult.append(drawPositionLine(racingResult.get(carName).get(i)));
            formattedRoundResult.append("\n");
        }
        return formattedRoundResult.toString();
    }

    String drawPositionLine(int position) {
        StringBuffer positionLine = new StringBuffer();
        for (int i = 0; i < position; i++) {
            positionLine.append("-");
        }
        return positionLine.toString();
    }

    public List<String> getWinners() {
        List<Integer> finalRoundResult = new ArrayList<>();
        for (String carName : racingResult.keySet()) {
            finalRoundResult.add(racingResult.get(carName).get(racingResult.get(carName).size() - 1));
        }
        int winnerPosition = Collections.max(finalRoundResult);
        if (winnerPosition == 0) {
            return new ArrayList<>();
        }
        return racingResult.keySet().stream()
                .filter(x -> racingResult.get(x).contains(winnerPosition))
                .map(x -> x.toString())
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object obj) {
        Map<String, List<Integer>> objRoundResult = ((RacingResult) obj).racingResult;
        if (!objRoundResult.keySet().equals(racingResult.keySet())) {
            return false;
        }
        return objRoundResult.keySet().stream()
                .allMatch(x -> isEqualResult(racingResult.get(x), objRoundResult.get(x)));
    }

    boolean isEqualResult(List<Integer> result1, List<Integer> result2) {
        if (result1.size() != result2.size()) {
            return false;
        }
        for (int i = 0; i < result1.size(); i++) {
            if (result1.get(i) != result2.get(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((racingResult.size() == 0) ? 0 : racingResult.keySet().hashCode());
        return result;
    }
}*/