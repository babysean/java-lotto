package lotto.domain;

import java.util.List;

public class LottoCalculator {
    /**
     * 전달받은 수 만큼 맞은 로또의 개수를 반환합니다.
     *
     * @param prizes 로또 티켓의 결과 목록
     * @param checkedPrize 확인할 로또 티켓
     * @return int
     * */
    public int getCountOfWin(List<LottoPrize> prizes, LottoPrize checkedPrize) {
        return (int) prizes
                .stream()
                .filter(prize -> LottoPrize.isMatched(prize, checkedPrize.getMatches(), checkedPrize.getIsWonBonusNumber()))
                .count();
    }

    /**
     * 당첨금을 계산하여 반환 합니다.
     *
     * @param prizes 로또 결과 객체
     * @return int
     * */
    public int getPrizeMoney(List<LottoPrize> prizes) {
        int prizeMoney = 0;

        for (LottoPrize prize : prizes) {
            prizeMoney += prize.getPrize();
        }

        return prizeMoney;
    }

    /**
     * 로또 수익률을 계산하여 반환 합니다.
     *
     * @param prizeMoney 당첨금
     * @param money 로또 구매 금액
     * @return double
     * */
    public double getProfit(int prizeMoney, int money) {
        double rateOfReturn = (double) prizeMoney / (double) money;

        return Math.floor(rateOfReturn * 1000) / 1000;
    }
}
