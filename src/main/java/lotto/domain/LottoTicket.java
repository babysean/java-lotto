package lotto.domain;

import java.util.*;

/**
 * 로또 티켓을 관리하는 클래스 입니다.
 * */
public class LottoTicket {
    /** 로또 가격 */
    public static final int LOTTO_PRICE = 1000;

    /** 로또 번호 */
    private final List<Integer> numbers;

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
     * 맞춘 결과를 반환 합니다.
     *
     * @param winningNumber 당첨된 로또 티켓
     * @param bonusNumber 보너스 번호
     * @return int
     * */
    public LottoResult win(LottoTicket winningNumber, int bonusNumber) {
        Set<Integer> intersection = new HashSet<>(numbers);
        intersection.retainAll(winningNumber.get());

        int winningCount = intersection.size();

        int winningBonusNumberCount = (int) numbers.stream()
                .filter(n -> n == bonusNumber)
                .count();

        boolean isWonBonusNumber = 1 == winningBonusNumberCount;

        return new LottoResult(winningCount, isWonBonusNumber);
    }
}
