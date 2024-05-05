package lotto.domain;

import java.util.*;

public class LottoCalculator {
    /** 맞춘 개수 */
    private final List<Integer> winningCounts;

    /** 로또 구매 금액 */
    private final int purchaseMoney;

    /**
     * 맞춘 로또의 개수를 구합니다.
     *
     * @author 박상훈
     * @param purchasedNumbers 구매한 로또 번호 목록
     * @param winningNumbers 지난 주 당첨 로또 번호
     * @param purchaseMoney 로또 구매 금액
     */
    public LottoCalculator(List<List<Integer>> purchasedNumbers, List<Integer> winningNumbers, int purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
        this.winningCounts = new ArrayList<>();

        Set<Integer> winningNumber = new HashSet<>(winningNumbers);

        for (List<Integer> purchase : purchasedNumbers) {
            Set<Integer> intersection = new HashSet<>(purchase);

            // 비교하여 같은 숫자만 남깁니다.
            intersection.retainAll(winningNumber);

            winningCounts.add(intersection.size());
        }
    }

    /**
     * 전달받은 정수만큼 맞은 로또의 개수를 반환합니다.
     *
     * @author 박상훈
     * @param wonCount 맞은 정수
     * @return int
     * */
    public int getCountOfWins(int wonCount) {
        return (int) winningCounts
                .stream()
                .filter(count -> count == wonCount)
                .count();
    }

    /**
     * 수익률을 계산하여 반환합니다.
     *
     * @author 박상훈
     * @return Double
     * */
    public Double getRateOfReturn() {
        int winningPrice = LottoPrize.THREE_MATCHES.getPrize() * getCountOfWins(LottoPrize.THREE_MATCHES.getMatches()) +
                LottoPrize.FOUR_MATCHES.getPrize() * getCountOfWins(LottoPrize.FOUR_MATCHES.getMatches()) +
                LottoPrize.FIVE_MATCHES.getPrize() * getCountOfWins(LottoPrize.FIVE_MATCHES.getMatches()) +
                LottoPrize.SIX_MATCHES.getPrize() * getCountOfWins(LottoPrize.SIX_MATCHES.getMatches());

        double rateOfReturn = (double) winningPrice / (double) this.purchaseMoney;

        return Math.floor(rateOfReturn * 1000) / 1000;
    }
}
