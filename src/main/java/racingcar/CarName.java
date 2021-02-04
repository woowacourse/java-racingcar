package racingcar;

public class CarName {

    public static final int MAXIMUM_LENGTH = 5;
    private final String name;

    public CarName(String name){
        validateBlank(name);
        validateLength(name);
        this.name = name;
    }

    private void validateBlank(String name) {
        if(name.contains(" ")){
            throw new IllegalArgumentException();
        }
    }

    private void validateLength(String name) {
        if(name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }
}
