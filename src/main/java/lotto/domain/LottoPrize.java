package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    THREE_MATCHES(3, false, 5_000),
    FOUR_MATCHES(4, false, 50_000),
    FIVE_MATCHES(5, false, 1_500_000),
    FIVE_AND_BONUS_MATCHES(5, true, 30_000_000),
    SIX_MATCHES(6, false, 2_000_000_000);

    private final int matches;
    private final boolean isWonBonusNumber;
    private final int prize;
    private static final int SECOND_MATCHED_COUNT = 5;

    LottoPrize(int matches, boolean bonusNumber, int prize) {
        this.matches = matches;
        this.isWonBonusNumber = bonusNumber;
        this.prize = prize;
    }

    public int getMatches() {
        return matches;
    }

    public int getPrize() {
        return prize;
    }

    public boolean getIsWonBonusNumber() {
        return isWonBonusNumber;
    }

    /**
     * matches 와 bonus 에 맞는 값을 반환 합니다.
     *
     * @param matches 맞춘 개수
     * @param isWonBonusNumber 보너스 번호 맞춘 여부
     * @return LottoPrize
     * */
    public static LottoPrize findByMatchesAndBonus(int matches, boolean isWonBonusNumber) {
        return Arrays.stream(values())
                .filter(prize -> isMatched(prize, matches, isWonBonusNumber))
                .findFirst()
                .orElse(null);
    }

    /**
     * 로또 티켓을 확인 합니다.
     *
     * @param prize 로또 티켓의 결과 목록
     * @param checkedCount 확인할 맞춘 개수
     * @param isSecondCheck 2등 인지 확인 여부
     * @return boolean
     * */
    public static boolean isMatched(LottoPrize prize, int checkedCount, boolean isSecondCheck) {
        if (checkedCount == SECOND_MATCHED_COUNT) {
            return checkSecond(prize, checkedCount, isSecondCheck);
        }

        return prize.getMatches() == checkedCount;
    }

    /**
     * 로또 티켓의 2등을 확인합니다.
     *
     * @param prize 로또 티켓의 결과 목록
     * @param checkedCount 확인할 맞춘 개수
     * @param isMatchedBonusNumber 보너스 번호 맞춘 여부
     * @return boolean
     * */
    private static boolean checkSecond(LottoPrize prize, int checkedCount, boolean isMatchedBonusNumber) {
        if (isMatchedBonusNumber) {
            return prize.getIsWonBonusNumber() && prize.getMatches() == checkedCount;
        }

        return !prize.getIsWonBonusNumber() && prize.getMatches() == checkedCount;
    }
}
