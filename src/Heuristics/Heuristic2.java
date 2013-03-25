package Heuristics;

import SearchFormulation.Environment;
import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.heuristic.EvaluationFunction;

//Disks that aren't at the destination
public class Heuristic2 extends EvaluationFunction{

	@Override
	public double calculateG(Node arg0) {
		return 0;
	}

	@Override
	public double calculateH(Node arg0) {
		Environment e = (Environment)arg0.getState();
		double disks=0;
		for (int i=0;i<e.getNumPegs();i++){
			if(!e.getPeg(i).equals(e.getDestination())){
				disks=disks+e.getPeg(i).getSize();
			}
		}
		return disks;
	}

}
