package pl.javastart.incometax.service;

import java.math.BigDecimal;

public class IncomeTaxService {
    private static final BigDecimal firstTaxCoefficient = BigDecimal.valueOf(0.18);
    private static final BigDecimal secondTaxCoefficient = BigDecimal.valueOf(0.32);
    private static final BigDecimal taxThreshold = BigDecimal.valueOf(85528);
    private static final BigDecimal taxFreeAllowance = BigDecimal.valueOf(3091);

    public BigDecimal countIncomeTax(BigDecimal income){
        BigDecimal incomeTax;
        if (income.compareTo(taxThreshold) <= 0 && income.compareTo(taxFreeAllowance) > 0) {
            incomeTax = income.multiply(firstTaxCoefficient).subtract(BigDecimal.valueOf(556.02));
        } else if (income.compareTo(taxFreeAllowance) <= 0){
            incomeTax = BigDecimal.valueOf(0);
        } else {
            incomeTax = BigDecimal.valueOf(14839.02).add((income.subtract(taxThreshold)).multiply(secondTaxCoefficient));
        }
        return incomeTax;
    }
}
