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
		if(arg0!=null && arg0.getClass().equals(Environment.class))	{
			Environment e=(Environment)arg0;
			Peg origin=e.getPegs().get(this.origin.getPosition());
			Peg destination=e.getPegs().get(this.destination.getPosition());
			destination.getDisks().push(origin.getDisks().pop());
			e.setPeg(origin.getPosition(), origin);
			e.setPeg(destination.getPosition(), destination);
			return e;
		} else	{
			return null;
		}		
	}

	protected boolean isApplicable(State arg0) {
		if(arg0!=null && arg0.getClass().equals(Environment.class))	{
			Environment e=(Environment)arg0;
			Peg origin=e.getPegs().get(this.origin.getPosition());
			Peg destination=e.getPegs().get(this.destination.getPosition());
			if(origin.getDisks().isEmpty())	{
				return false;
			} else	{
				if(destination.getDisks().isEmpty())	{
					return true;
				} else	{
					Disk originDisk=origin.getDisks().peek();
					Disk destinationDisk=destination.getDisks().peek();
					if(originDisk.getSize()<destinationDisk.getSize())	{
						return true;
					} else	{
						return false;
					}
				}
			}
		} else	{
			return false;
		}
	}

}
