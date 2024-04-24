package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {

    @Test
    @DisplayName("중복이_없는_6개의_난수를_생성합니다")
    void 중복이_없는_6개의_난수를_생성합니다() {
        // given
        List<Integer> numberList = new ArrayList<>();

        for (int i = 1 ; i <= 45 ; i++) {
            numberList.add(i);
        }

        Collections.shuffle(numberList);

        // when
        List<Integer> randomNumbers = numberList.subList(0, 6);

        // then
        assertThat(randomNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("전달받은_금액으로_살_수_있는_로또의_개수를_반환합니다")
    void 전달받은_금액으로_살_수_있는_로또의_개수를_반환합니다() {
        // given
        final int LOTTO_PRICE = 1000;
        int money = 500;

        // when
        int count = money / LOTTO_PRICE;

        // then
        assertThat(count).isEqualTo(0);
    }

    @Test
    @DisplayName("두_정수_배열의_일치하는_정수의_개수를_반환합니다")
    void 두_정수_배열의_일치하는_정수의_개수를_반환합니다() {
        // given
        Integer[] lottoNumbers = {1, 2, 3, 4, 5, 6};
        Integer[] lastWeeklottoNumbers = {2, 3, 4, 5, 6, 7};

        Set<Integer> matchingNumbers = new HashSet<>(Arrays.asList(lottoNumbers));
        Set<Integer> lastWeekMatchingNumbers = new HashSet<>(Arrays.asList(lastWeeklottoNumbers));

        // when
        matchingNumbers.retainAll(lastWeekMatchingNumbers);

        // then
        assertThat(matchingNumbers.size()).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6, ", "1, 2, 3, 4, 5, 6", "1,2,3,4,5,6", "    1,2   ,3,4,5       ,6"})
    @DisplayName("String으로_전달받은_숫자를_List으로_변환합니다")
    void String으로_전달받은_숫자를_List으로_변환합니다(String numbers) {
        // given
        numbers = numbers.replace(" ", "");
        List<Integer> lottoNumbers = new ArrayList<>();

        // when
        for (String number : numbers.split(",")) {
            lottoNumbers.add(Integer.parseInt(number));
        }

        // then
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("정수_LIST_에서_숫자에_맞는_값의_개수를_반환합니다")
    void 정수_LIST_에서_숫자에_맞는_값의_개수를_반환합니다() {
        // given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 3, 6);
        int number = 3;

        // when
        int count = (int) lottoNumbers.stream().filter(n -> n == number).count();

        // then
        assertThat(count).isEqualTo(2);
    }

}