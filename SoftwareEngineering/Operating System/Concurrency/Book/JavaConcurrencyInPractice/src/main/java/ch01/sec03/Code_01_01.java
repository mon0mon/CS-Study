package ch01.sec03;

import net.jcip.annotations.NotThreadSafe;

/**
 * 1.3.1 안정성 위해 요소
 * 예제 1.1 스레드 안전하지 않은 일련번호 생성 프로그램
 *
 * pg.35
 */
@NotThreadSafe
public class Code_01_01 {
    private int value;

    /** 유일한 값을 리턴 */
    public int getNext() {
        /**
         * 변수 값을 1 증가시키는 하나의 연산 같지만,
         * 내부적으로는 별도의 3개의 연산으로 구성되어있음
         *      - 읽기
         *      - 읽은 값에서 1 더하기
         *      - 쓰기
         *
         * 위 과정에서 연산간 간섭이 발생할 수 있음
         */
        return value++;
    }
}
