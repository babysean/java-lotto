package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    /**
     * 로또 번호를 생성하려 반환합니다.
     *
     * @author 박상훈
     * @return List<Integer>
     * */
    public LottoTicket generate() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = MIN_LOTTO_NUMBER ; i <= MAX_LOTTO_NUMBER ; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        List<Integer> shuffledNumber = numbers.subList(0, 6);

        Collections.sort(shuffledNumber);

        return new LottoTicket(shuffledNumber);
    }
}
