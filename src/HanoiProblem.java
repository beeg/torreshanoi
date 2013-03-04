import es.deusto.ingenieria.is.search.formulation.Problem;
import es.deusto.ingenieria.is.search.formulation.State;


public class HanoiProblem extends Problem	{
	
	private int numberOfPegs;
	private int numberOfDisks;
	
	/* (non-Javadoc)
	 * @see es.deusto.ingenieria.is.search.formulation.Problem#isFinalState(es.deusto.ingenieria.is.search.formulation.State)
	 *	 
	 *This method comfirm if the state given is a final state (if it´s the destination peg)
	 */
	public boolean isFinalState(State state)	{
		if(state!=null && state.getClass().equals(Environment.class))	{
			Environment e=(Environment)state;
			for(int i=0;i<e.getPegs().size();i++)	{
				if(e.getDestination().getPosition()!=e.getPegs().get(i).getPosition())	{
					if(!(e.getPegs().get(i).getDisks().isEmpty()))	{
						return false;
					}
				}				
			}
			
			return e.getDestination().getDisks().size()==this.numberOfDisks;
		} else	{
			return false;
		}
	}
	
	/**
	 * Creates moves (operators) for each pair of Pegs, in other words, all of posible combination of moves
	 */
	public void createOperators()	{
		for(int j=0;j<numberOfPegs;j++)	{
			for(int i=0;i<numberOfPegs;i++)	{
				this.addOperator(new MoveOperator(j,i));
			}
		}
	}

}
