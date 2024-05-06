package lotto.domain;

import static lotto.service.LottoService.LOTTO_PRICE;

public class LottoPurchase {
    /** 구매한 로또 번호 목록 */
    private final PurchasedNumbers purchasedNumbers;

    /**
     * 로또를 구매합니다.
     *
     * @param amount 구매할 금액
     * */
    public LottoPurchase(PurchasedNumbers purchasedNumbers, int amount) {
        int purchaseCount = amount / LOTTO_PRICE;

        LottoNumberGenerator generator = new LottoNumberGenerator();
        this.purchasedNumbers = purchasedNumbers;

        for (int i = 0 ; i < purchaseCount ; i++) {
            purchasedNumbers.addNumber(generator.generate());
        }
    }

    public PurchasedNumbers getPurchasedNumbers() {
        return purchasedNumbers;
    }
}
