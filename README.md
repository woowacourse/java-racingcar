# java-racingcar
자동차 경주 게임 미션 저장소

## 기능 구현 목록

* 사용자 인터페이스
    * 자동차 이름 입력
        * 5자 이하
        * 이름에 공백이 들어간 경우
            * 앞 뒤에 붙은 공백은 제거
            * 공백 아닌 글자 사이의 공백은 이름으로 처리
    * 시도 횟수 입력
        * 1 이상인 정수여야 함
    * 실행 결과 출력
    * 우승자 출력
        * 우승자는 둘 이상일 수 있음
        * 둘 이상인 경우 이름을 ", "로 구분하여 출력
* 게임 진행
    * 난수 생성
        * 0 이상 9 이하인 난수 생성
    * 자동차의 전진 여부 결정
        * 4 이상인 경우 전진, 3 이하이면 멈춤(전진하지 않음)
    * 우승자 결정
        * 이동한 거리가 최대인 자동차가 우승 - 둘 이상일 수 있음