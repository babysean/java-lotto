package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class PurchasedNumbersTest {
    @Test
    @DisplayName("전달받은_금액으로_살_수_있는_로또의_개수를_반환합니다")
    void 전달받은_금액으로_살_수_있는_로또의_개수를_반환합니다() {
        // given
        LottoPurchase lottoPurchase =  new LottoPurchase(new PurchasedNumbers(), 2000);

        // when
        PurchasedNumbers purchasedNumbers = lottoPurchase.getPurchasedNumbers();
        List<List<Integer>> lottoNumbers = purchasedNumbers.getNumbers();

        // then
        assertThat(lottoNumbers).hasSize(2);
    }
}
