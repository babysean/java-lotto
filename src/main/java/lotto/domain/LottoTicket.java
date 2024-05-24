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

    /** 맞춘 개수 */
    private int winningCount;

    /** 보너스 번호 맞춘 여부 */
    private boolean isBonusNumberMatched;

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
     * 맞춘 개수를 입력 합니다.
     *
     * @param winningCount 맞춘 개수
     * */
    public void inputWinningCount(int winningCount) {

    }
}
