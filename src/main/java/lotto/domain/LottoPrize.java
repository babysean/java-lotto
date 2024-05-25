package lotto.domain;

public enum LottoPrize {
    THREE_MATCHES(3, false, 5_000),
    FOUR_MATCHES(4, false, 50_000),
    FIVE_MATCHES(5, false, 1_500_000),
    FIVE_AND_BONUS_MATCHES(5, true, 30_000_000),
    SIX_MATCHES(6, false, 2_000_000_000);

    private final int matches;
    private final boolean bonusNumber;
    private final int prize;

    LottoPrize(int matches, boolean bonusNumber, int prize) {
        this.matches = matches;
        this.bonusNumber = bonusNumber;
        this.prize = prize;
    }

    public int getMatches() {
        return matches;
    }

    public int getPrize() {
        return prize;
    }

    public boolean getBonusNumber() {
        return bonusNumber;
    }
}
