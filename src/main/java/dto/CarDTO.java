package dto;

// TODO: Car 도 값을 전달해주는 역할을 할 수 있을듯 합니다. (툴이라던가... 재귀적으로 내부 파라미터를 원시값으로 get 할 수 있는요)
// 그런데 현재는 잘 모르겠어서... 따로 DTO 라는 객체를 만들었습니다.
public class CarDTO {
    private final String name;
    private final int distance;

    private CarDTO(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public static CarDTO of(String name, int distance) {
        return new CarDTO(name, distance);
    }
}
