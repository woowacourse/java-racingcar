package controller;

import dto.RacingCarNameDto;
import view.InputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarController {
    public void start() {
        List<String> carNames = splitCarName(InputView.inputCarNames());
        List<RacingCarNameDto> racingCarNamesDtos = carNames.stream().map(RacingCarNameDto::new).collect(Collectors.toList());
        checkCarNameDuplication(racingCarNamesDtos);
    }

    private List<String> splitCarName(String input) {
        List<String> names = List.of(input.split(","));
        return names;
    }

    private void checkCarNameDuplication(List<RacingCarNameDto> racingCarNameDtos) {
        if (isDuplicated(racingCarNameDtos)) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    private boolean isDuplicated(List<RacingCarNameDto> racingCarNameDtos) {
        return racingCarNameDtos.stream().distinct().count() < racingCarNameDtos.size();
    }
}
