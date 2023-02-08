package util;

import java.util.List;

public class CarNameValidator {
    public void validate(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException("2개 이상의 자동차를 입력해 주세요.");
        }
        for(String name : names){
            if(name.length() > 5){
                throw new IllegalArgumentException("5자 이하의 이름을 입력해주세요.");
            }
        }
    }
}
