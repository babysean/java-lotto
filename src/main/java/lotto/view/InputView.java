package lotto.view;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.service.LottoService.*;

public class InputView {
    /**
     * 구매할 금액을 입력 받아 반환합니다.
     *
     * @author 박상훈
     * @return int
     * */
    public int insertMoney() {
        int scanValue;

        System.out.println("구입할 금액을 입력해 주세요.");

        try {
            Scanner scanner = new Scanner(System.in);
            scanValue = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }

        if (scanValue < LOTTO_PRICE) {
            throw new IllegalArgumentException("금액은 1000과 같거나 커야 합니다.");
        }

        return scanValue;
    }

    /**
     * 지난 주 당첨 번호를 입력 받아 반환합니다.
     *
     * @author 박상훈
     * @return List
     * */
    public List<Integer> insertLastWeekWinningNumber() {
        String scanValue;

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);

        scanValue = scanner.nextLine();
        String[] lastWeekWinningNumber = scanValue
                .replace(" ", "")
                .split(",");

        // 유효성 체크
        validate(lastWeekWinningNumber);

        return Arrays.stream(lastWeekWinningNumber).map(Integer::parseInt).collect(Collectors.toList());
    }

    /**
     * 지난 주 당첨 번호에 대한 유효성을 확인 합니다.
     * <p>1. 번호가 6개 인지</p>
     * <p>2. 숫자로 되어있는지</p>
     * <p>3. 중복된 수가 없는지</p>
     *
     * @author 박상훈
     * @param number 지난 주 당첨 번호
     * */
    private void validate(String[] number) {
        if (!isSizeCorrect(number)) {
            throw new IllegalArgumentException("당첨번호는 콤마로 구분된 숫자 6개이어야 합니다.");
        }

        if (!isNumberCorrect(number)) {
            throw new IllegalArgumentException("각 당첨번호는 1과 45 사이의 정수이어야 합니다.");
        }

        if (!isNumberUnique(number)) {
            throw new IllegalArgumentException("당첨번호에 중복된 숫자가 없어야 합니다.");
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
    private boolean isSizeCorrect(String[] number) {
        return number.length == LOTTO_COUNT;
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
    private boolean isNumberCorrect(String[] number) {
        return Arrays
                .stream(number)
                .mapToInt(Integer::parseInt)
                .allMatch(n -> n >= MIN_LOTTO_NUMBER && n <= MAX_LOTTO_NUMBER);
    }

    /**
     * 지난 주 당첨 번호에 중복된 번호가 없는지 확인합니다.
     * 중복된 수가 없으면 true, 아니면 false 를 반환합니다.
     *
     * @author 박상훈
     * @param number 지난 주 당첨 번호
     * @return boolean
     * */
    private boolean isNumberUnique(String[] number) {
        return Arrays.stream(number).distinct().count() == LOTTO_COUNT;
    }
}
