import es.deusto.ingenieria.is.search.formulation.Operator;
import es.deusto.ingenieria.is.search.formulation.State;


public class MoveOperator extends Operator{

	//Position of the pegs that form the movement
	private int origin;
	private int destination;

	public MoveOperator(int origin, int destination) {
		super();
		this.origin = origin;
		this.destination = destination;
	}

	protected State effect(State arg0) {
		if(arg0!=null && arg0.getClass().equals(Environment.class))	{
			Environment e=(Environment)arg0;
			Peg origin=e.getPeg(this.origin);
			Peg destination=e.getPeg(this.destination);
			destination.push(origin.pop());
			e.setPeg(this.origin, origin);
			e.setPeg(this.destination, destination);
			return (Environment) e.clone();
		} else	{
			return null;
		}		
	}

	protected boolean isApplicable(State arg0) {
		if(arg0!=null && arg0.getClass().equals(Environment.class))	{
			Environment e=(Environment)arg0;			
			Peg origin=e.getPeg(this.origin);
			Peg destination=e.getPeg(this.destination);
			if(origin.isEmpty())	{
				System.out.println("This movement is not applicable");
				return false;
			} else	{
				if(destination.isEmpty())	{
					System.out.println("This movement is applicable");
					return true;
				} else	{
					Disk originDisk=origin.getPeek();
					Disk destinationDisk=destination.getPeek();
					if(originDisk.getSize()<destinationDisk.getSize())	{
						System.out.println("This movement is applicable");
						return true;
					} else	{
						System.out.println("This movement is not applicable");
						return false;
					}
				}
			}
		} else	{
			System.out.println("This movement is not applicable");
			return false;
		}
	}

	public int getOrigin() {
		return origin;
	}

	public void setOrigin(int origin) {
		this.origin = origin;
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}
	
	public String toString()	{
		return "Origin peg: "+(this.origin+1)+"\nDestination peg: "+(this.destination+1)+"\n";
	}
	
	public static void main(String[] args)	{
		//Creating a environment with these characteristics:
		//Number of pegs: 3
		//Origin peg: 1
		//Destination peg: 2
		//Number of disks: 3
		Environment env = new Environment(3,1,2,3);
		System.out.println(env.toString());
		
		System.out.println("Movement from peg 1 to peg 2");
		MoveOperator operator= new MoveOperator(0,1);
		System.out.println(operator.toString());
		
		//Checking if it is applicable and applying it if it's possible
		if(operator.isApplicable(env))	{
			env=(Environment)operator.effect(env);
			System.out.println(env.toString());
		}
		
		//Making an unapplicable movement
		System.out.println("Movement from peg 1 to peg 2");
		operator= new MoveOperator(0,1);
		System.out.println(operator.toString());
		
		//Checking if it is applicable and applying it if it's possible
		if(operator.isApplicable(env))	{
			env=(Environment)operator.effect(env);
			System.out.println(env.toString());
		}
	}

}
