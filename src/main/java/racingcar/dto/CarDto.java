package racingcar.dto;

public class CarDto {
    private final String name;
    private final int position;

    //TODO
    // Car 객체를 생성자 매개변수로 받기
    public CarDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}