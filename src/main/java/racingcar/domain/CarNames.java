package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class CarNames {
    final static int MIN_CAR_LENGTH = 1;
    final static int MAX_CAR_LENGTH = 5;

    private String[] names;

    public CarNames(String name) throws IllegalArgumentException {
        name.replaceAll(" ", "");
        String[] names = name.split(",");
        List<String> carNames = Arrays.asList(names);

        underCarNameLengthException(names);
        duplicateNameException(carNames);
        overCarNameLengthException(names);

        this.names = names;
    }

    /* For Test */
    public CarNames(){

    }

    public String[] getName() {
        return names;
    }

    protected void duplicateNameException(List<String> carNames) throws IllegalArgumentException {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new IllegalArgumentException("중복된 이름은 안됩니다.\n다시 입력해 주세요.");
        }
    }

    protected void underCarNameLengthException(String[] names) throws IllegalArgumentException {
        if (names.length < MIN_CAR_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1글자 이상이여야 합니다.\n다시 입력해 주세요.");
        }

        for(String name : names){
            if(name.length()<= 0){
                throw new IllegalArgumentException("자동차 이름은 1글자 이상이여야 합니다.\n다시 입력해 주세요.");
            }
        }
    }

    protected void overCarNameLengthException(String[] names) throws IllegalArgumentException {
        for (String name : names) {
            if (name.length() > MAX_CAR_LENGTH || name.length() <= 0) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이내여야 합니다.\n다시 입력해 주세요.");
            }
        }
    }

}
