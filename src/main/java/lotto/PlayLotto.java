package lotto;

public class PlayLotto {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Integer money = inputView.insertMoney();

        Lotto lotto = new Lotto(money);

        resultView.printPurchaseInfo(lotto);

        String winningNumbers = inputView.insertLastWeekWinningNumber();

        lotto.getWinningCount(winningNumbers);

        resultView.printResult(lotto);
    }
}