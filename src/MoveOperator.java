import es.deusto.ingenieria.is.search.formulation.Operator;
import es.deusto.ingenieria.is.search.formulation.State;


public class MoveOperator extends Operator{

	private int origin;
	private int destination;

	public MoveOperator(int origin, int destination) {
		super();
		this.origin = origin;
		this.destination = destination;
	}

	/* (non-Javadoc)
	 * @see es.deusto.ingenieria.is.search.formulation.Operator#effect(es.deusto.ingenieria.is.search.formulation.State)
	 * 
	 * This method is the one wich describes the effects of a move operation
	 */
	protected State effect(State arg0) {
		if(arg0!=null && arg0.getClass().equals(Environment.class))	{
			Environment e=(Environment)arg0;
			Peg origin=e.getPegs().get(this.origin);
			Peg destination=e.getPegs().get(this.destination);
			//Getting the origin top disk and adding it to the destination peg
			destination.addDisk(origin.getDisks().pop());
			//Reallocating pegs
			e.setPeg(origin.getPosition(), origin);
			e.setPeg(destination.getPosition(), destination);
			return e;
		} else	{
			return null;
		}		
	}

	/* (non-Javadoc)
	 * @see es.deusto.ingenieria.is.search.formulation.Operator#isApplicable(es.deusto.ingenieria.is.search.formulation.State)
	 * 
	 * This method indicates if this move is applicable in the given state
	 */
	protected boolean isApplicable(State arg0) {
		if(arg0!=null && arg0.getClass().equals(Environment.class))	{
			Environment e=(Environment)arg0;
			Peg origin=e.getPegs().get(this.origin);
			Peg destination=e.getPegs().get(this.destination);
			//looking if both pegs are empty (origin and destination)
			if(origin.getDisks().isEmpty())	{
				return false;
			} else	{
				if(destination.getDisks().isEmpty())	{
					return true;
				} else	{
					//using peek() to look the top disk without holding it
					Disk originDisk=origin.getDisks().peek();
					Disk destinationDisk=destination.getDisks().peek();
					//looking if the disk we want to move is smaller than destination peg have in the top
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
