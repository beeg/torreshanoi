import java.util.Random;
import java.util.Scanner;

import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.blind.BreadthFS;
import es.deusto.ingenieria.is.search.algorithms.blind.DepthFS;
import es.deusto.ingenieria.is.search.formulation.State;


public class MainProgram {
	
	public static void main(String[] args)	{
		/*Scanner percepts= new Scanner(System.in);
		System.out.println("Environment 1");
		System.out.println("Enter number of pegs (> 3): ");
		int numPegs = percepts.nextInt();
		System.out.println("Enter origin peg: ");
		int origin= percepts.nextInt();
		System.out.println("Enter destination peg: ");
		int destination = percepts.nextInt();
		System.out.println("Enter number of disks (> 0): ");
		int numDisks = percepts.nextInt();
		
		Environment e = new Environment(numPegs,origin,destination,numDisks);
		System.out.println(e.toString());
		
		System.out.println("Environment 2");
		System.out.println("Enter number of pegs (> 3): ");
		int numPegs2 = percepts.nextInt();
		System.out.println("Enter origin peg: ");
		int origin2= percepts.nextInt();
		System.out.println("Enter destination peg: ");
		int destination2 = percepts.nextInt();
		System.out.println("Enter number of disks (> 0): ");
		int numDisks2 = percepts.nextInt();
		
		Environment e2 = new Environment(numPegs2,origin2,destination2,numDisks2);
		
		if(e.equals(e2))	{
			System.out.println("Both environments are equals.");
		} else	{
			System.out.println("The environments are different.");
		}
		
		//Selecting random movements
		HanoiProblem p = new HanoiProblem(e.getNumPegs(),e.getOriginSize());
		p.addInitialState(e);
		p.createOperators();
		Random random= new Random();
		int originP= random.nextInt(p.getNumberOfPegs());
		int destP=random.nextInt(p.getNumberOfPegs());
		MoveOperator move=(MoveOperator)p.getOperator(originP, destP);
		System.out.println(move.toString());
		Environment auxEnv = (Environment)move.apply(e);
		if(auxEnv!=null)	{
			e=auxEnv;
			System.out.println(e.toString());
		}
		System.out.println(p.toString(p.isFinalState(e)));
		
		
		//New random movement
		System.out.println("\nNew Movement");
		originP=random.nextInt(p.getNumberOfPegs());
		destP=random.nextInt(p.getNumberOfPegs());
		move=(MoveOperator)p.getOperator(originP, destP);
		System.out.println(move.toString());
		auxEnv = (Environment)move.apply(e);
		if(auxEnv!=null)	{
			e=auxEnv;
			System.out.println(e.toString());
		}
		System.out.println(p.toString(p.isFinalState(e)));
		
		
		//New random movement
		originP=random.nextInt(p.getNumberOfPegs());
		destP=random.nextInt(p.getNumberOfPegs());
		move=(MoveOperator)p.getOperator(originP, destP);
		System.out.println(move.toString());
		auxEnv = (Environment)move.apply(e);
		if(auxEnv!=null)	{
			e=auxEnv;
			System.out.println(e.toString());
		}
		System.out.println(p.toString(p.isFinalState(e)));
		
		//Checking final state
		System.out.println("\nFinal State");
		Environment fEnv=new Environment((Environment)e,p.getNumberOfPegs(),p.getNumberOfDisks());
		System.out.println(fEnv.toString());
		System.out.println(p.toString(p.isFinalState(fEnv)));
		
		//Creating a environment with established characteristics:
		//Number of pegs: 3
		//Origin peg: 1
		//Destination peg: 2
		//Number of disks: 3
		System.out.println("\nNew environment");
		Environment env = new Environment(3,1,2,3);
		System.out.println(env.toString());
		HanoiProblem problem = new HanoiProblem(env.getNumPegs(),env.getOriginSize());
		problem.addInitialState(env);
		problem.createOperators();
		System.out.println(problem.toString(problem.isFinalState(env)));
		
		//Movement from peg 1 to peg 2 that can be applicable
		System.out.println("\nMovement from peg 1 to peg 2");
		MoveOperator operator=(MoveOperator)problem.getOperator(0,1);
		Environment tempEnv = (Environment)operator.apply(env);
		if(tempEnv!=null)	{
			env=tempEnv;
			System.out.println(env.toString());
		}
		System.out.println(problem.toString(problem.isFinalState(env)));
		
		//Movement from peg 1 to peg 2 that cannot be applicable
		System.out.println("\nMovement from peg 1 to peg 2");
		tempEnv = (Environment)operator.apply(env);
		if(tempEnv!=null)	{
			env=tempEnv;
			System.out.println(env.toString());
		}
		System.out.println(problem.toString(problem.isFinalState(env)));
		
		//Movement from peg 2 to peg 3 that can be applicable
		System.out.println("\nMovement from peg 2 to peg 3");
		operator=(MoveOperator)problem.getOperator(1,2);
		tempEnv = (Environment)operator.apply(env);
		if(tempEnv!=null)	{
			env=tempEnv;
			System.out.println(env.toString());
		}
		System.out.println(problem.toString(problem.isFinalState(env)));
		
		//Checking final state
		System.out.println("\nFinal State");
		Environment finalEnv=new Environment((Environment)env,problem.getNumberOfPegs(),problem.getNumberOfDisks());
		System.out.println(finalEnv.toString());
		System.out.println(problem.toString(problem.isFinalState(finalEnv)));*/
		
		
		Environment environment = new Environment(3,1,3,4);
		HanoiProblem hanoi = new HanoiProblem(3,4);
		hanoi.addInitialState(environment);
		//BFS test
		System.out.println("BFS test: ");
		BreadthFS breadth = BreadthFS.getInstance();
		Long BFSpreviousTime = System.currentTimeMillis();
		hanoi.solve(breadth);
		Long BFSduration = System.currentTimeMillis() - BFSpreviousTime;
		System.out.println("BFS duration: "+ BFSduration);
		
		//DFS test
		System.out.println("DFS test: ");
		Long DFSpreviousTime = System.currentTimeMillis();
		DepthFS depth = DepthFS.getInstance();
		hanoi.solve(depth);	
		Long DFSduration = System.currentTimeMillis() - DFSpreviousTime;
		System.out.println("DFS duration: "+ DFSduration);
		
	}
	
}
