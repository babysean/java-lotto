package lotto;

import lotto.domain.PurchasedNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class PlayLotto {
    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        InputView inputView = new InputView();
        PurchasedNumbers purchasedNumbers = new PurchasedNumbers();

        LottoService lottoService = new LottoService(inputView, resultView, purchasedNumbers);
        lottoService.run();
    }
}
