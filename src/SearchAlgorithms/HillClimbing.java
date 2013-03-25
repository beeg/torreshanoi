package SearchAlgorithms;

import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.heuristic.EvaluationFunction;
import es.deusto.ingenieria.is.search.algorithms.heuristic.HeuristicSearchMethod;
import es.deusto.ingenieria.is.search.formulation.Operator;
import es.deusto.ingenieria.is.search.formulation.Problem;
import es.deusto.ingenieria.is.search.formulation.State;


public class HillClimbing extends HeuristicSearchMethod{

	public HillClimbing(EvaluationFunction function) {
		super(function);
	}

	public Node search(Problem problem, State initialState) {
		Node currentNode = new Node(initialState);
		currentNode.setH(this.getEvaluationFunction().calculateH(currentNode));
		boolean local_best =false;
		Node bestSuccessor; 
		while(!local_best){
			bestSuccessor = this.expand(currentNode,problem);
			if(currentNode.getH()<=bestSuccessor.getH()){
				local_best=true;
			}
			else 
				currentNode = bestSuccessor;
		}
		return currentNode;
	}
	protected Node expand(Node node, Problem problem){
		Node successorNode = null;
		State currentState = node.getState();
		State successorState = null;
		//first succesor
		Node bestSuccessor = null;
		//all other succesors
		if(currentState!=null){
			for (Operator operator : problem.getOperators()){		
				successorState = operator.apply(currentState);				
				if (successorState!= null) {									
					successorNode = new Node(successorState);
					successorNode.setOperator(operator.getName());
					successorNode.setParent(node);
					successorNode.setDepth(node.getDepth() + 1);
					successorNode.setH(this.getEvaluationFunction().calculateH(successorNode));
					if(bestSuccessor==null || successorNode.getH()<bestSuccessor.getH()){
						bestSuccessor=successorNode;
					}
				}
			}
		}
		return bestSuccessor;
	}
}
