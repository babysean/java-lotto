package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketGenerator {

    /** 로또 숫자의 최솟값 */
    public static final int MIN_LOTTO_NUMBER = 1;

    /** 로또 숫자의 최댓값 */
    public static final int MAX_LOTTO_NUMBER = 45;

    /**
     * 자동 로또 번호를 생성하고 반환합니다.
     *
     * @return List<Integer> 생성된 로또 티켓 목록
     */
    public LottoTicket autoGenerate() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = MIN_LOTTO_NUMBER ; i <= MAX_LOTTO_NUMBER ; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        List<Integer> shuffledNumber = numbers.subList(0, 6);

        Collections.sort(shuffledNumber);

        return new LottoTicket(shuffledNumber);
    }

    /**
     * 수동 로또 번호를 전달 받아 LottoTicket 객체로 반환 합니다.
     *
     * @param numbers 로또 번호
     *
     * @return LottoTicket
     */
    public LottoTicket manualGenerate(String[] numbers) {
        List<Integer> lottoNumbers = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // 유효성 체크
        LottoValidator validator = new LottoValidator();
        validator.winningNumbersValidation(lottoNumbers);

        return new LottoTicket(lottoNumbers);
    }
}
