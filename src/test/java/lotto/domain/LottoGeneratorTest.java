package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoGeneratorTest {
    @Test
    @DisplayName("로또_번호는_6개_입니다")
    void 로또_번호는_6개_입니다() {
        // given
        LottoGenerator generator = new LottoGenerator();

        // when
        List<Integer> numbers = generator.generate();

        // then
        assertThat(numbers).hasSize(6);
    }

    @Test
    @DisplayName("로또_번호는_중복되지_않습니다")
    void 로또_번호는_중복되지_않습니다() {
        // given
        LottoGenerator generator = new LottoGenerator();

        // when
        List<Integer> numbers = generator.generate();
        long count = numbers
                .stream()
                .distinct()
                .count();

        // then
        assertThat(count).isEqualTo(6);
    }
}
