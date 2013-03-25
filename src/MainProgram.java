
import Heuristics.Heuristic1;
import Heuristics.Heuristic2;
import SearchAlgorithms.HillClimbing;
import SearchFormulation.Environment;
import SearchFormulation.HanoiProblem;
import es.deusto.ingenieria.is.search.algorithms.blind.BreadthFS;
import es.deusto.ingenieria.is.search.algorithms.blind.DepthFS;
import es.deusto.ingenieria.is.search.algorithms.heuristic.BestFS;

public class MainProgram {
	
	public static void main(String[] args)	{	
		//Comparison between BestFS with Heuristic 1 and Heuristic 2
		System.out.println("3 Pegs, 6 disks: ");
		Environment env1 = new Environment(3,1,3,6);
		HanoiProblem hanoiProblem1 = new HanoiProblem(3,6);
		hanoiProblem1.addInitialState(env1);
		
		System.out.println("BestFS(Heuristic1): ");
		BestFS best = new BestFS(new Heuristic1());
		hanoiProblem1.solve(best);
		
		System.out.println("BestFS(Heuristic2): ");
		best = new BestFS(new Heuristic2());
		hanoiProblem1.solve(best);
		
		System.out.println("4 Pegs, 6 Disks: ");
		Environment env2 = new Environment(4,1,4,6);
		HanoiProblem hanoiProblem2 = new HanoiProblem(4,6);
		hanoiProblem2.addInitialState(env2);
		
		System.out.println("BestFS(Heuristic1): ");
		BestFS best2 = new BestFS(new Heuristic1());
		hanoiProblem2.solve(best2);
		
		System.out.println("BestFS(Heuristic2): ");
		best2 = new BestFS(new Heuristic2());
		hanoiProblem2.solve(best2);
		
		//Comparison between BestFS(Heuristic 1 and Heuristic 2), BFS, DFS
		System.out.println("3 Pegs, 6 disks: ");
		Environment env3 = new Environment(3,1,3,6);
		HanoiProblem hanoiProblem3 = new HanoiProblem(3,6);
		hanoiProblem3.addInitialState(env3);
		
		System.out.println("BestFS(Heuristic1): ");		
		BestFS best3 = new BestFS(new Heuristic1());
		//Save the system time before the algorithm is executed
		Long BestFSH1previousTime = System.currentTimeMillis();
		hanoiProblem3.solve(best3);
		//Getting the total amount of time that the system has made use of
		Long BestFSH1duration = System.currentTimeMillis() - BestFSH1previousTime;
		System.out.println("BestFS Heuristic 1 total duration: "+ BestFSH1duration);
		
		System.out.println("BestFS(Heuristic2): ");
		best3 = new BestFS(new Heuristic2());
		//Save the system time before the algorithm is executed
		Long BestFSH2previousTime = System.currentTimeMillis();
		hanoiProblem3.solve(best3);
		//Getting the total amount of time that the system has made use of
		Long BestFSH2duration = System.currentTimeMillis() - BestFSH2previousTime;
		System.out.println("BestFS Heuristic 2 total duration: "+ BestFSH2duration);
		
		System.out.println("BFS: ");
		BreadthFS breadth = BreadthFS.getInstance();
		//Save the system time before the algorithm is executed
		Long BFSpreviousTime = System.currentTimeMillis();
		hanoiProblem3.solve(breadth);
		//Getting the total amount of time that the system has made use of
		Long BFSduration = System.currentTimeMillis() - BFSpreviousTime;
		System.out.println("BFS total duration: "+ BFSduration);
		
		System.out.println("DFS: ");
		DepthFS depth = DepthFS.getInstance();
		//Save the system time before the algorithm is executed
		Long DFSpreviousTime = System.currentTimeMillis();
		hanoiProblem3.solve(depth);
		//Getting the total amount of time that the system has made use of
		Long DFSduration = System.currentTimeMillis() - DFSpreviousTime;
		System.out.println("DFS total duration: "+ DFSduration);
		
		
		System.out.println("4 Pegs, 6 Disks: ");
		Environment env4 = new Environment(4,1,4,6);
		HanoiProblem hanoiProblem4 = new HanoiProblem(4,6);
		hanoiProblem4.addInitialState(env4);
		
		System.out.println("BestFS(Heuristic1): ");
		BestFS best4 = new BestFS(new Heuristic1());
		//Save the system time before the algorithm is executed
		BestFSH1previousTime = System.currentTimeMillis();
		hanoiProblem4.solve(best4);
		BestFSH1duration = System.currentTimeMillis() - BestFSH1previousTime;
		System.out.println("BestFS Heuristic 1 total duration: "+ BestFSH1duration);
		
		System.out.println("BestFS(Heuristic2): ");
		best4 = new BestFS(new Heuristic2());
		//Save the system time before the algorithm is executed
		BestFSH2previousTime = System.currentTimeMillis();
		hanoiProblem4.solve(best4);
		//Getting the total amount of time that the system has made use of
		BestFSH2duration = System.currentTimeMillis() - BestFSH2previousTime;
		System.out.println("BestFS Heuristic 2 total duration: "+ BestFSH2duration);
		
		System.out.println("BFS: ");
		BreadthFS breadth2 = BreadthFS.getInstance();
		//Save the system time before the algorithm is executed
		BFSpreviousTime = System.currentTimeMillis();
		hanoiProblem4.solve(breadth2);
		//Getting the total amount of time that the system has made use of
		BFSduration = System.currentTimeMillis() - BFSpreviousTime;
		System.out.println("BFS total duration: "+ BFSduration);
		
		System.out.println("DFS: ");
		DepthFS depth2 = DepthFS.getInstance();
		//Save the system time before the algorithm is executed
		DFSpreviousTime = System.currentTimeMillis();
		hanoiProblem4.solve(depth2);
		//Getting the total amount of time that the system has made use of
		DFSduration = System.currentTimeMillis() - DFSpreviousTime;
		System.out.println("DFS total duration: "+ DFSduration);
		
		//Comparison between HillClimbig with Heuristic 1 and Heuristic 2
		System.out.println("3 Pegs, 6 disks: ");
		Environment env5 = new Environment(3,1,3,6);
		HanoiProblem hanoiProblem5 = new HanoiProblem(3,6);
		hanoiProblem5.addInitialState(env5);
		
		System.out.println("HillClimbing(Heuristic1): ");
		HillClimbing hillC = new HillClimbing(new Heuristic1());
		//Save the system time before the algorithm is executed
		Long HillCH1previousTime = System.currentTimeMillis();
		hanoiProblem5.solve(hillC);
		//Getting the total amount of time that the system has made use of
		Long HillCH1duration = System.currentTimeMillis() - HillCH1previousTime;
		System.out.println("Hill Climbing Heuristic 1 total duration: "+ HillCH1duration);
		
		System.out.println("HillClimbing(Heuristic2): ");
		hillC = new HillClimbing(new Heuristic2());
		//Save the system time before the algorithm is executed
		Long HillCH2previousTime = System.currentTimeMillis();
		hanoiProblem5.solve(hillC);
		//Getting the total amount of time that the system has made use of
		Long HillCH2duration = System.currentTimeMillis() - HillCH2previousTime;
		System.out.println("Hill Climbing Heuristic 2 total duration: "+ HillCH2duration);
		
		System.out.println("BFS: ");
		BreadthFS breadth3 = BreadthFS.getInstance();
		//Save the system time before the algorithm is executed
		BFSpreviousTime = System.currentTimeMillis();
		hanoiProblem5.solve(breadth3);
		//Getting the total amount of time that the system has made use of
		BFSduration = System.currentTimeMillis() - BFSpreviousTime;
		System.out.println("BFS total duration: "+ BFSduration);
		
		System.out.println("DFS: ");
		DepthFS depth3 = DepthFS.getInstance();
		//Save the system time before the algorithm is executed
		DFSpreviousTime = System.currentTimeMillis();
		hanoiProblem5.solve(depth3);
		//Getting the total amount of time that the system has made use of
		DFSduration = System.currentTimeMillis() - DFSpreviousTime;
		System.out.println("DFS total duration: "+ DFSduration);
		
		
		System.out.println("4 Pegs, 6 Disks: ");
		Environment env6 = new Environment(4,1,4,6);
		HanoiProblem hanoiProblem6 = new HanoiProblem(4,6);
		hanoiProblem6.addInitialState(env6);
		
		System.out.println("HillClimbing(Heuristic1): ");
		HillClimbing hillC2 = new HillClimbing(new Heuristic1());
		//Save the system time before the algorithm is executed
		HillCH1previousTime = System.currentTimeMillis();
		hanoiProblem6.solve(hillC2);
		//Getting the total amount of time that the system has made use of
		HillCH1duration = System.currentTimeMillis() - HillCH1previousTime;
		System.out.println("Hill Climbing Heuristic 1 total duration: "+ HillCH1duration);
		
		System.out.println("HillClimbing(Heuristic2): ");
		hillC2 = new HillClimbing(new Heuristic2());
		//Save the system time before the algorithm is executed
		HillCH2previousTime = System.currentTimeMillis();
		hanoiProblem6.solve(hillC2);
		//Getting the total amount of time that the system has made use of
		HillCH2duration = System.currentTimeMillis() - HillCH2previousTime;
		System.out.println("Hill Climbing Heuristic 2 total duration: "+ HillCH2duration);
		
		System.out.println("BFS: ");
		BreadthFS breadth4 = BreadthFS.getInstance();
		//Save the system time before the algorithm is executed
		BFSpreviousTime = System.currentTimeMillis();
		hanoiProblem5.solve(breadth4);
		//Getting the total amount of time that the system has made use of
		BFSduration = System.currentTimeMillis() - BFSpreviousTime;
		System.out.println("BFS total duration: "+ BFSduration);
		
		System.out.println("DFS: ");
		DepthFS depth4 = DepthFS.getInstance();
		//Save the system time before the algorithm is executed
		DFSpreviousTime = System.currentTimeMillis();
		hanoiProblem5.solve(depth4);
		//Getting the total amount of time that the system has made use of
		DFSduration = System.currentTimeMillis() - DFSpreviousTime;
		System.out.println("DFS total duration: "+ DFSduration);
	}
	
}
