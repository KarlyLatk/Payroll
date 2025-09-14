package org.example;
import java.util.Scanner;
public class App {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.println("Welcome to the Payroll Program!");

    System.out.print("How many hours did you work this week? ");
    double hoursWorked = in.nextDouble();
    System.out.print("How much are you paid per hour? ");
    double hourlyPay = in.nextDouble();
    while(hourlyPay < 0){
      System.out.println("Invalid amount. Please enter a positive pay rate. ");
      hourlyPay = in.nextDouble();
    }
    System.out.print("How many children do you have? ");
    int children = in.nextInt();
    while(children < 0){
      System.out.println("Invalid amount. Please enter a non-negative children. ");
      children = in.nextInt();
    }
    in.close();

    PayrollCalculator payrollCalculator = new PayrollCalculator();

    double grossPay = payrollCalculator.grossPay(hoursWorked, hourlyPay);
    String payrollReport = payrollCalculator.generateReport(hoursWorked, children, hourlyPay);

    System.out.println(payrollReport);
    System.out.println("Thank you for using the Payroll Program!");

  }
}
