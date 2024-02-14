# java-racingcar
자동차 경주 미션 저장소
## 우아한테크코스 코드리뷰
- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)
## 기능 명세서
### 입력
- [x] 자동차 이름을 입력받는 기능
  - [ ] 쉼표를 기준으로 구분
- [x] 시도횟수를 입력받는 기능
### 출력
- [ ] 단순 텍스트 출력
  - [ ] `경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).`
  - [ ] `시도할 회수는 몇회인가요?`
  - [ ] `실행 결과`
- [ ] 각 라운드 별 레이싱 결과 출력
  - [ ] `name : ---` 형식으로 출력
- [ ] 우승자 출력
  - [ ] 우승자 목록 : 우승자들을 콤마로 Join 하여 String화
  - [ ] `(우승자 목록)가 최종 우승했습니다.` 형식으로 출력
### 비즈니스 로직
- [ ] 전진 여부를 판단하는 기능
  - [ ] 랜덤 값 추출
  - [ ] 랜덤 값이 4 이상이면 true, 아니면 false 반환
- [ ] 자동차 전진 기능
- [ ] 우승자 판단 기능
  - [ ] 전체 자동차 전진 횟수 중 최대값 산출 기능
  - [ ] 최대값과 일치하는 자동차들을 리스트에 담는 기능
### 검증
- [ ] 자동차 이름 유효성 판단 기능
  - [x] 5자 이상 이름이 들어왔을 때 > 예외발생
  - [x] 알파벳 이외의 문자로 이름이 구성되었을 때 > 예외발생
  - [ ] 중복된 이름이 입력되었을 때 > 예외발생
- [ ] 자동차 대수 유효성 판단 기능
  - [ ] 차량은 1-100대까지만 허용한다
- [ ] 시도 횟수 유효성 판단 기능
  - [ ] 시도 횟수는 1-100회까지만 허용한다
## 프로그램 흐름
1. 입력
    - `경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)` 출력
    - 자동차 이름 입력
    - `시도할 회수는 몇회인가요?` 출력
    - 시도 횟수 입력
2. 자동차 경주 시작
    - `실행 결과` 출력
    - n회 반복
        - 전진 여부 결정(자동차 대수만큼 반복)
            - 0에서 9 사이에서 random 값 구하기
            - random 값이 4 이상이면 전진, 3 이하면 멈춤
        - 각각의 실행 결과 출력(자동차 대수만큼 반복)
            - 자동차 이름 : 전진횟수 출력
            - 출력 예시
          ```
            pobi : -
            crong : -
            honux : -
            ```
3. 우승자 출력
    - 우승자 판정
        - 전진 횟수가 가장 많은 차(1대 이상)
    - `(우승자 목록)가 최종 우승했습니다.` 출력
    - 예) `pobi, honux가 최종 우승했습니다.`