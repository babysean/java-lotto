package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    THREE_MATCHES(3, false, 5_000),
    THREE_AND_BONUS_MATCHES(3, true, 5_000),
    FOUR_MATCHES(4, false, 50_000),
    FOUR_AND_BONUS_MATCHES(4, true, 50_000),
    FIVE_MATCHES(5, false, 1_500_000),
    FIVE_AND_BONUS_MATCHES(5, true, 30_000_000),
    SIX_MATCHES(6, false, 2_000_000_000),
    SIX_AND_BONUS_MATCHES(6, true, 2_000_000_000);

    private final int matches;
    private final boolean isWonBonusNumber;
    private final int prize;

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
                .filter(prize -> prize.matches == matches && prize.isWonBonusNumber == isWonBonusNumber)
                .findFirst()
                .orElse(null);
    }
}
