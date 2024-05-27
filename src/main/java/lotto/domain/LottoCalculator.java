package lotto.domain;

import java.util.List;

public class LottoCalculator {
    private static final int SECOND_MATCHED_COUNT = 5;

    /**
     * 전달받은 수 만큼 맞은 로또의 개수를 반환합니다.
     *
     * @param result 로또 티켓의 결과 목록
     * @param checkedCount 확인할 맞춘 개수
     * @param isSecondCheck 2등 인지 확인 여부
     * @return int
     * */
    public int getCountOfWin(List<LottoResult> result, int checkedCount, boolean isSecondCheck) {
        return (int) result
                .stream()
                .filter(lottoResult -> checkWhole(lottoResult, checkedCount, isSecondCheck))
                .count();
    }

    /**
     * 로또 티켓을 확인 합니다.
     *
     * @param result 로또 티켓의 결과 목록
     * @param checkedCount 확인할 맞춘 개수
     * @param isSecondCheck 2등 인지 확인 여부
     * @return boolean
     * */
    private boolean checkWhole(LottoResult result, int checkedCount, boolean isSecondCheck) {
        if (checkedCount == SECOND_MATCHED_COUNT) {
            return this.checkSecond(result, checkedCount, isSecondCheck);
        }

        return result.getWinningCount() == checkedCount;
    }

    /**
     * 로또 티켓의 2등을 확인합니다.
     *
     * @param result 로또 티켓의 결과 목록
     * @param checkedCount 확인할 맞춘 개수
     * @param isSecondCheck 2등 인지 확인 여부
     * @return boolean
     * */
    private boolean checkSecond(LottoResult result, int checkedCount, boolean isSecondCheck) {
        if (isSecondCheck) {
            return result.getIsWonBonusNumber() && result.getWinningCount() == checkedCount;
        }

        return !result.getIsWonBonusNumber() && result.getWinningCount() == checkedCount;
    }

    /**
     * 당첨금을 계산하여 반환 합니다.
     *
     * @param results 로또 결과 객체
     * @return int
     * */
    public int getPrizeMoney(List<LottoResult> results) {
        int prizeMoney = 0;

        for (LottoPrize prize : LottoPrize.values()) {
            prizeMoney += prize.getPrize() * this.getCountOfWin(results, prize.getMatches(), prize.getIsWonBonusNumber());
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
