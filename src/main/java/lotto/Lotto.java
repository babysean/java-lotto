package lotto;

import java.util.*;

public class Lotto {
    /** 로또 가격 */
    private static final int LOTTO_PRICE = 1000;

    /** 구매 개수 */
    private final Integer purchaseCount;

    /** 구매할 금액 */
    private final Integer purchasePrice;

    /** 구매한 로또 번호 목록 */
    private final List<List<Integer>> lottoNumbers = new ArrayList<>();

    /** 맞은 개수 목록 */
    private final List<Integer> winningCount = new ArrayList<>();

    public Lotto(Integer money) {
        purchasePrice = money;
        purchaseCount = purchasePrice / LOTTO_PRICE;

        for (int i = 0 ; i < purchaseCount ; i++) {
            lottoNumbers.add(initLottoNumber());
        }
    }

    /**
     * 랜덤한 6개 정수 값을 List 에 담아 반환합니다.
     *
     * @author 박상훈
     * @return List<Integer>
     * */
    private List<Integer> initLottoNumber() {
        List<Integer> numberList = new ArrayList<>();

        for (int i = 1 ; i <= 45 ; i++) {
            numberList.add(i);
        }

        Collections.shuffle(numberList);

        List<Integer> randomNumbers = numberList.subList(0, 6);

        Collections.sort(randomNumbers);

        return randomNumbers;
    }

    /**
     * 구매 가능한 로또 개수를 반환합니다.
     *
     * @author 박상훈
     * @return Integer
     * */
    public Integer getPurchaseCount() {
        return this.purchaseCount;
    }

    /**
     * 구매한 로또번호의 목록을 반환 합니다.
     *
     * @author 박상훈
     * @return List<List<Integer>>
     * */
    public List<List<Integer>> getPurchaseNumbers() {
        return this.lottoNumbers;
    }

    /**
     * 전달받은 String 문자열을 List<Integer>로 변환하여 반환합니다.
     *
     * @author 박상훈
     * @param winningNumber 지난 주 당첨 번호
     * @return List<Integer>
     * */
    private List<Integer> convertNumber(String winningNumber) {
        winningNumber = winningNumber.replace(" ", "");
        List<Integer> numbersSet = new ArrayList<>();

        for (String number : winningNumber.split(",")) {
            numbersSet.add(Integer.parseInt(number));
        }

        return numbersSet;
    }

    /**
     * 지난 주 당첨번호와 구매한 로또번호를 비교하여, 맞춘 개수를 winningCount 에 insert 합니다.
     *
     * @author 박상훈
     * @param number 당첨 번호
     * */
    public void calculateLotto(String number) {
        List<Integer> winningNumber = convertNumber(number);

        this.lottoNumbers
                .forEach(purchaseNumber -> {
                    Set<Integer> copyOfPurchaseNumber = new HashSet<>(purchaseNumber);
                    Set<Integer> copyOfWinningNumber = new HashSet<>(winningNumber);

                    copyOfPurchaseNumber.retainAll(copyOfWinningNumber);

                    // 맞춘 개수를 List 에 넣는다.
                    winningCount.add(copyOfPurchaseNumber.size());
                });
    }

    /**
     * 지난 주 당첨 번호에 대한 유효성을 확인 합니다.
     * <p>1. 번호가 6개 인지</p>
     * <p>2. 숫자로 되어있는지</p>
     * <p>3. 중복된 수가 없는지</p>
     *
     * @author 박상훈
     * */
    public void checkValidation(String number) {
        if (!isSizeCorrect(number)) {
            throw new IllegalArgumentException("당첨 번호가 숫자 6개가 아닙니다.");
        }

        if (!isNumberCorrect(number)) {
            throw new IllegalArgumentException("당첨 번호에 로또 번호가 아닌 값이 포함되어 있습니다.");
        }

        if (!isNumberUnique(number)) {
            throw new IllegalArgumentException("당첨 번호에 중복된 숫자가 존재합니다.");
        }
    }

    /**
     * 지난 주 당첨 번호가 ,로 구분된 6개의 숫자인지 확인합니다.
     * 6개 이면 true, 아니면 false 를 반환합니다.
     *
     * @author 박상훈
     * @param number 지난 주 당첨 번호
     * @return boolean
     */
    private boolean isSizeCorrect(String number){
        number = number
                .replace(" ", "");

        return number.matches("\\d+,\\d+,\\d+,\\d+,\\d+,\\d+");
    }

    /**
     * 지난 주 당첨 번호가 로또 번호가 맞는지 확인합니다.
     * 각 번호는 1 ~ 45사이의 수 입니다.
     * 6개의 번호가 이를 만족하면 true, 아니면 false 를 반환합니다.
     *
     * @author 박상훈
     * @param number 지난 주 당첨 번호
     * @return boolean
     * */
    private boolean isNumberCorrect(String number){
        String[] numbers = number
                .replace(" ", "")
                .split(",");

        return Arrays
                .stream(numbers)
                .mapToInt(Integer::parseInt)
                .allMatch(n -> n >= 1 && n <= 45);
    }

    /**
     * 지난 주 당첨 번호에 중복된 번호가 없는지 확인합니다.
     * 중복된 수가 없으면 true, 아니면 false 를 반환합니다.
     *
     * @author 박상훈
     * @param number 지난 주 당첨 번호
     * @return boolean
     * */
    private boolean isNumberUnique(String number) {
        String[] numbers = number
                .replace(" ", "")
                .split(",");

        long count = Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .distinct()
                .count();

        return count == 6;
    }

    /**
     * 전달 받은 숫자 만큼 맞춘 로또의 개수를 반환합니다.
     *
     * @author 박상훈
     * @param number 당첨된 개수
     * @return Integer
     * */
    public Integer getWinningCount(Integer number) {
        return Math.toIntExact(winningCount.stream()
                .filter(count -> Objects.equals(count, number))
                .count());
    }

    /**
     * 수익률을 반환합니다.
     *
     * @author 박상훈
     * @return Double
     * */
    public Double getRateOfReturn() {
        int winningPrice = getWinningCount(3) * 5000
                + getWinningCount(4) * 50000
                + getWinningCount(5) * 1500000
                + getWinningCount(6) * 2000000000;

        double rateOfReturn = (double) winningPrice / (double) purchasePrice;

        return Math.round(rateOfReturn * 100) / 100.0;
    }
}
