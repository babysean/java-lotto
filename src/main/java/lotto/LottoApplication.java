package lotto;

import lotto.domain.LottoConsumer;
import lotto.domain.LottoPrize;
import lotto.domain.LottoTicket;
import lotto.factory.LottoApplicationFactory;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApplication {
    private final InputView inputView;

    private final OutputView outputView;

    private final LottoService lottoService;

    public LottoApplication(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        LottoConsumer consumer = new LottoConsumer();

        // 로또 구매 금액 입력 및 구매
        int money = inputView.insertMoney();
        lottoService.buyLotto(consumer, money);

        // 로또 구매 정보 출력
        outputView.printLottoTicketsInformation(consumer.getLottoTickets());

        // 지난 주 당첨번호 입력
        String[] LastWeekWinningNumbers = inputView.inputLastWeekWinningLottoNumbers();

        // 지난 주 보너스 번호 입력
        int bonusNumber = inputView.inputBonusNumber();

        // 지난 주 당첨 티켓 생성
        LottoTicket winningTicket = lottoService.winningNumberToTicket(LastWeekWinningNumbers);

        // 맞춘 번호 개수와 맞춘 보너스 번호 결과
        List<LottoPrize> winningResult = lottoService.calculate(consumer.getLottoTickets(), winningTicket, bonusNumber);

        // 로또 결과 출력
        outputView.printResultTitle();
        lottoService.printWinningInformation(winningResult, outputView);

        // 수익률 출력
        double profit = lottoService.getProfit(winningResult, money);
        outputView.printProfit(profit);
    }

    public static void main(String[] args) {
        LottoApplicationFactory factory = new LottoApplicationFactory();
        LottoApplication lottoApplication = factory.createLottoApplication();
        lottoApplication.run();
    }
}
