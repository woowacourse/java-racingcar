package racingcar.domain;

/**
 * CarDTO.java
 * Car 클래스에 대해 Layer간 데이터 전송을 위한 DTO 클래스
 *
 * @author Kimun Kim, github.com/tributetothemoon
 */
public class CarDTO {
    private final String name;
    private final int position;

    public CarDTO(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
