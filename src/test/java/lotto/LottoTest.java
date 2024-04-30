package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {

    @Test
    @DisplayName("구매_금액은_1000_과_같거나_커야_합니다")
    void 구매_금액은_1000_과_같거나_커야_합니다() {
        // given
        Integer money = 1000;

        // when & then
        assertThat(money).isGreaterThanOrEqualTo(1000);
    }

    @Test
    @DisplayName("구매_금액은_숫자만_입력할_수_있습니다")
    void 구매_금액은_숫자만_입력할_수_있습니다() {
        // given
        String money = "1000";

        // when & then
        assertThat(money).matches("\\d+");
    }

    @Test
    @DisplayName("당첨번호는_콤마로_구분된_6개_정수_입니다")
    void 당첨번호는_콤마로_구분된_6개_정수_입니다() {
        // given
        String winningNumbers = "1,2,3 ,4,5,6";
        winningNumbers = winningNumbers.replace(" ", "");

        // when & then
        assertThat(winningNumbers).matches("\\d+,\\d+,\\d+,\\d+,\\d+,\\d+");
    }

    @Test
    @DisplayName("각_당첨번호는_1과_45_사이의_정수_입니다")
    void 각_당첨번호는_1과_45_사이의_정수_입니다() {
        // given
        String winningNumbers = "1,2,3,4,5,45";
        String[] winningNumber = winningNumbers
                .replace(" ", "")
                .split(",");

        // when
        boolean result = Arrays
                .stream(winningNumber)
                .mapToInt(Integer::parseInt)
                .allMatch(number -> number >= 1 && number <= 45);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("당첨번호에는_중복된_번호가_없어야_합니다")
    void 당첨번호에는_중복된_번호가_없어야_합니다() {
        // given
        String winningNumber = "1,2,3,4,5,45";
        String[] winningNumbers = winningNumber
                .replace(" ", "")
                .split(",");

        // when
        long count = Arrays.stream(winningNumbers)
                .mapToInt(Integer::parseInt)
                .distinct()
                .count();

        // then
        assertThat(count).isEqualTo(6);
    }

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
        int money = 1500;

        // when
        int count = money / LOTTO_PRICE;

        // then
        assertThat(count).isEqualTo(1);
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
    @DisplayName("정수_6개로_이루어진_문자열인지_확인합니다")
    void 정수_6개로_이루어진_문자열인지_확인합니다(String numbers) {
        // given
        numbers = numbers.replace(" ", "");
        List<Integer> lottoNumbers;

        // when
        lottoNumbers = Arrays.stream(numbers.replace(" ", "").split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // then
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("정수_리스트에서_특정_숫자에_맞는_값의_개수를_반환합니다")
    void 정수_리스트에서_특정_숫자에_맞는_값의_개수를_반환합니다() {
        // given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 3, 6);
        int number = 3;

        // when
        int count = (int) lottoNumbers.stream().filter(n -> n == number).count();

        // then
        assertThat(count).isEqualTo(2);
    }
}
