package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoNumberGeneratorTest {
    @Test
    @DisplayName("로또_번호는_6개_입니다")
    void 로또_번호는_6개_입니다() {
        // given
        LottoNumberGenerator generator = new LottoNumberGenerator();

        // when
        List<Integer> lottoNumber = generator.generate();

        // then
        assertThat(lottoNumber).hasSize(6);
    }

    @Test
    @DisplayName("로또_번호는_중복되지_않습니다")
    void 로또_번호는_중복되지_않습니다() {
        // given
        LottoNumberGenerator generator = new LottoNumberGenerator();

        // when
        List<Integer> lottoNumber = generator.generate();
        long count = lottoNumber.stream().distinct().count();

        // then
        assertThat(count).isEqualTo(6);
    }
}
