import java.util.Random;
import java.util.Scanner;

import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.blind.BreadthFS;
import es.deusto.ingenieria.is.search.algorithms.blind.DepthFS;
import es.deusto.ingenieria.is.search.algorithms.heuristic.BestFS;
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
		
		/*
		 *First test:
		 *
		 * Pegs:3
		 * Disks:4
		 * Origin peg: 1
		 * Destination peg: 3
		 * 
		 */
		/*System.out.println("3 pegs and 4 disks");
		//creating the environment
		Environment env1 = new Environment(3,1,3,4);
		//creating the specific Hanoi Problem
		HanoiProblem hanoiProblem1 = new HanoiProblem(3,4);
		//adding the initial state
		hanoiProblem1.addInitialState(env1);
		
		//BFS test
		System.out.println("BFS test: ");
		//creating BFS algorithim with getting an instance
		BreadthFS breadth = BreadthFS.getInstance();
		//Save the previous system time
		Long BFSpreviousTime = System.currentTimeMillis();
		//Solving the problem
		hanoiProblem1.solve(breadth);
		//Getting the total amount of time that the system need
		Long BFSduration = System.currentTimeMillis() - BFSpreviousTime;
		System.out.println("BFS duration: "+ BFSduration);
		
		//DFS test
		System.out.println("DFS test: ");
		//creating DFS algorithim with getting an instance
		DepthFS depth = DepthFS.getInstance();
		//Save the previous system time
		Long DFSpreviousTime = System.currentTimeMillis();
		//Solving the problem
		hanoiProblem1.solve(depth);	
		//Getting the total amount of time that the system need
		Long DFSduration = System.currentTimeMillis() - DFSpreviousTime;
		System.out.println("DFS duration: "+ DFSduration);
		
		
		
		//BFS optimos, estables
		//DFS no optimos, varian segun origen y destino especificado
		
		
		/*
		 *First test:
		 *
		 * Pegs:3
		 * Disks:6
		 * Origin peg: 1
		 * Destination peg: 3
		 * 
		 */
		/*System.out.println("\n3 pegs and 6 disks");
		Environment env2 = new Environment(3,1,3,6);
		HanoiProblem hanoiProblem2 = new HanoiProblem(3,6);
		hanoiProblem2.addInitialState(env2);
		
		//BFS test
		System.out.println("BFS test: ");
		breadth = BreadthFS.getInstance();
		BFSpreviousTime = System.currentTimeMillis();
		hanoiProblem2.solve(breadth);
		BFSduration = System.currentTimeMillis() - BFSpreviousTime;
		System.out.println("BFS duration: "+ BFSduration);
		
		//DFS test
		System.out.println("DFS test: ");
		depth = DepthFS.getInstance();
		DFSpreviousTime = System.currentTimeMillis();
		hanoiProblem2.solve(depth);	
		DFSduration = System.currentTimeMillis() - DFSpreviousTime;
		System.out.println("DFS duration: "+ DFSduration);*/
		
		/*
		 *First test:
		 *
		 * Pegs:4
		 * Disks:6
		 * Origin peg: 1
		 * Destination peg: 3
		 * 
		 */
		/*System.out.println("\n4 pegs and 6 disks");
		Environment env3 = new Environment(4,1,3,6);
		HanoiProblem hanoiProblem3 = new HanoiProblem(4,6);
		hanoiProblem3.addInitialState(env3);
		
		//BFS test
		System.out.println("BFS test: ");
		breadth = BreadthFS.getInstance();
		BFSpreviousTime = System.currentTimeMillis();
		hanoiProblem3.solve(breadth);
		BFSduration = System.currentTimeMillis() - BFSpreviousTime;
		System.out.println("BFS duration: "+ BFSduration);
		
		//DFS test
		System.out.println("DFS test: ");
		depth = DepthFS.getInstance();
		DFSpreviousTime = System.currentTimeMillis();
		hanoiProblem3.solve(depth);	
		DFSduration = System.currentTimeMillis() - DFSpreviousTime;
		System.out.println("DFS duration: "+ DFSduration);*/
		
		/*
		 *First test:
		 *
		 * Pegs:4
		 * Disks:6
		 * Origin peg: 2 (Origin peg changed to compare results)
		 * Destination peg: 4 (Destination peg changed to compare results)
		 * 
		 */
		/*System.out.println("\n4 pegs and 6 disks");
		Environment env4 = new Environment(4,2,4,6);
		HanoiProblem hanoiProblem4 = new HanoiProblem(4,6);
		hanoiProblem4.addInitialState(env4);
		
		//BFS test
		System.out.println("BFS test: ");
		breadth = BreadthFS.getInstance();
		BFSpreviousTime = System.currentTimeMillis();
		hanoiProblem4.solve(breadth);
		BFSduration = System.currentTimeMillis() - BFSpreviousTime;
		System.out.println("BFS duration: "+ BFSduration);
		
		//DFS test
		System.out.println("DFS test: ");
		depth = DepthFS.getInstance();
		DFSpreviousTime = System.currentTimeMillis();
		hanoiProblem4.solve(depth);	
		DFSduration = System.currentTimeMillis() - DFSpreviousTime;
		System.out.println("DFS duration: "+ DFSduration);*/
		
		System.out.println("3 Pegs, 6 disks: ");
		Environment env5 = new Environment(3,1,3,6);
		HanoiProblem hanoiProblem5 = new HanoiProblem(3,6);
		hanoiProblem5.addInitialState(env5);
		
		System.out.println("BestFS(Heuristic1): ");
		BestFS best = new BestFS(new Heuristic1());
		hanoiProblem5.solve(best);
		
		System.out.println("BestFS(Heuristic2): ");
		best = new BestFS(new Heuristic2());
		hanoiProblem5.solve(best);
		
		System.out.println("4 Pegs, 6 Disks: ");
		Environment env6 = new Environment(4,1,4,6);
		HanoiProblem hanoiProblem6 = new HanoiProblem(4,6);
		hanoiProblem6.addInitialState(env6);
		
		System.out.println("BestFS(Heuristic1): ");
		BestFS best2 = new BestFS(new Heuristic1());
		hanoiProblem6.solve(best2);
		
		System.out.println("BestFS(Heuristic2): ");
		best2 = new BestFS(new Heuristic2());
		hanoiProblem6.solve(best2);
	}
	
}
