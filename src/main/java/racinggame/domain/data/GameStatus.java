package racinggame.domain.data;

import java.util.*;

/**
 * Output 클래스는 OutputView와 RacingGame 사이에서 출력값의 가공, 전달을 맡는 클래스이다.
 * 데이터의 검증과 변형, OutputView 메서드 호출 등을 포함한다.
 * 또한 출력에 쓰이는 자동차의 주행 기록과 승자 목록 을 포장하여 타 클래스에서 접근할 수 없도록 한다.
 */
public class GameStatus {
    /**
     * winners 는 게임이 종료된 뒤 출력되는, 승자의 이름 값을 모은 리스트이다.
     */
    private List<String> winners = new ArrayList<>();

    /**
     * carStatus 는 자동차의 주행 기록을 담은 Map이다.
     * 각 차의 이름과 그 차의 위치값을 매핑시키고, 값의 변화 발생시 이를 업데이트한다.
     */
    private Map<String, Integer> carStatus = new LinkedHashMap<>();

    private int maxDistance = 0;


    public GameStatus(List<String> names) {
        for (String name : names) {
            carStatus.put(name, 0);
        }
    }
    /**
     * makeWinnerNames 는 Car 인스턴스의 목록을 받아, 이들 중 경주에서 승리한 인스턴스의 이름 값을
     * 필드에 있는 winners에 추가한다.
     */
    public List<String> makeWinnerNames() {
        for (Map.Entry<String, Integer> entry : carStatus.entrySet()) {
            if (maxDistance == entry.getValue()) {
                winners.add(entry.getKey());
            }
        }
        return winners;
    }

    /**
     * updateCarStatus는 이름과 횟수를 전달받아, map으로 선언된 carStatus에서 이를 조회,갱신한다.
     *
     * @param name     값을 찾기 위한 key 값이다.
     * @param position 주행 거리를 담은, 실제로 저장될 value 값이다.
     */
    public void updateCarStatus(String name, int position) {
        carStatus.put(name, position);
        maxDistance = Integer.max(maxDistance, position);
    }

    public Map<String, Integer> getStatusLog() {
        return carStatus;
    }
}
