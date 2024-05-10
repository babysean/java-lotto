package lotto.service;

import lotto.domain.LastWeekLottoValidator;
import lotto.domain.LottoCalculator;
import lotto.domain.LottoConsumer;
import lotto.domain.LottoTicket;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    // TODO: 도메인들의 로직을 구현한다. loose coupling !!!!

    /**
     * 로또 번호를 생성하고 목록을 반환 합니다.
     *
     * @param consumer LottoConsumer
     * @param money 구매 금액
     * */
    public List<LottoTicket> buyLotto(LottoConsumer consumer, int money) {
        return consumer.buyLotto(money);
    }

    /**
     * 지난 주 당첨 로또를 가공하여 LottoTicket 으로 만듧니다.
     *
     * @param numbers 지난 주 당첨 번호
     * @return LottoTicket
     * */
    public LottoTicket winningNumberToTicket(String[] numbers) {
        // 유효성 체크
        LastWeekLottoValidator validator = new LastWeekLottoValidator();
        validator.validate(numbers);

        List<Integer> numberList = Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toList());

        return new LottoTicket(numberList);
    }

    /**
     * 로또를 계산하여 일치하는 개수의 목록을 반환합니다.
     *
     * @param lottoTickets 구매한 로또 티켓
     * @param winningTicket 지난 주 당첨 로또 티켓
     * @return List<Integer>
     * */
    public List<Integer> calculate(List<LottoTicket> lottoTickets, LottoTicket winningTicket) {
        LottoCalculator calculator = new LottoCalculator(lottoTickets, winningTicket);

        return calculator.calculate();
    }

    /**
     * 전달받은 수 만큼 맞은 로또의 개수를 반환합니다.
     *
     * @param matchingCount 일치하는 숫자의 개수 목록
     * @param checkNumber 확인할 개수
     * @return int
     * */
    public int getCountOfWins(List<Integer> matchingCount, int checkNumber) {
        return (int) matchingCount
                .stream()
                .filter(count -> count == checkNumber)
                .count();
    }

}
