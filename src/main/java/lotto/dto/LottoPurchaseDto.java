package lotto.dto;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaseDto {

    private final int money;

    private final List<String[]> lottoNumbers;

    public LottoPurchaseDto(int money, List<String[]> lottoNumbers) {
        this.money = money;
        this.lottoNumbers = new ArrayList<>();

        if (lottoNumbers != null) {
            this.lottoNumbers.addAll(lottoNumbers);
        }
    }

    public int getMoney() {
        return money;
    }

    public List<String[]> getLottoNumbers() {
        return lottoNumbers;
    }
}
