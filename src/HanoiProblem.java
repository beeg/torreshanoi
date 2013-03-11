import java.util.ArrayList;

import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.SearchMethod;
import es.deusto.ingenieria.is.search.formulation.Operator;
import es.deusto.ingenieria.is.search.formulation.Problem;
import es.deusto.ingenieria.is.search.formulation.State;


public class HanoiProblem extends Problem	{

	private int numberOfPegs;
	private int numberOfDisks;
	
	public HanoiProblem(int numberOfPegs, int numberOfDisks) {
		super();
		this.numberOfPegs = numberOfPegs;
		this.numberOfDisks = numberOfDisks;
		createOperators();
	}


	/* (non-Javadoc)
	 * @see es.deusto.ingenieria.is.search.formulation.Problem#isFinalState(es.deusto.ingenieria.is.search.formulation.State)
	 *	 
	 *This method comfirm if the state given is a final state (if it´s the destination peg)
	 */
	public boolean isFinalState(State state)	{
		if(state!=null && state.getClass().equals(Environment.class))	{
			Environment e=(Environment)state;
			//Checking if the pegs are empty, avoiding the destination
			for(int i=0;i<e.getNumPegs();i++)	{
				if(e.getDestination()!=e.getPeg(i))	{
					if(!(e.getPeg(i).isEmpty()))	{
						return false;
					}
				}				
			}	
			//Checking if the destination has the expected number of disks
			return e.getDestination().getSize()==this.numberOfDisks;
		} else	{
			return false;
		}
	}
	
	/**
	 * Creates all the possible movements for each pair of Pegs
	 */
	public void createOperators()	{
		for(int j=0;j<numberOfPegs;j++)	{
			for(int i=0;i<numberOfPegs;i++)	{
				//Adds the operator to the list, avoiding the movement from one peg to itself
				if(j!=i)				
					this.addOperator(new MoveOperator(j,i));
			}
		}
	}
	
	/**
	 * Returns a String analysing the result passed by parameter
	 * @param result
	 * @return
	 */
	public String toString(boolean result)	{
		if(result)	{
			return "It is the final state.";
		} else	{
			return "It is not the final state.";
		}
	}
	
	/**
	 * Gets the operator specified by parameters
	 * @param origin
	 * @param destination
	 * @return
	 */
	public Operator getOperator(int origin,int destination)	{
		boolean found=false;
		MoveOperator operator=null;
		for(int i=0;i<this.getOperators().size()&&!found;i++)	{
			operator=(MoveOperator)this.getOperators().get(i);
			if(operator.getOrigin()==origin && operator.getDestination()==destination)	{
				found=true;				
			}
		}		
		return operator;
	}
	
	public int getNumberOfPegs() {
		return numberOfPegs;
	}


	public void setNumberOfPegs(int numberOfPegs) {
		this.numberOfPegs = numberOfPegs;
	}


	public int getNumberOfDisks() {
		return numberOfDisks;
	}


	public void setNumberOfDisks(int numberOfDisks) {
		this.numberOfDisks = numberOfDisks;
	}
	
	public State getInitialState()	{
		return this.getInitialStates().get(0);
	}
	
	/**
	 * @param arg0 Any search method (BFS, DFS ...)
	 * 
	 * Depending the search method it use one algorithim or other. 
	 */
	public void solve(SearchMethod arg0)	{
		if(arg0!=null)	{
			Node node=arg0.search(this, this.getInitialState());
			System.out.println("Total movements: "+node.getDepth());
			ArrayList<String> path = new ArrayList<String>();
			//Solution path 
			arg0.solutionPath(node,path);
			//Creating a solution log (all moves)
			arg0.createSolutionLog(path);
		}
	}


	public static void main(String[] args)	{
		//Creating a environment with these characteristics:
		//Number of pegs: 3
		//Origin peg: 1
		//Destination peg: 2
		//Number of disks: 3
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
		Environment finalEnv=new Environment((Environment)env,problem.numberOfPegs,problem.numberOfDisks);
		System.out.println(finalEnv.toString());
		System.out.println(problem.toString(problem.isFinalState(finalEnv)));
	}

}
