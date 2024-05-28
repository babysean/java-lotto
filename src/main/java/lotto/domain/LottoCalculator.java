package lotto.domain;

import java.util.List;

public class LottoCalculator {
    /**
     * 전달받은 수 만큼 맞은 로또의 개수를 반환합니다.
     *
     * @param prizes 로또 티켓의 결과 목록
     * @param checkedCount 확인할 맞춘 개수
     * @param isWonBonusNumber 보너스 번호를 맞췄는지 여부
     * @return int
     * */
    public int getCountOfWin(List<LottoPrize> prizes, int checkedCount, boolean isWonBonusNumber) {
        return (int) prizes
                .stream()
                .filter(prize -> LottoPrize.isMatched(prize, checkedCount, isWonBonusNumber))
                .count();
    }

    /**
     * 당첨금을 계산하여 반환 합니다.
     *
     * @param results 로또 결과 객체
     * @return int
     * */
    public int getPrizeMoney(List<LottoPrize> results) {
        int prizeMoney = 0;

        for (LottoPrize prize : results) {
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
