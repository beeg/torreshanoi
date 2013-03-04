import es.deusto.ingenieria.is.search.formulation.Problem;
import es.deusto.ingenieria.is.search.formulation.State;


public class HanoiProblem extends Problem	{
	
	private int numberOfPegs;
	private int numberOfDisks;
	
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
	
	public void createOperators()	{
		
	}

}
