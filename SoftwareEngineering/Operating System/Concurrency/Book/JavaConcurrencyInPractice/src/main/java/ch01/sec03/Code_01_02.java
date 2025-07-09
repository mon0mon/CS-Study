package ch01.sec03;

import net.jcip.annotations.GuardedBy;

/**
 * 1.3.1 안정성 위해 요소
 * 예제 1.2 스레드 안전한 일련번호 생성 프로그램
 *
 * pg.37
 */
public class Code_01_02 {
    @GuardedBy("this") private int value;

    public synchronized int getNext() {
        return value++;
    }
}
