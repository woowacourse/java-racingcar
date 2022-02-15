package racingcar.vo;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class RoundResult {

    private static final String RESULT_DELIMITER = ":";
    private static final int NAME_INDEX = 0;
    private static final int POSITION_INDEX = 1;

    private Map<String, Integer> roundResult = new LinkedHashMap<>();

    public void add(Car car) {
        String[] carInformation = car.toString().split(RESULT_DELIMITER);
        roundResult.put(carInformation[NAME_INDEX], Integer.parseInt(carInformation[POSITION_INDEX]));
    }

    public Set<String> getNames() {
        return roundResult.keySet();
    }

    public Integer getPosition(String name) {
        return roundResult.get(name);
    }
}
