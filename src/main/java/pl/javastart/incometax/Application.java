package pl.javastart.incometax;
import pl.javastart.incometax.service.IncomeTaxService;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        IncomeTaxService service = new IncomeTaxService();

        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Podaj swój dochód:");
            BigDecimal income = BigDecimal.valueOf(input.nextDouble());
            input.nextLine();
            System.out.println("Należny podatek wynosi: " + service.countIncomeTax(income));
        } catch (InputMismatchException e) {
            System.out.println("Należy wprowadzić kwotę dochodu");
        }
    }
}
