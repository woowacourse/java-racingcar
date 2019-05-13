package domain;

import util.Util;

import java.util.*;

/**
 * 레이스 게임을 진행해 자동차들을 이동시키는 클래스
 * <br> Race race = new Race(raceCars);
 * <br> Race race = new Race(raceCars, roundCount);
 *
 * @author heebg
 * @version 1.0 2019-05-08
 */
public class Race {
    private List<Car> raceCars;
    private HashMap<String, Integer> roundCounts;
    private static final String ROUND_COUNT = "roundCount";
    private static final String NOW_ROUND_COUNT = "nowRoundCount";

    /**
     * Race 생성자
     * <br> 횟수는 자동으로 최소+1로 초기화
     *
     * @param raceCars 레이싱 게임에 참가하는 자동차들
     */
    public Race(List<Car> raceCars) {
        this(raceCars, Const.MIN_ROUND_COUNT + 1);
    }

    /**
     * Race 생성자
     * <br> 횟수는 자동으로 최소+1로 초기화
     *
     * @param names 자동차들 이름
     */
    public Race(String names) {
        this(names, Const.MIN_ROUND_COUNT + 1);
    }

    /**
     * Race 생성자.
     * <br> 횟수는 범위 확인 후 초기화
     *
     * @param raceCars   레이싱 게임에 참가하는 자동차들
     * @param roundCount 총 진행할 게임 횟수
     * @throws IllegalArgumentException 게임 진행 횟수가 최소보다 작을 경우 발생
     */
    public Race(List<Car> raceCars, int roundCount) {
        Util.checkRoundCountRange(roundCount);
        this.raceCars = raceCars;
        this.roundCounts = new HashMap<>();
        this.roundCounts.put(ROUND_COUNT, roundCount);
        this.roundCounts.put(NOW_ROUND_COUNT, Const.MIN_ROUND_COUNT);
    }

    /**
     * Race 생성자
     *
     * @param carNames   자동차들 이름
     * @param roundCount 총 진행할 게임 횟수
     */
    public Race(String carNames, int roundCount) {
        Util.checkRoundCountRange(roundCount);
        this.raceCars = setCars(carNames);
        this.roundCounts = new HashMap<>();
        this.roundCounts.put(ROUND_COUNT, roundCount);
        this.roundCounts.put(NOW_ROUND_COUNT, Const.MIN_ROUND_COUNT);
    }

    private List<Car> setCars(String carNames) {
        List<Car> cars = new ArrayList<>();
        List<String> names = Arrays.asList(carNames.split(","));
        names.replaceAll(String::trim);
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    /**
     * 레이싱을 진행중인 자동차들의 정보들 반환
     *
     * @return carInfo 자동차들의 정보
     */
    public List<String> getRaceCarsInfo() {
        List<String> carInfo = new ArrayList<>();
        for (Car car : raceCars) {
            carInfo.add(car.toString());
        }
        return carInfo;
    }

    /**
     * 남은 횟수만큼 레이싱 게임을 진행
     *
     * @return Race 게임이 종료된 상태의 Race
     */
    public Race moveAllCars() {
        while (hasNextRound()) {
            moveAllCarOneTime();
        }
        return this;
    }

    /**
     * 게임이 종료되었다면 Winners 객체를 반환
     *
     * @return winners 현재 객체로 초기화한 Winners 객체
     * @throws IllegalArgumentException 게임이 종료되지 않았을 경우
     */
    public Winners winners() {
        if (hasNextRound()) {
            throw new IllegalArgumentException();
        }
        return new Winners(raceCars);
    }

    /**
     * 남은 게임 횟수가 존재하는지 확인
     *
     * @return true : 다음 바퀴가 존재 <br> false : 게임 종료
     */
    public boolean hasNextRound() {
        if (roundCounts.get(NOW_ROUND_COUNT) < roundCounts.get(ROUND_COUNT)) {
            return true;
        }
        return false;
    }

    /**
     * 자동차들이 게임을 1회 실행
     * <br> 게임 실행 후 진행한 게임 횟수 증가.
     *
     * @return Race
     */
    public Race moveAllCarOneTime() {
        for (Car car : raceCars) {
            car.increasePositionOrNot(Util.getRandomNumber());
        }
        roundCounts.put(NOW_ROUND_COUNT, roundCounts.get(NOW_ROUND_COUNT) + 1);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return Objects.equals(raceCars, race.raceCars) &&
                Objects.equals(roundCounts, race.roundCounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceCars, roundCounts);
    }
}
