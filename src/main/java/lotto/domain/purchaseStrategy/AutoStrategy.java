package lotto.domain.purchaseStrategy;

import static lotto.domain.LottoTicket.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoConsumer;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketGenerator;
import lotto.dto.LottoPurchaseDto;

public class AutoStrategy implements PurchaseStrategy {

    @Override
    public void buyLottoTicket(LottoConsumer consumer, LottoPurchaseDto purchaseDto, LottoTicketGenerator generator) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        int purchasedCount = purchaseDto.getMoney() / LOTTO_PRICE;
        int autoPurchasedCount = purchasedCount - consumer.getManualTicketCount();

        for (int i = 0 ; i < autoPurchasedCount ; i++) {
            lottoTickets.add(generator.autoGenerate());
        }

        // 로또 티켓 추가
        consumer.addAutoLottoTickets(lottoTickets);
    }
}
