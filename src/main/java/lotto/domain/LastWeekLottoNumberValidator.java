package lotto.domain;

import java.util.Arrays;

import static lotto.service.LottoService.*;
import static lotto.service.LottoService.LOTTO_COUNT;

public class LastWeekLottoNumberValidator {
    /**
     * 지난 주 당첨 번호에 대한 유효성을 확인 합니다.
     * <p>1. 번호가 6개 인지</p>
     * <p>2. 숫자로 되어있는지</p>
     * <p>3. 중복된 수가 없는지</p>
     *
     * @author 박상훈
     * @param number 지난 주 당첨 번호
     * */
    public void validate(String[] number) {
        if (!isSizeCorrect(number)) {
            throw new IllegalArgumentException("당첨번호는 콤마로 구분된 숫자 6개이어야 합니다.");
        }

        if (!isNumberCorrect(number)) {
            throw new IllegalArgumentException("각 당첨번호는 1과 45 사이의 정수이어야 합니다.");
        }

        if (!isNumberUnique(number)) {
            throw new IllegalArgumentException("당첨번호에 중복된 숫자가 없어야 합니다.");
        }
    }

    /**
     * 지난 주 당첨 번호가 ,로 구분된 6개의 숫자인지 확인합니다.
     * 6개 이면 true, 아니면 false 를 반환합니다.
     *
     * @author 박상훈
     * @param number 지난 주 당첨 번호
     * @return boolean
     */
    private boolean isSizeCorrect(String[] number) {
        return number.length == LOTTO_COUNT;
    }

    /**
     * 지난 주 당첨 번호가 로또 번호가 맞는지 확인합니다.
     * 각 번호는 1 ~ 45사이의 수 입니다.
     * 6개의 번호가 이를 만족하면 true, 아니면 false 를 반환합니다.
     *
     * @author 박상훈
     * @param number 지난 주 당첨 번호
     * @return boolean
     * */
    private boolean isNumberCorrect(String[] number) {
        return Arrays
                .stream(number)
                .mapToInt(Integer::parseInt)
                .allMatch(n -> n >= MIN_LOTTO_NUMBER && n <= MAX_LOTTO_NUMBER);
    }

    /**
     * 지난 주 당첨 번호에 중복된 번호가 없는지 확인합니다.
     * 중복된 수가 없으면 true, 아니면 false 를 반환합니다.
     *
     * @author 박상훈
     * @param number 지난 주 당첨 번호
     * @return boolean
     * */
    private boolean isNumberUnique(String[] number) {
        return Arrays.stream(number).distinct().count() == LOTTO_COUNT;
    }
}
