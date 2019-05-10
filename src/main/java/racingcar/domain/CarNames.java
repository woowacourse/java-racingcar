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

        minimalCarNameException(names);

        duplicateNameException(carNames);

        maximumCarNameException(names);

        this.names = names;
    }

    public CarNames(){

    }; //테스트용 생성자

    public String[] getName() {
        return names;
    }

    protected void duplicateNameException(List<String> carNames) throws IllegalArgumentException {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new IllegalArgumentException("중복된 이름은 안됩니다.\n다시 입력해 주세요.");
        }
    }

    protected void minimalCarNameException(String[] names) throws IllegalArgumentException {
        if (names.length < MIN_CAR_LENGTH) {
            throw new IllegalArgumentException("글자 수는 1글자 이상이여야 합니다.\n다시 입력해 주세요.");
        }

        for(String name : names){
            if(name.length()<= 0){
                throw new IllegalArgumentException("글자 수는 1글자 이상이여야 합니다.\n다시 입력해 주세요.");
            }
        }

    }

    protected void maximumCarNameException(String[] names) throws IllegalArgumentException {
        for (String name2 : names) {
            if (name2.length() > MAX_CAR_LENGTH || name2.length() <= 0) {
                throw new IllegalArgumentException("글자 수는 5글자 이내여야 합니다.\n다시 입력해 주세요.");
            }
        }
    }

}
