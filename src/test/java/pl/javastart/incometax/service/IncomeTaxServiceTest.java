package pl.javastart.incometax.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
        BigDecimal income = BigDecimal.valueOf(85528);
        BigDecimal expectedValue = BigDecimal.valueOf(14839);

        //when
        BigDecimal result = (underTest.countIncomeTax(income)).setScale(0, RoundingMode.HALF_UP);

        //then
        assertThat(expectedValue).isEqualTo(result);
    }

    @Test
    void whenIncomeIsOneHundredThousand_shouldBe19470() {
        //given
        BigDecimal income = BigDecimal.valueOf(100000);
        BigDecimal expectedValue = BigDecimal.valueOf(19470);

        //when
        BigDecimal result = (underTest.countIncomeTax(income)).setScale(0, RoundingMode.HALF_UP);

        //then
        assertThat(expectedValue).isEqualTo(result);
    }

    @Test
    void whenIncomeIsFiftyThousands_shouldBe8444() {
        //given
        BigDecimal income = BigDecimal.valueOf(50000);
        BigDecimal expectedValue = BigDecimal.valueOf(8444);

        //when
        BigDecimal result = (underTest.countIncomeTax(income)).setScale(0, RoundingMode.HALF_UP);

        //then
        assertThat(expectedValue).isEqualTo(result);
    }

    @Test
    void whenIncomeIsEqualToTaxFreeAllowance_shouldBe0() {
        //given
        BigDecimal income = BigDecimal.valueOf(3091);
        BigDecimal expectedValue = BigDecimal.valueOf(0);

        //when
        BigDecimal result = (underTest.countIncomeTax(income)).setScale(0, RoundingMode.HALF_UP);

        //then
        assertThat(expectedValue).isEqualTo(result);
    }
}