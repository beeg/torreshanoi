import java.util.ArrayList;

import es.deusto.ingenieria.is.search.formulation.State;


public class Environment extends State	{

	private Peg origin;
	private Peg destination;
	private ArrayList<Peg> pegs;
	
	public Environment(int numPegs, int origin, int dest, int numDisks)	{
		//Allocating space for the pegs
		this.pegs = new ArrayList<Peg>(numPegs);
		for(int i=0;i<numPegs;i++)	{
			this.pegs.add(new Peg(i));
		}
		this.origin=this.pegs.get(origin-1);
		this.destination=this.pegs.get(dest-1);
		for(int i=0;i<numDisks;i++)	{
			this.origin.addDisk(new Disk(numDisks-i));
		}
	}
	
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

	public boolean equals(Object o) {
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
	
	public void setPeg(int position,Peg peg)	{
		this.pegs.set(position, peg);
	}
	
}
