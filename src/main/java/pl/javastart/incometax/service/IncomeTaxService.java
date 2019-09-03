package pl.javastart.incometax.service;

public class IncomeTaxService {
    public double countIncomeTax(double income){
        double incomeTax;
        double firstTaxCoefficient = 0.18;
        double secondTaxCoefficient = 0.32;
        double taxThreshold = 85528;

        if (income <= taxThreshold) {
            incomeTax = income * firstTaxCoefficient - 556.02;
        } else {
            incomeTax = 14839.02 + (income - taxThreshold) * secondTaxCoefficient;
        }

        return incomeTax;
    }
}
