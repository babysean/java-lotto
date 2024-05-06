package lotto.service;

import lotto.domain.LottoCalculator;
import lotto.domain.LottoPurchase;
import lotto.domain.PurchasedNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    /** 로또 가격 */
    public static final int LOTTO_PRICE = 1000;

    /** 로또 개수 */
    public static final int LOTTO_COUNT = 6;

    /** 로또 범위 */
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private final InputView inputView;
    private final ResultView resultView;
    private final PurchasedNumbers purchasedNumbers;

    public LottoService(InputView inputView, ResultView resultView, PurchasedNumbers purchasedNumbers) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.purchasedNumbers = purchasedNumbers;
    }

    public void run() {
        try {
            // 구매할 금액 입력
            int purchaseMoney = inputView.insertMoney();

            // 로또 구매하기
            LottoPurchase lottoPurchase = new LottoPurchase(purchasedNumbers, purchaseMoney);
            PurchasedNumbers purchasedNumbers = lottoPurchase.getPurchasedNumbers();

            // 구매한 개수 및 번호 출력
            resultView.printPurchaseInfo(purchasedNumbers);

            // 지난 주 당첨 번호 입력
            List<Integer> winningNumbers = inputView.insertLastWeekWinningNumber();

            // 로또 계산
            LottoCalculator lottoCalculator = new LottoCalculator(purchasedNumbers, winningNumbers, purchaseMoney);

            // 로또 결과 출력
            resultView.printResult(lottoCalculator);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
