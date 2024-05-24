package lotto.domain;

public enum LottoPrize {
    THREE_MATCHES(3, 5_000),
    FOUR_MATCHES(4, 50_000),
    FIVE_MATCHES(5, 1_500_000),
    SIX_MATCHES(6, 2_000_000_000);

    private final int matches;
    private final int prize;

    LottoPrize(int matches, int prize) {
        this.matches = matches;
        this.prize = prize;
    }

    public int getMatches() {
        return matches;
    }

    public int getPrize() {
        return prize;
    }
}
