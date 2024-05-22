package lotto.domain;

public enum LottoPrize {
    THREE_MATCHES(3.0, 5_000),
    FOUR_MATCHES(4.0, 50_000),
    FIVE_MATCHES(5.0, 1_500_000),
    FIVE_AND_BONUS_MATCHES(5.1, 30_000_000),
    SIX_MATCHES(6.0, 2_000_000_000);

    private final double matches;
    private final int prize;

    LottoPrize(double matches, int prize) {
        this.matches = matches;
        this.prize = prize;
    }

    public double getMatches() {
        return matches;
    }

    public int getPrize() {
        return prize;
    }
}
