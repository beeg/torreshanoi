import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.heuristic.EvaluationFunction;
import es.deusto.ingenieria.is.search.algorithms.heuristic.HeuristicSearchMethod;


public class Heuristic1 extends EvaluationFunction{

	@Override
	public double calculateG(Node arg0) {
		return 0;
	}

	@Override
	public double calculateH(Node arg0) {
		Environment e = (Environment)(arg0.getState());		
		return e.getOrigin().getDisks().size();
		
		
	}

}
