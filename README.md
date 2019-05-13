# java-racingcar
자동차 경주 게임 미션 저장소

## 기능목록

### controller
레이싱게임
- 게임실행 (횟수, 차들)
- // 특정수 받고서 ... 조건맞는 인덱스 알아내기

### domain
차  
- 움직인다
- 이름을 알려준다
- 현재 상태 알려준다

### view
입력 
- 숫자를 받는다
    -[ ] 올바른 입력일 때까지 입력 받기 (숫자)
- 차 이름들을 받는다 // 어디서 처리할지
    -[ ] 올바른 입력일 때까지 입력 받기 (이름이 5글자 이하인지, ','로 나눠져있는지)

출력 
- 실행 결과 출력
- 각 스테이지의 차의 상태 출력 (cars)
- 최종 우승자 출력

### 유틸
이동 전략 (moveStrategy)
- 9 사이에 랜덤값을 구한 후 해당 값이 4 이상일 경우에 참

맥스파인더
- 맥스값인 애들을 알려준다





main 

controller
- game

view
- input view
- output view
domain
- car 

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)