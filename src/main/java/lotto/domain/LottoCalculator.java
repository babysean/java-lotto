package lotto.domain;

import java.util.*;
import java.util.ArrayList;

public class LottoCalculator {
    /**
     * 전달받은 수 만큼 맞은 로또의 개수를 반환합니다.
     *
     * @param matchingCounts 일치하는 숫자의 개수 목록
     * @param checkNumber 확인할 개수
     * @return int
     * */
    public int getCountOfWin(List<Integer> matchingCounts, double checkNumber) {
        return (int) matchingCounts
                .stream()
                .filter(count -> Double.compare(count, checkNumber) == 0)
                .count();
    }

    /**
     * 당첨금을 계산하여 반환 합니다.
     *
     * @param matchingCounts 일치하는 숫자의 개수 목록
     * @return int
     * */
    public int getPrizeMoney(List<Integer> matchingCounts) {
        int prizeMoney = 0;

        for (LottoPrize prize : LottoPrize.values()) {
            prizeMoney += prize.getPrize() * this.getCountOfWin(matchingCounts, prize.getMatches());
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
