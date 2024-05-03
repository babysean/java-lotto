package lotto.domain;

public enum LottoPrize {
    THREE_MATCHES(3, 5000),
    FOUR_MATCHES(4, 50000),
    FIVE_MATCHES(5, 1500000),
    SIX_MATCHES(6, 2000000000);

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
