package pkgMain;

import org.apache.poi.ss.formula.functions.*;

import java.util.Scanner;

public class cMain {

	public static void main(String[] args){

			Scanner input = new Scanner(System.in);
			int yearsToWork;
			double expectedAverageInvestmentReturn;
			double expectedAveragePaybackReturn;
			int timeToDraw; 
			double expectedSSIincome;
			double requiredIncome;
			
			System.out.print("Enter the number of years you want to work: ");
			yearsToWork = input.nextInt();
			
			System.out.print("Enter your expected average return on investment as a decimal: ");
			expectedAverageInvestmentReturn = input.nextDouble();
			
			while( !(expectedAverageInvestmentReturn <=.2 && expectedAverageInvestmentReturn >= 0) )
			{
				System.out.println("The value must be in the range 0 to .2");
				
				System.out.print("Enter your expected average return on investment as a decimal: ");
				expectedAverageInvestmentReturn = input.nextDouble();
				
			}
			
			System.out.print("Enter your expected average return on payback as a decimal: ");
			expectedAveragePaybackReturn = input.nextDouble();
			
			while( !(expectedAveragePaybackReturn <=.03 && expectedAveragePaybackReturn >= 0) )
			{
				System.out.println("The value must be in the range 0 to .03");
				
				System.out.print("Enter your expected average return on investment as a decimal: ");
				expectedAveragePaybackReturn = input.nextDouble();
				
			}
			
			
			System.out.print("Enter how long you want to draw: ");
			timeToDraw = input.nextInt();
			
			System.out.print("Enter your required income: ");
			requiredIncome = input.nextDouble();
			
			System.out.print("Enter your expected SSI Income: ");
			expectedSSIincome = input.nextDouble();
			
			double PV=FindPV(expectedAveragePaybackReturn/12, timeToDraw*12, expectedSSIincome-requiredIncome,0, false);
			
			System.out.println("You should save $"+ String.format("%.2f", -FindPMT(expectedAverageInvestmentReturn/12, yearsToWork*12, 0, PV, false)));
			
			input.close();
	}
	
	
	public static double FindPMT(double r, double n, double p, double f, boolean t)
	{
		return FinanceLib.pmt(r, n, p, f, t);
	}
	
	public static double FindFV(double r, double n, double y, double p, boolean t)
	{
		return FinanceLib.fv(r, n, y, p, t);
	}
	
	public static double FindPV(double r, double n, double y, double f, boolean t)
	{
		return FinanceLib.pv(r, n, y, f, t);
	}

}
