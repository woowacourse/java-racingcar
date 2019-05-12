//package roundRacing.controller;
//
//import org.junit.jupiter.api.Test;
//
//import roundRacing.domain.RacingGame;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//class ControllerTest {
//    @Test
//    void 입력이잘변환되나요() {
//        String[] expectation = {"kwon", "kim", "Luffy", "Buddy"};
//        RacingGame carList = new RacingGame();
//        carList.addCars(expectation);
//        assertThat(PlayRacingGame.makeCarList("kwon,kim,Luffy,Buddy")).isEqualTo(carList);
//    }
//
//    @Test
//    void 카리스트에서우승자를잘뽑아내나요() {
//        PlayRacingGame.makeCarList("kwon,kim,Luffy,Buddy");
//        assertThat(PlayRacingGame.getWinners()).isEqualTo("kwon, kim, Luffy, Buddy");
//    }
//
//    @Test
//    void 이름배열이비어있으면예외처리가되나요콤마만입력해봄() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            PlayRacingGame.makeCarList(",,,,,");
//        });
//    }
//
//    @Test
//    void 이름배열이비어있으면예외처리가되나요아무것도안입력() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            PlayRacingGame.makeCarList("");
//        });
//    }
//}