# java-racingcar
자동차 경주 게임 미션 저장소

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 기능구현 목록

- 자동차 이름을 입력받는 기능
    - 자동차 이름은 5글자 이하이다.
    - 자동차 이름에 특수문자가 포함되면 안된다.
    - 자동차 이름에 공백이나 null은 허용하지 않는다.
    - 자동차 이름은 중복되면 안된다.
- 시도횟수를 입력받는 기능
    - 시도횟수는 최소 1이상이다.
    - 시도횟수에 공백이나 null은 허용하지 않는다.
    - 시도횟수는 숫자만 입력 가능하다.
- 자동차가 전진 또는 멈추는 기능
    - 0부터 9사이의 Random 값을 생성하고 4 이상일 시 전진한다.
- 주어진 횟수만큼 자동차 경주를 실행하는 기능
- 자동차의 현재 위치를 출력하는 기능
- 우승자를 찾는 기능
- 최종 우승자를 출력하는 기능

## Commit Message Convention
> 커밋 메시지 컨벤션은 아래의 규약을 따른다.
[Git - Commit Message Convention](https://rok93.tistory.com/entry/Git-Commit-Message-Convention)

## 짝 프로그래밍 규칙(Pair Programming Convention)
* 철저히 기능단위로 Driver와 Navigator를 번갈아가며 진행한다.
* code with me와 slack의 통화기능을 활용하여 소통한다.