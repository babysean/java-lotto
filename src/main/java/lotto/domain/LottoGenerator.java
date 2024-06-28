package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    /** 로또 숫자의 최솟값 */
    public static final int MIN_LOTTO_NUMBER = 1;

    /** 로또 숫자의 최댓값 */
    public static final int MAX_LOTTO_NUMBER = 45;

    /**
     * 로또 번호를 생성하고 반환합니다.
     *
     * @return List<Integer> 생성된 로또 티켓 목록
     */
    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = MIN_LOTTO_NUMBER ; i <= MAX_LOTTO_NUMBER ; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        List<Integer> shuffledNumber = numbers.subList(0, 6);

        Collections.sort(shuffledNumber);

        return shuffledNumber;
    }
}
