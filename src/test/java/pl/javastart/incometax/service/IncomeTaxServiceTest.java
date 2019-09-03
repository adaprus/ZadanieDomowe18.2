package pl.javastart.incometax.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class IncomeTaxServiceTest {
    private IncomeTaxService underTest;
    @BeforeEach
    void setUp() {
        underTest = new IncomeTaxService();
    }

    @Test
    void whenIncomeIsEqualToTaxThreshold_shouldBe14839() {
        //given
        double income = 85528;
        double expectedValue = 14839;

        //when
        double result = Math.round(underTest.countIncomeTax(income));

        //then
        assertThat(expectedValue).isEqualTo(result);
    }

    @Test
    void whenIncomeIsOneHundredThousand_shouldBe19470() {
        //given
        double income = 100000;
        double expectedValue = 19470;

        //when
        double result = Math.round(underTest.countIncomeTax(income));

        //then
        assertThat(expectedValue).isEqualTo(result);
    }

    @Test
    void whenIncomeIsFiftyThousands_shouldBe8444() {
        //given
        double income = 50000;
        double expectedValue = 8444;

        //when
        double result = Math.round(underTest.countIncomeTax(income));

        //then
        assertThat(expectedValue).isEqualTo(result);
    }


}