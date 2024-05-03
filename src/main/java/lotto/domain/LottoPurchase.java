package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.service.LottoService.LOTTO_PRICE;

public class LottoPurchase {
    /** 구매한 로또 번호 목록 */
    private List<List<Integer>> purchasedNumbers = new ArrayList<>();

    /**
     * 로또를 구매합니다.
     *
     * @param amount 구매할 금액
     * */
    public LottoPurchase(int amount) {
        int purchaseCount = amount / LOTTO_PRICE;
        LottoNumberGenerator generator = new LottoNumberGenerator();

        for (int i = 0 ; i < purchaseCount ; i++) {
            purchasedNumbers.add(generator.generate());
        }
    }

    /**
     * 구매한 로또 번호의 목록을 반환합니다.
     *
     * @author 박상훈
     * @return List<List<Integer>>
     * */
    public List<List<Integer>> getPurchasedNumbers() {
        return purchasedNumbers;
    }
}
