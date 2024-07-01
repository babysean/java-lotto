package lotto.domain;

import static lotto.domain.LottoGenerator.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoGenerator.MIN_LOTTO_NUMBER;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 로또 번호의 유효성을 체크하는 클래스입니다.
 */
public class LottoValidator {

    /** 로또 티켓의 숫자 개수 */
    public static final int LOTTO_NUMBER_SIZE = 6;

    private static final String COMMA_SEPARATED_NUMBERS = "로또 번호는 콤마로 구분된 숫자 6개이어야 합니다.";
    private static final String AN_INTEGER_BETWEEN_1_AND_45 = "로또 번호는 1과 45 사이의 정수이어야 합니다.";
    private static final String NOT_DUPLICATE_NUMBERS = "로또 번호에 중복된 숫자가 없어야 합니다.";

    /**
     * 로또 번호에 대한 유효성을 확인 합니다.
     * <p>1. 번호가 6개 인지</p>
     * <p>2. 숫자로 되어있는지</p>
     * <p>3. 중복된 수가 없는지</p>
     *
     * @param numbers 지난 주 당첨 번호
     *
     * @throws IllegalArgumentException 로또 번호는 콤마로 구분된 숫자 6개이어야 합니다.
     * @throws IllegalArgumentException 각 당첨번호는 1과 45 사이의 정수이어야 합니다.
     * @throws IllegalArgumentException 로또 번호에 중복된 숫자가 없어야 합니다.
     */
    public void winningNumbersValidation(List<Integer> numbers) {
        // 숫자 개수 검사
        this.checkCorrectLottoFormat(numbers);

        // 범위 검사
        numbers.forEach(this::checkCorrectRange);

        // 중복 검사
        this.checkUniqueNumber(numbers);
    }

    /**
     * 보너스 번호의 유효성을 검사합니다.
     *
     * @param numbers     지난 주 당첨 번호
     * @param bonusNumber 보너스 번호
     *
     * @throws IllegalArgumentException 각 당첨번호는 1과 45 사이의 정수이어야 합니다.
     * @throws IllegalArgumentException 당첨번호에 중복된 숫자가 없어야 합니다.
     */
    public void bonusNumberValidation(List<Integer> numbers, int bonusNumber) {
        // 범위 검사
        this.checkCorrectRange(bonusNumber);

        // 중복 검사
        List<Integer> mergedNumbers = new ArrayList<>(numbers);
        mergedNumbers.add(bonusNumber);
        this.checkUniqueNumber(mergedNumbers);
    }

    /**
     * 로또 번호는 6개의 숫자이어야 합니다.
     *
     * @param numbers 로또 번호
     *
     * @throws IllegalArgumentException 로또 번호는 콤마로 구분된 숫자 6개이어야 합니다.
     */
    private void checkCorrectLottoFormat(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(COMMA_SEPARATED_NUMBERS);
        }
    }

    /**
     * 로또 번호가 1 ~ 45 사이의 수 인지 확인합니다.
     *
     * @param number 로또 번호
     *
     * @throws IllegalArgumentException 로또 번호는 1과 45 사이의 정수이어야 합니다.
     */
    private void checkCorrectRange(int number) {
        if (number > MAX_LOTTO_NUMBER || number < MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException(AN_INTEGER_BETWEEN_1_AND_45);
        }
    }

    /**
     * 중복된 번호가 없는지 확인합니다.
     *
     * @param numbers 로또 번호
     *
     * @throws IllegalArgumentException 로또 번호에 중복된 숫자가 없어야 합니다.
     */
    private void checkUniqueNumber(List<Integer> numbers) {
        int numberSize = new HashSet<>(numbers).size();

        if (numberSize != numbers.size()) {
            throw new IllegalArgumentException(NOT_DUPLICATE_NUMBERS);
        }
    }
}
