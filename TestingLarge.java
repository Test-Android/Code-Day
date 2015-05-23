import java.util.Scanner;
public class TestingLarge 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		System.out.print("What is your first number? ");
		Large l = new Large(in.nextLine());
		System.out.print("What is your second number? ");
		Large l2 =  new Large(in.nextLine());
		System.out.print("What would you like to do (+,-,*, or /) ? ");
		String answer = in.nextLine();
		if(answer.equalsIgnoreCase("+") || answer.equalsIgnoreCase("add"))
		{
			l.add(l2);
		}
		else if(answer.equalsIgnoreCase("*") || answer.equalsIgnoreCase("multiply"))
		{
			l.mult(l2);
		}
		else if(answer.equalsIgnoreCase("-") || answer.equalsIgnoreCase("subtract"))
		{
			l.sub(l2);
		}
		else if(answer.equalsIgnoreCase("/") || answer.equalsIgnoreCase("divison"))
		{
			l.div(l2);
		}
		System.out.println(l.getAmount("Your number is: "));
	}
}
