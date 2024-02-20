# java-racingcar

자동차 경주 미션 저장소

## 기능 요구사항

-[x] 자동차의 이름들을 입력받는다.
    -[x] 이름은 ","를 기준으로 구분짓는다.
    -[x] 중복을 허용한다.
    -[x] 각 차량의 이름은 최소 1글자, 최대 5글자까지 가능하며, ","를 제외한 모든 문자를 허용한다.


-[x] 전진 횟수를 입력받는다.
    -[x] 음이아닌 정수만 가능하다.


-[x] 입력된 전진 횟수만큼 모든 자동차를 전진시킨다.
    -[x] 전진하는 조건은 0에서 9 사이의 random 값을 구한 후 random 값이 4 이상일 경우 전진, 3 이하의 값이면 멈춘다.


-[x] 전진이 끝나면 우승자를 출력한다.
    -[x] 가장 많이 이동한 차량들을 우승자로 한다.

## 기능 구현사항

### domain

- Car
    - 차량 이름(CarName), 위치(CarLocation), 이동 방법(MovingStrategy)으로 구성되어 있음.
    - `move()` : MovingStrategy의 `canMove()`가 true를 반환하면 위치를 1 증가시킨다.


- CarName
    - 생성자에서 입력된 이름 글자에 대한 유효성을 검증한다.


- CarLocation
    - 생성자에서 입력된 위치값에 대한 유효성을 검증한다.
    - `increaseLocation()`: 실행 시 위치를 1 증가시킨다


- strategy.MovingStrategy
    - 인터페이스로 정의되었으며, `canMove()`를 통해 차량의 이동 여부를 결정한다.


- strategy.RandomNumberMovingStrategy
    - MovingStrategy의 구현 클래스
    - `Randoms`로 부터 생성한 랜덤 숫자를 `isGraterThanMovingNumber()`에 넣어 4 이상인지를 판단한다.


- Cars
    - 자동차 리스트의 일급 컬렉션
    - `moveAll()` : 리스트 안의 모든 자동차를 1회 전진시킨다.
    - `getCurrentLocations()` : 자동차 이름과 전진 횟수로 이루어진 Map을 반환한다.
    - `getLargestLocation()` : 가장 멀리 이동한 차량의 위치를 반환한다.
    - `getLargestLocationCarsName()` : 가장 멀리 이동한 차량들의 이름을 반환한다.

### view

- InputView
    - 게임의 입력을 받으며, 유효하지 않은 입력인 경우 예외를 발생시킨다.
- OutputView
    - 게임과 관련된 출력을 담당한다.

### controller

- RacingGame
    - domain과 view를 이용하여 게임을 진행한다.
    - 진행 과정
        1. 자동차 이름을 입력받고 검증한다.
        2. 자동차 이동 횟수를 입력받고 검증한다.
        3. 입력된 이름과 필드의 MovingStrategy를 이용하여 Cars 객체를 생성한다.
        4. 입력된 이동 횟수만큼 모든 차량을 전진시키며, 매 전진이 끝날 때 마다 현재 진행 상황을 출력한다.
        5. 경주가 끝나면, 우승자를 출력한다.

### utils

- Randoms
    - `getRandomNumber()` : 0부터 입력된 숫자까지의 랜덤 정수를 반환한다.

## 예외 처리 사항

- view.InputView
    - `receiveNames()`, `receiveTrialCount()` : 정규표현식을 이용하여, 차량 이름 및 이동 횟수의 형식을 검증하고 올바르지 않으면 예외 발생


- domain.CarName
    - 생성자에서 검증하며, 이름의 길이가 0일 경우 혹은 5 초과일 경우 예외 발생


- domain.CarLocation
    - 생성자에서 검증하며, 위치가 음수일 경우는 예외 발생


- domain.strategy.RandomNumberMovingStrategy
    - private인 `isGreaterThanMovingNumber()`에서 입력된 숫자가 0에서 9가 아닌 경우 예외 발생

## 예외 발생시 콘솔 출력 예시

    경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
    a,,b
    [ERROR] 입력 형식이 올바르지 않습니다.
    경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
    a,abcdefg,h
    [ERROR] 입력 형식이 올바르지 않습니다.
    경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
    a,b
    시도할 회수는 몇회인가요?
    -1
    [ERROR] 입력 형식이 올바르지 않습니다.
    시도할 회수는 몇회인가요?
    a
    [ERROR] 입력 형식이 올바르지 않습니다.
    시도할 회수는 몇회인가요?
    3
    
    실행 결과
    a : -
    b : -
    
    a : -
    b : --
    
    a : --
    b : ---
    
    b가 최종 우승했습니다.

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
