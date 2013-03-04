import es.deusto.ingenieria.is.search.formulation.Operator;
import es.deusto.ingenieria.is.search.formulation.State;


public class MoveOperator extends Operator{

	private Peg origin;
	private Peg destination;
	
	public MoveOperator(Peg origin, Peg destination) {
		super();
		this.origin = origin;
		this.destination = destination;
	}

	protected State effect(State arg0) {
		if(arg0!=null)	{
			Environment e=(Environment)arg0;
			Peg origin=e.getPegs().get(this.origin.getPosition());
			Peg destination=e.getPegs().get(this.destination.getPosition());
			if(destination.getDisks().isEmpty())	{
				return true;
			} else	{
				return false; ////
			}
			
			
			return null;
		} else	{
			return null;
		}		
	}

	protected boolean isApplicable(State arg0) {
		if(arg0!=null && arg0.getClass().equals(Environment.class))	{
			Environment e=(Environment)arg0;
			Peg origin=e.getPegs().
			
			
			return false;
		} else	{
			return false;
		}
	}

}
