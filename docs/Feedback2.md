# 중점적으로 리팩터링 한 부분

## Car객체를 생성할 때 CarName을 받도록 변경

    -Car객체를 생성할 때 보증된 CarName을 받도록 변경하였습니다.

## RacingGameController 내의 메서드를 하나의 일만 하도록 변경

    - 질문을 보냈었던 예외처리 메서드를 잘게 나누는 작업 진행
    - 이외에도 View계층에서 처리하면 좋을 것 같은 공백 간격을 View 계층에게 전달

### 변경 전

```
private List<Car> getCarsFromInput() {
        try {
            return input.getCarNames().stream()
                    .map(Car::new)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            output.printError(e.getMessage());
            return getCarsFromInput();
        }
    }
```

### 변경 후

```
    private List<Car> getCarsFromUI() {
        try {
            return makeCarsByName(getCarsNameFromConsole());
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return getCarsFromUI();
        }
    }
```

## RacingGameManager 내의 메서드를 하나의 일만 하도록 변경

## 매직넘버 전체 제거

    -   매직넘버라 판된되는 모든 숫자들을 상수로 처리하였습니다.

## 시도 횟수를 받을 시 숫자가 아닐 경우 IllegalArgument 예외를 적절한 메시지와 함께 발생시킴

    - 기존에는 NumberFormatError가 발생할 경우 시스템이 종료되었지만 try-catch문으로 예외를 핸들링 해주었습니다.
