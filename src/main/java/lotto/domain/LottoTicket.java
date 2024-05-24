package lotto.domain;

import java.util.List;

/**
 * 로또 티켓을 관리하는 클래스 입니다.
 * */
public class LottoTicket {
    /** 로또 가격 */
    public static final int LOTTO_PRICE = 1000;

    /** 로또 번호 */
    private final List<Integer> numbers;

    /** 보너스 번호 */
    private int bonusNumber = 0;

    public LottoTicket(List<Integer> numbers, int bonusNumber) {
        this(numbers);
        this.bonusNumber = bonusNumber;
    }

    public LottoTicket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    /**
     * 로또 티켓을 반환 합니다.
     *
     * @return List<Integer>
     * */
    public List<Integer> get() {
        return numbers;
    }

    /**
     * 보너스 번호를 반환 합니다.
     *
     * @return int
     * */
    public int getBonusNumber() {
        return bonusNumber;
    }
}
