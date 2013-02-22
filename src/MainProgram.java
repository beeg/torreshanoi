import java.util.Scanner;


public class MainProgram {

	
	public static void main(String[] args)	{
		Scanner percepts= new Scanner(System.in);
		System.out.println("Enter number of pegs (> 3): ");
		int numPegs = percepts.nextInt();
		System.out.println("Enter origin peg: ");
		int origin= percepts.nextInt();
		System.out.println("Enter destination peg: ");
		int destination = percepts.nextInt();
		System.out.println("Enter number of disks (> 0): ");
		int numDisks = percepts.nextInt();
		
		Environment env = new Environment(numPegs,origin,destination,numDisks);
		System.out.println(env.toString());
	}
	
}
