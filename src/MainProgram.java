
import Heuristics.Heuristic1;
import Heuristics.Heuristic2;
import SearchFormulation.Environment;
import SearchFormulation.HanoiProblem;
import es.deusto.ingenieria.is.search.algorithms.heuristic.BestFS;

public class MainProgram {
	
	public static void main(String[] args)	{
		
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
