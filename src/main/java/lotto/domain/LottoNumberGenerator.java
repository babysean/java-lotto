package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.service.LottoService.MAX_LOTTO_NUMBER;
import static lotto.service.LottoService.MIN_LOTTO_NUMBER;

public class LottoNumberGenerator {
    /**
     * 로또 번호를 생성하려 반환합니다.
     *
     * @author 박상훈
     * @return List<Integer>
     * */
    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = MIN_LOTTO_NUMBER ; i <= MAX_LOTTO_NUMBER ; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        return numbers.subList(0, 6);
    }
}
