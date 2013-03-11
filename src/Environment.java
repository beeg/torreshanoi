import java.util.ArrayList;
import java.util.Stack;

import es.deusto.ingenieria.is.search.formulation.State;


public class Environment extends State implements Cloneable	{

	private Peg origin;
	private Peg destination;
	private ArrayList<Peg> pegs;
	
	/**
	 * @param numPegs
	 * @param origin
	 * @param dest
	 * @param numDisks
	 * 
	 * Creates a Environment with 4 parameters: number of pegs, origin peg, destination peg and the number of disks
	 */
	public Environment(int numPegs, int origin, int dest, int numDisks)	{
		//Allocating space for the pegs
		this.pegs = new ArrayList<Peg>(numPegs);
		//Adding all pegs
		for(int i=0;i<numPegs;i++)	{
			this.pegs.add(new Peg(i));
		}
		this.origin=this.pegs.get(origin-1);
		this.destination=this.pegs.get(dest-1);
		//Adding all disks on the origin peg
		for(int i=0;i<numDisks;i++)	{
			this.origin.push(new Disk(numDisks-i));
		}
	}
	
	/**
	 * Just for testing, it creates the final state directly
	 * @param e
	 * @param numPegs
	 * @param numDisks
	 */
	public Environment(Environment e,int numPegs,int numDisks)	{
		//Allocating space for the pegs
		this.pegs = new ArrayList<Peg>(numPegs);
		//Adding all pegs
		for(int i=0;i<numPegs;i++)	{
			this.pegs.add(new Peg(i));
		}
		this.origin=this.pegs.get(e.getOrigin().getPosition());
		this.destination=this.pegs.get(e.getDestination().getPosition());
		//Adding all disks on the origin peg
		for(int i=0;i<numDisks;i++)	{
			this.destination.push(new Disk(numDisks-i));
		}
	}
	
	/* (non-Javadoc)
	 * @see es.deusto.ingenieria.is.search.formulation.State#toString()
	 * 
	 * To String method overrided to return all the atributes organized carefully
	 */
	public String toString()	{
		String number="Number of pegs: "+pegs.size()+"\n";
		String originPeg="Origin peg: \n"+origin.toString()+"\n";
		String destinationPeg="Destination peg: \n"+destination.toString()+"\n";
		String restPegs="Rest of pegs: "+"\n";
		for(int i=0;i<pegs.size();i++)	{
			if(!(pegs.get(i).getPosition()==origin.getPosition() || pegs.get(i).getPosition()==destination.getPosition()))
				restPegs=restPegs + pegs.get(i).toString();
		}
		return number+originPeg+destinationPeg+restPegs;
	}

	/* (non-Javadoc)
	 * @see es.deusto.ingenieria.is.search.formulation.State#equals(java.lang.Object)
	 * 
	 * Equals method override 
	 */
	public boolean equals(Object o) {
		//looking if the o is and Enviroment class object
		if(o!=null && o.getClass().equals(this.getClass()))	{
			Environment e = (Environment)o;
			if(this.pegs.size()==e.pegs.size())	{ //Equals on number of pegs
				if(this.origin.equals(e.origin) && this.destination.equals(e.destination))	{
					boolean different=false;
					for(int i=0;i<this.pegs.size()&&!different;i++)	{
						if(!(this.pegs.get(i).equals(e.pegs.get(i))))	{
							different=true;
						}
					}
					if(different)	{
						return false;
					} else	{
						return true;
					}
				} else	{
					return false;
				}
			} else	{
				return false;
			}
		} else 	{
			return false;
		}
	}

	public Peg getOrigin() {
		return origin;
	}

	public void setOrigin(Peg origin) {
		this.origin = origin;
	}

	public Peg getDestination() {
		return destination;
	}

	public void setDestination(Peg destination) {
		this.destination = destination;
	}

	public ArrayList<Peg> getPegs() {
		return pegs;
	}

	public void setPegs(ArrayList<Peg> pegs) {
		this.pegs = pegs;
	}
	
	public int getNumPegs()	{
		return pegs.size();
	}
	
	public Peg getPeg(int position)	{
		return pegs.get(position);
	}
	
	public void setPeg(int position,Peg peg)	{
		this.pegs.set(position, peg);
	}
	
	public void setDisk(int pegPosition, Stack<Disk> stack)	{
		this.pegs.get(pegPosition).setDisks(stack);
	}
	
	public int getSize(Peg p)	{
		return p.getSize();
	}
	
	public int getOriginSize()	{
		return this.origin.getSize();
	}
	
	public int getOriginPos()	{
		return this.origin.getPosition();
	}
	
	public int getDestSize()	{
		return this.destination.getSize();
	}
	
	public int getDestPos()	{
		return this.destination.getPosition();
	}
	
	public void clearPeg(Peg p)	{
		p.clear();
	}
	
	protected Object clone()	{
		Environment e = new Environment(pegs.size(),origin.getPosition()+1,destination.getPosition()+1,0);
		for(int i=0;i<e.getNumPegs();i++)	{
			e.setPeg(i, (Peg)this.pegs.get(i).clone());
		}
		e.setOrigin(e.getPeg(e.getOriginPos()));
		e.setDestination(e.getPeg(e.getDestPos()));
		return e;
	}

}
