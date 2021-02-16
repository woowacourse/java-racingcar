package racingCar;

public class CarName {

    private String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException("길이가 1~5사이의 이름을 입력해주세요.");
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarName)) return false;

        CarName carName1 = (CarName) o;

        return name.equals(carName1.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
