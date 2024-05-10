package lotto.domain;

import java.util.List;

/**
 * 로또 티켓을 관리하는 클래스 입니다.
 * */
public class LottoTicket {
    /** 구매한 로또 번호 */
    private final List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    /**
     * 로또 번호를 티켓에 저장합니다.
     *
     * @param number 로또 숫자
     * */
    public void add(int number) {
        numbers.add(number);
    }

    /**
     * 로또 티켓을 반환 합니다.
     *
     * @return List<Integer>
     * */
    public List<Integer> get() {
        return numbers;
    }

}
