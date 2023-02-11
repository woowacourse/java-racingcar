package racingcar.dto;

import racingcar.domain.Car;

public class RacingCarStatusResponse {
    private final String name;
    private final int position;

    private RacingCarStatusResponse(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static RacingCarStatusResponse of(Car car) {
        return new RacingCarStatusResponse(car.getName().getValue(), car.getPosition().getValue());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    /**
     * 자동차의 정보를 문자열 형식으로 반환한다.
     * 이름과 '-'를 postion의 수만큼 반환한다.
     * ex) Glen : -----, Bero : -
     */
    public String asString() {
        return String.format("%s : %s", name, "-".repeat(position));
    }
}
