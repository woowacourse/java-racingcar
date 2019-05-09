package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class WinningCars {
    private List<String> winningCarNames=new ArrayList<>();

    public List<String> getWinningCarNames() {
        return winningCarNames;
    }

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder(String.join(", ",winningCarNames));
        sb.append(" 가 최종 우승했습니다.");
        return sb.toString();
    }
}
