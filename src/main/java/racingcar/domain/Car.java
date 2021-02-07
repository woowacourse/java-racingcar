package racingcar.domain;

/**
 * CarDTO.java
 * Car 클래스에 대해 Layer간 데이터 전송을 위한 DTO 클래스
 *
 * @author Kimun Kim, github.com/tributetothemoon
 */
public class Car implements Comparable<Car> {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String ERROR_MAX_NAME_LENGTH = "자동차 이름의 길이는 " + MAX_NAME_LENGTH + "자를 초과할 수 없습니다.";

    private final String name;
    private int position = 0;

    private Car(String name) {
        this.name = name;
    }

    public static Car from(String name) {
        if (MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException(ERROR_MAX_NAME_LENGTH);
        }
        return new Car(name);
    }

    void move() {
        if (DecisionMaker.makeDecision()) {
            this.position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    /* 테스팅을 위한 setter 메소드 */
    public void setPosition(int position) {
        this.position = position;
    }

    public CarDTO toDTO() {
        return new CarDTO(this.name, this.position);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Car paramObj = (Car) obj;
        return this.name.equals(paramObj.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.position, o.position);
    }

}
