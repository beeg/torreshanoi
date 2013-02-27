import java.util.Stack;


public class Peg {

	private int position;
	private Stack<Disk> disks;
	
	public Peg(int position) {
		super();
		this.position = position;
		disks = new Stack<Disk> ();
	}
	
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public Stack<Disk> getDisks() {
		return disks;
	}
	public void setDisks(Stack<Disk> disks) {
		this.disks = disks;
	}
	
	public void addDisk(Disk d)	{
		this.disks.push(d);
	}
	
	public String toString()	{
		String position = "Peg's position: "+(this.position+1)+"\n";
		String numDisk = "Number of disks: "+disks.size()+"\n";
		String diskSize ="";
		for(int i=0;i<disks.size();i++)	{
			diskSize=diskSize+disks.get(i).toString();
		}
		return position+numDisk+diskSize;
	}
	
	public boolean equals(Object o)	{
		Peg p=(Peg)o;
		boolean found=false;
		if(this.position==p.position)	{
			if(this.disks.size()==p.disks.size())	{
				for(int i=0;i<this.disks.size() && !found;i++)	{
					if(!(this.disks.get(i).equals(p.disks.get(i))))	{
						found=true;
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
		} else	{
			return false;
		}
	}
	
	
	
}
