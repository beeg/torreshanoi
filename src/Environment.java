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
		Environment e = (Environment)o;
		boolean found=false;
		if(this.pegs.size()==e.pegs.size())	{
			if(this.origin.equals(e.origin) && this.destination.equals(e.destination))	{
				for(int i=0;i<pegs.size();i++)	{
					if(!(this.pegs.get(i).getPosition()==this.origin.getPosition() || this.pegs.get(i).getPosition()==this.destination.getPosition()))	{
						if(!(this.pegs.get(i).equals(e.pegs.get(i))))	{
							found=true;
						}
					}
				}
				
				if(found)	{
					return false;
				} else	{
					return true;
				}
			} else	{
				return false;
			}
		}	else	{
			return false;
		}		
	}
	
}
