import java.util.Scanner;


public class MainProgram {
	
	public static void main(String[] args)	{
		Scanner percepts= new Scanner(System.in);
		System.out.println("Environment 1");
		System.out.println("Enter number of pegs (> 3): ");
		int numPegs = percepts.nextInt();
		System.out.println("Enter origin peg: ");
		int origin= percepts.nextInt();
		System.out.println("Enter destination peg: ");
		int destination = percepts.nextInt();
		System.out.println("Enter number of disks (> 0): ");
		int numDisks = percepts.nextInt();
		
		Environment env = new Environment(numPegs,origin,destination,numDisks);
		//System.out.println(env.toString());
		
		/*System.out.println("Environment 2");
		System.out.println("Enter number of pegs (> 3): ");
		int numPegs2 = percepts.nextInt();
		System.out.println("Enter origin peg: ");
		int origin2= percepts.nextInt();
		System.out.println("Enter destination peg: ");
		int destination2 = percepts.nextInt();
		System.out.println("Enter number of disks (> 0): ");
		int numDisks2 = percepts.nextInt();
		
		Environment env2 = new Environment(numPegs2,origin2,destination2,numDisks2);
		
		if(env.equals(env2))	{
			System.out.println("Both environments are equals.");
		} else	{
			System.out.println("The environments are different.");
		}*/
		
		HanoiProblem problem = new HanoiProblem(env.getPegs().size(),env.getOrigin().getDisks().size());
		problem.createOperators();
		
		
	}
	
}
