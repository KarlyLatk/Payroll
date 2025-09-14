package org.example;

public class PayrollCalculator {
    public double grossPay(double hoursWorked, double hourlyPay){

        if(hoursWorked > 40){
            return (40 * hourlyPay) + (((hoursWorked - 40) * 1.5) * hourlyPay);
        }
        else if(hoursWorked < 0){
            return 0;
        }
        return hoursWorked * hourlyPay;
    }

    public String generateReport(double hoursWorked, int children, double hourlyPay) {
        double grossPay = grossPay(hoursWorked, hourlyPay);
        double socSecurity = 0.06 * grossPay;
        double fedTax = 0.14 * grossPay;
        double stateTax = 0.05 * grossPay;
        double union = 10.0;
        double insurance = 0;

        if(children >= 3){
            insurance = 35;
        }
        else{
            insurance = 15;
        }

        double totalDeductions = socSecurity + fedTax + stateTax + union + insurance;
        double netPay = grossPay - totalDeductions;

        return  String.format("\tHours:\t%.2f", hoursWorked) +
                String.format("\n\tRate:\t%.2f $/hr", hourlyPay) +
                String.format("\n\tGross:\t$ %.2f", grossPay) +
                String.format("\n\n\tSocSec:\t$ %.2f", socSecurity) +
                String.format("\n\tFedTax:\t$ %.2f", fedTax) +
                String.format("\n\tStTax:\t$ %.2f", stateTax) +
                String.format("\n\tUnion:\t$ %.2f", union) +
                String.format("\n\tIns:\t$ %.2f", insurance) +
                String.format("\n\n\tNet:\t$ %.2f", netPay);
    }
}
