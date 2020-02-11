package controller;

import model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameManagerTest {
    private List<Car> carList = new ArrayList<>();

    @DisplayName("이름을 입력받아 ',' 로 분리")
    @Test
    public void nameSplit() {
        String input = "k3,k5,audi";
        String[] names = GameManager.nameSplit(input);
        assertThat(names).containsExactly("k3", "k5", "audi");
    }
}
