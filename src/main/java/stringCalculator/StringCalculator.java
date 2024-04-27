package stringCalculator;

import java.util.Arrays;

public class StringCalculator {

    private final String[] numbers;

    public StringCalculator(String stringNumber) {
        checkNotNull(stringNumber);
        checkDelimiterFormat(stringNumber);

        this.numbers = splitNumber(stringNumber);
    }

    /**
     * 입력값이 null 이면 NullPointerException 을 반환합니다.
     *
     * @author 박상훈
     */
    private void checkNotNull(String stringNumber) {
        if (stringNumber == null) {
            throw new NullPointerException("입력값은 NULL일 수 없습니다.");
        }
    }

    /**
     * 문자열을 명시된 구분자에 맞게 split 하여 변수에 저장합니다.
     *
     * @author 박상훈
     * */
    private String[] splitNumber(String stringNumber) {
        // \n의 index 값 추출
        int delimiterEndIndex = stringNumber.indexOf('\n');
        // // 부터 \n 사이의 문자열을 추출 = 구분자 추출
        String customDelimiter = stringNumber.substring(2, delimiterEndIndex);
        // \n 다음번의 문자열부터 자르기 = 숫자를 추출할 문자열
        String customStringNumbers = stringNumber.substring(delimiterEndIndex + 1);

        return customStringNumbers.split(customDelimiter);
    }

    /**
     * 문자열이 // 로 시작하는지 확인합니다.
     *
     * @author 박상훈
     * */
    private void checkDelimiterFormat(String stringNumber) {
        if (!stringNumber.startsWith("//")) {
            throw new IllegalArgumentException("구분자 형식이 맞지 않습니다.");
        }
    }

    /**
     * 문자열에 음수가 포함되어 있는지 확인합니다.
     *
     * @author 박상훈
     * */
    public void checkNegative() {
        boolean check = Arrays.stream(numbers)
                .anyMatch(n -> Integer.parseInt(n) < 0);

        if (!check) {
            throw new IllegalArgumentException("음수는 포함될 수 없습니다.");
        }
    }

    /**
     * split 된 문자 배열을 더합니다.
     *
     * @author 박상훈
     * */
    public int sum() {
        checkNegative();

        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
