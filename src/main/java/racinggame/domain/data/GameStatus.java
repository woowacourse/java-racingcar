package racinggame.domain.data;

import java.util.*;

/**
 * Output 클래스는 OutputView와 RacingGame 사이에서 출력값의 가공, 전달을 맡는 클래스이다.
 * 데이터의 검증과 변형, OutputView 메서드 호출 등을 포함한다.
 * 또한 출력에 쓰이는 자동차의 주행 기록과 승자 목록 을 포장하여 타 클래스에서 접근할 수 없도록 한다.
 */
public class GameStatus {
    /**
     * LOG_DELIMITER 는 문자열 상수 값으로, 자동차 주행 기록에 들어가는 양식이다.
     */
    private static final String LOG_DELIMITER = " : ";

    /**
     * POSITION_CHARACTER 는 문자열 상수 값으로, 자동차 주행 기록에 들어가는 양식이다.
     */
    private static final String POSITION_CHARACTER = "-";

    /**
     * SPLIT_DELIMITER 는 문자열 상수 값으로, 승자 목록 출력 시에 들어가는 양식이다.
     */
    private static final String SPLIT_DELIMITER = ",";

    /**
     * winners 는 게임이 종료된 뒤 출력되는, 승자의 이름 값을 모은 리스트이다.
     */
    private List<String> winners = new ArrayList<>();

    /**
     * carStatus 는 자동차의 주행 기록을 담은 Map이다.
     * 각 차의 이름과 그 차의 위치값을 매핑시키고, 값의 변화 발생시 이를 업데이트한다.
     */
    private Map<String, Integer> carStatus = new LinkedHashMap<>();

    private int maxDistance=0;


    public GameStatus(List<String> names) {
        for(String name : names){
            carStatus.put(name,0);
        }
    }

    /**
     * makeStatusLog는 자동차의 주행 기록을 String으로 변형시켜, 이를 반환하는 메서드이다.
     * 이름과 양식을 집어넣고, 이후 주행 거리만큼 특수 양식을 반복 삽입한다.
     * 삽입 시 반복문을 사용하는 구조는 추후 개선할 예정이다.
     *
     * @param name     데이터에 들어갈 이름 값으로, 문자열 값이다.
     * @param position 데이터에 들어갈 주행 거리 값으로, 정수형이다.
     * @return 데이터를 바탕으로 만들어진 문자열 값을 반환한다.
     */
    public String makeStatusLog(String name, int position) {
        StringBuilder log = new StringBuilder(name);
        log.append(LOG_DELIMITER);
        for (int i = 0; i < position; i++) {
            log.append(POSITION_CHARACTER);
        }
        return log.toString();
    }

    /**
     * makeWinnerNames 는 Car 인스턴스의 목록을 받아, 이들 중 경주에서 승리한 인스턴스의 이름 값을
     * 필드에 있는 winners에 추가한다.
     */
    public void makeWinnerNames() {
        for (Map.Entry<String, Integer> entry : carStatus.entrySet()) {
            if (maxDistance == entry.getValue()) {
                winners.add(entry.getKey());
            }
        }
    }

    public String getWinnerNames(){
        StringBuilder log = new StringBuilder();
        for(String name : winners){
            log.append(name);
        }
        return log.toString();
    }

    /**
     * updateCarStatus는 이름과 횟수를 전달받아, map으로 선언된 carStatus에서 이를 조회,갱신한다.
     *
     * @param name     값을 찾기 위한 key 값이다.
     * @param position 주행 거리를 담은, 실제로 저장될 value 값이다.
     */
    public void updateCarStatus(String name, int position) {
        carStatus.put(name, position);
        maxDistance = Integer.max(maxDistance,position);
    }

    /**
     * printLog는 carStatus에 저장된 Car 인스턴스들의 주행 기록을 바탕으로,
     * 이를 시각화하여 OutputView에 전달하여 출력하는 메서드이다.
     * map에 저장된 모든 값에 대해 makeStatusLog를 수행하여 이 값들을 OutputView에 전달한다.
     * 모든 값이 출력된 뒤에는 양식에 맞추어 개행 출력 메서드를 호출한다.
     */
    public String getStatusLog() {
        StringBuilder resultLog = new StringBuilder();
        for (Map.Entry<String, Integer> entry : carStatus.entrySet()) {
            String name = entry.getKey();
            String log = makeStatusLog(name, carStatus.get(name));
            resultLog.append(log);
            resultLog.append("\n");
        }
        return resultLog.toString();
    }

    /**
     * isContainName은 테스트를 위한 메서드로,
     * winners에 저장된 승자 목록에 파라미터로 전달된 이름이 있는지 확인하여
     * boolean으로 반환하는 메서드이다.
     *
     * @param name 검사를 위해 전달되는 이름으로, String 값이다.
     * @return name이 winners에 있다면 true를, 아니라면 false를 반환한다.
     */
    public boolean isContainName(String name) {
        return winners.contains(name);
    }
}
