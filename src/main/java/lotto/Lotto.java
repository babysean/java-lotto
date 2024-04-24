package lotto;

import java.util.*;

public class Lotto {
    private static final int LOTTO_PRICE = 1000;

    // 구매 개수
    private final Integer purchaseCount;

    // 구매 금액
    private final Integer purchasePrice;

    // 구매한 로또 번호 목록
    private List<List<Integer>> purchaseNumbers = new ArrayList<>();

    // 맞은 개수 목록
    private List<Integer> winningCount = new ArrayList<>();

    public Lotto(Integer money) {
        purchasePrice = money;
        purchaseCount = purchasePrice / LOTTO_PRICE;

        for (int i = 0 ; i < purchaseCount ; i++) {
            purchaseNumbers.add(initPurchaseNumbers());
        }
    }

    // 로또 개수를 전달 받아 랜덤한 6개 값 List 세팅합니다.
    private List<Integer> initPurchaseNumbers() {
        List<Integer> numberList = new ArrayList<>();

        for (int i = 1 ; i <= 45 ; i++) {
            numberList.add(i);
        }

        Collections.shuffle(numberList);

        List<Integer> randomNumbers = numberList.subList(0, 6);

        Collections.sort(randomNumbers);

        return randomNumbers;
    }

    // 구매 가능한 로또 개수를 반환합니다.
    Integer getPurchaseCount() {
        return this.purchaseCount;
    }

    // 구매한 로또번호의 목록을 반환 합니다.
    List<List<Integer>> getPurchaseNumbers() {
        return this.purchaseNumbers;
    }

    // String 으로 받은 로또 숫자를 List<Integer>로 변환 합니다.
    List<Integer> convertNumbers(String winningNumber) {
        winningNumber = winningNumber.trim();
        List<Integer> numbersSet = new ArrayList<>();

        for (String number : winningNumber.split(",")) {
            numbersSet.add(Integer.parseInt(number));
        }

        return numbersSet;
    }

    // 구매한 로또번호와 지난 주 당첨번호를 비교하여, 같은 개수를 반환 합니다.
    void compareNumbers(List<Integer> purchaseNumber, List<Integer> winningNumber) {
        Set<Integer> copyOfPurchaseNumber = new HashSet<>(purchaseNumber);
        Set<Integer> copyOfWinningNumber = new HashSet<>(winningNumber);

        copyOfPurchaseNumber.retainAll(copyOfWinningNumber);

        // 맞춘 개수를 List 에 넣는다.
        winningCount.add(copyOfPurchaseNumber.size());
    }

    // 맞춘 개수 계산
    void getWinningCount(String number) {
        List<Integer> winningNumber = convertNumbers(number);

        this.purchaseNumbers.stream()
                .forEach(purchaseNumber -> compareNumbers(purchaseNumber, winningNumber));
    }

    // 전달 받은 숫자 만큼 맞춘 로또의 개수를 반환한다.
    Integer getWinningCount(Integer number) {
        return Math.toIntExact(winningCount.stream()
                .filter(count -> count == number)
                .count());
    }

    // 수익률을 구합니다.
    Double getRateOfReturn() {
        int winningPrice = getWinningCount(3) * 5000
                + getWinningCount(4) * 50000
                + getWinningCount(5) * 1500000
                + getWinningCount(6) * 2000000000;

        double rateOfReturn = (double) winningPrice / (double) purchasePrice;

        return Math.round(rateOfReturn * 100) / 100.0;
    }
}
