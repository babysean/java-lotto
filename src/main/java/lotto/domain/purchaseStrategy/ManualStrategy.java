package lotto.domain.purchaseStrategy;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoConsumer;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketGenerator;
import lotto.dto.LottoPurchaseDto;

public class ManualStrategy implements PurchaseStrategy {

    @Override
    public void buyLottoTicket(LottoConsumer consumer, LottoPurchaseDto purchaseDto, LottoTicketGenerator generator) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (String[] lottoNumber : purchaseDto.getLottoNumbers()) {
            lottoTickets.add(generator.manualGenerate(lottoNumber));
        }

        // 로또 티켓 추가
        consumer.addManualLottoTickets(lottoTickets);
    }
}
