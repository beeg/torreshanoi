import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.heuristic.EvaluationFunction;


public class Heuristic2 extends EvaluationFunction{

	@Override
	public double calculateG(Node arg0) {
		return 0;
	}

	@Override
	public double calculateH(Node arg0) {
		Environment e = (Environment)arg0.getState();
		double disks=0;
		for (int i=0;i<e.getPegs().size();i++){
			if(!e.getPegs().get(i).equals(e.getDestination())){
				disks=disks+e.getPegs().get(i).getDisks().size();
			}
		}
		return disks;
	}

}
