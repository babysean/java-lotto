package lotto;

import lotto.domain.LottoConsumer;
import lotto.domain.LottoTicket;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApplication {
    private LottoConsumer consumer;


    private InputView inputView;

    private OutputView outputView;

    public LottoApplication(LottoConsumer consumer, InputView inputView, OutputView outputView) {
        this.consumer = consumer;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        LottoService lottoService = new LottoService();

        // 로또 구매 금액 입력 및 구매
        int money = inputView.insertMoney();
        List<LottoTicket> lottoTickets = lottoService.buyLotto(consumer, money);

        // 로또 구매 정보 출력
        outputView.printLottoTicketsInformation(lottoTickets);

        // 지난 주 당첨번호 입력
        String[] LastWeekWinningNumbers = inputView.inputLastWeekWinningLottoNumbers();
        LottoTicket winningTicket = lottoService.winningNumberToTicket(LastWeekWinningNumbers);

        // 로또 계산
        List<Integer> winningCounts = lottoService.calculate(lottoTickets, winningTicket);

        // TODO: 맞춘 개수 및 수익률 계산
    }

    public static void main(String[] args) {
        LottoApplication lottoApplication = new LottoApplication(new LottoConsumer(), new InputView(), new OutputView());
        lottoApplication.run();
    }
}
