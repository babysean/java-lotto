package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

public class PlayLotto {
    public static void main(String[] args) {
        try {
            InputView inputView = new InputView();
            ResultView resultView = new ResultView();

            // 구매할 금액 입력
            Integer money = inputView.insertMoney();

            Lotto lotto = new Lotto(money);

            // 구매한 개수 및 구매 번호 출력
            resultView.printPurchaseInfo(lotto);

            // 지난 주 당첨 번호 입력
            String winningNumbers = inputView.insertLastWeekWinningNumber();

            // 지난 주 당첨 번호 유효성 검사
            lotto.checkValidation(winningNumbers);

            // 로또 계산
            lotto.calculateLotto(winningNumbers);

            resultView.printResult(lotto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
