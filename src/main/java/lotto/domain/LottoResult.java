package lotto.domain;

public class LottoResult {
    private final int winningCount;

    private final boolean isWonBonusNumber;

    public LottoResult(int winningCount, boolean isWonBonusNumber) {
        this.winningCount = winningCount;
        this.isWonBonusNumber = isWonBonusNumber;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public boolean getIsWonBonusNumber() {
        return isWonBonusNumber;
    }
}
