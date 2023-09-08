package basic;

public class Calc {
	public int calc(int num1, String opp, int num2) {
		int result=0;

		switch(opp) {
		case "+":
			result=num1+num2;break;
		case "-":
			result=num1-num2;break;
		case "*":
			result=num1*num2;break;
		case "/":
			result=num1/num2;break;
		}
		return result;
	}
	

}
