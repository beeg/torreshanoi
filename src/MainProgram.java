import es.deusto.ingenieria.is.search.algorithms.blind.BreadthFS;
import es.deusto.ingenieria.is.search.algorithms.blind.DepthFS;
//import es.deusto.ingenieria.is.search.formulation.State;
//import java.util.Random;
//import java.util.Scanner;

public class MainProgram {
	
	public static void main(String[] args)	{
		
		/*
		 *First test:
		 *
		 * Pegs:3
		 * Disks:4
		 * Origin peg: 1
		 * Destination peg: 3
		 * 
		 */
		System.out.println("Test: 3 pegs and 4 disks");
		//Creating the environment
		Environment env1 = new Environment(3,1,3,4);
		System.out.println("Number of pegs: "+env1.getNumPegs());
		System.out.println("Origin peg: "+(env1.getOriginPos()+1));
		System.out.println("Destination peg: "+(env1.getDestPos()+1));
		//Creating the specific Hanoi Problem
		HanoiProblem hanoiProblem1 = new HanoiProblem(3,4);
		System.out.println("Number of disks: "+hanoiProblem1.getNumberOfDisks());
		//Adding the initial state
		hanoiProblem1.addInitialState(env1);
		
		//BFS test
		System.out.println("\nBFS test: ");
		//Creating BFS algorithm, by getting an instance of it
		BreadthFS breadth = BreadthFS.getInstance();
		//Save the system time before the algorithm is executed
		Long BFSpreviousTime = System.currentTimeMillis();
		//Solving the problem
		hanoiProblem1.solve(breadth);
		//Getting the total amount of time that the system has made use of
		Long BFSduration = System.currentTimeMillis() - BFSpreviousTime;
		System.out.println("BFS total duration: "+ BFSduration);
		
		//DFS test
		System.out.println("\nDFS test: ");
		//Creating DFS algorithm, by getting an instance of it
		DepthFS depth = DepthFS.getInstance();
		//Save the system time before the algorithm is executed
		Long DFSpreviousTime = System.currentTimeMillis();
		//Solving the problem
		hanoiProblem1.solve(depth);
		//Getting the total amount of time that the system has made use of
		Long DFSduration = System.currentTimeMillis() - DFSpreviousTime;
		System.out.println("DFS total duration: "+ DFSduration);
		
		
		
		//BFS optimos, estables
		//DFS no optimos, varian segun origen y destino especificado
		
		
		/*
		 *Second test:
		 *
		 * Pegs:3
		 * Disks:6
		 * Origin peg: 1
		 * Destination peg: 3
		 * 
		 */
		System.out.println("\nTest: 3 pegs and 6 disks");
		Environment env2 = new Environment(3,1,3,6);
		System.out.println("Number of pegs: "+env2.getNumPegs());
		System.out.println("Origin peg: "+(env2.getOriginPos()+1));
		System.out.println("Destination peg: "+(env2.getDestPos()+1));
		HanoiProblem hanoiProblem2 = new HanoiProblem(3,6);
		System.out.println("Number of disks: "+hanoiProblem2.getNumberOfDisks());
		hanoiProblem2.addInitialState(env2);
		
		//BFS test
		System.out.println("\nBFS test: ");
		breadth = BreadthFS.getInstance();
		BFSpreviousTime = System.currentTimeMillis();
		hanoiProblem2.solve(breadth);
		BFSduration = System.currentTimeMillis() - BFSpreviousTime;
		System.out.println("BFS duration: "+ BFSduration);
		
		//DFS test
		System.out.println("\nDFS test: ");
		depth = DepthFS.getInstance();
		DFSpreviousTime = System.currentTimeMillis();
		hanoiProblem2.solve(depth);	
		DFSduration = System.currentTimeMillis() - DFSpreviousTime;
		System.out.println("DFS duration: "+ DFSduration);
		
		/*
		 *Third test:
		 *
		 * Number of Pegs:4
		 * Number of Disks:6
		 * Origin peg: 1
		 * Destination peg: 3
		 * 
		 */
		System.out.println("\nTest: 4 pegs and 6 disks");
		Environment env3 = new Environment(4,1,3,6);
		System.out.println("Number of pegs: "+env3.getNumPegs());
		System.out.println("Origin peg: "+(env3.getOriginPos()+1));
		System.out.println("Destination peg: "+(env3.getDestPos()+1));
		HanoiProblem hanoiProblem3 = new HanoiProblem(4,6);
		System.out.println("Number of disks: "+hanoiProblem3.getNumberOfDisks());
		hanoiProblem3.addInitialState(env3);
		
		//BFS test
		System.out.println("\nBFS test: ");
		breadth = BreadthFS.getInstance();
		BFSpreviousTime = System.currentTimeMillis();
		hanoiProblem3.solve(breadth);
		BFSduration = System.currentTimeMillis() - BFSpreviousTime;
		System.out.println("BFS duration: "+ BFSduration);
		
		//DFS test
		System.out.println("\nDFS test: ");
		depth = DepthFS.getInstance();
		DFSpreviousTime = System.currentTimeMillis();
		hanoiProblem3.solve(depth);	
		DFSduration = System.currentTimeMillis() - DFSpreviousTime;
		System.out.println("DFS duration: "+ DFSduration);
		
		/*
		 *Fourth test:
		 *
		 * Pegs:4
		 * Disks:6
		 * Origin peg: 2 (Origin peg changed, in order to compare results)
		 * Destination peg: 4 (Destination peg changed, in order to compare results)
		 * 
		 */
		System.out.println("\nTest: 4 pegs and 6 disks");		
		Environment env4 = new Environment(4,2,4,6);
		System.out.println("Number of pegs: "+env4.getNumPegs());
		System.out.println("Origin peg: "+(env4.getOriginPos()+1));
		System.out.println("Destination peg: "+(env4.getDestPos()+1));
		HanoiProblem hanoiProblem4 = new HanoiProblem(4,6);
		System.out.println("Number of disks: "+hanoiProblem4.getNumberOfDisks());
		hanoiProblem4.addInitialState(env4);
		
		//BFS test
		System.out.println("\nBFS test: ");
		breadth = BreadthFS.getInstance();
		BFSpreviousTime = System.currentTimeMillis();
		hanoiProblem4.solve(breadth);
		BFSduration = System.currentTimeMillis() - BFSpreviousTime;
		System.out.println("BFS duration: "+ BFSduration);
		
		//DFS test
		System.out.println("\nDFS test: ");
		depth = DepthFS.getInstance();
		DFSpreviousTime = System.currentTimeMillis();
		hanoiProblem4.solve(depth);	
		DFSduration = System.currentTimeMillis() - DFSpreviousTime;
		System.out.println("DFS duration: "+ DFSduration);
		
		/*
		 * Conclusions
		 * 
		 * Breadth First Search(BFS) has a time complexity higher than Depth First Search(DFS),
		 * however we can affirm it is a complete algorithm, since sooner or later it would
		 * find the final state. Also, regarding optimality, we could say that is an optimal
		 * algorithm, considering all actions have the same cost.
		 * 
		 * Number of disks is not a factor that has a major importance during the execution
		 * of a BFD algorithm, neither the origin and destination pegs selected, these are not
		 * elements that generate a great difference.
		 * 
		 * However, Depth First Search is more vulnerable to the factors previously mentioned.
		 * First, we could not affirm that is an optimal algorithm, since it can get lost in
		 * an infinite depth path, so neither completeness could be assured. 
		 * 
		 * Regarding time complexity, in the best case it is much better than in a BFS algorithm.
		 * But the worst case is much worse than the BFS's, since it becomes into an exponential
		 * case.
		 * 
		 * Other factors that also have a major importance in DFS algorithms are the
		 * pegs specified as origin and destination, since depending on which are selected
		 * the algorithm performance varies hugely. A clear example is the last test we have
		 * performed.
		 * 
		 */
		
		
		//P1.2 Task tests
		
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
		System.out.println(problem.toString(problem.isFinalState(env)));*/
	}
	
}
