package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class PurchasedNumbers {
    /** 구매한 로또 번호 목록 */
    private final List<List<Integer>> purchasedNumbers = new ArrayList<>();

    /**
     * 전달 받은 로또 번호를 저장합니다.
     *
     * @param purchasedNumber 구매한 로또 번호
     * */
    public void addNumber(List<Integer> purchasedNumber) {
        purchasedNumbers.add(purchasedNumber);
    }

    /**
     * 구매한 로또 번호의 목록을 반환합니다.
     *
     * @author 박상훈
     * @return List<List<Integer>>
     * */
    public List<List<Integer>> getNumbers() {
        return purchasedNumbers;
    }

}
