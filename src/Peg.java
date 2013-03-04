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
		if(o!=null && o.getClass()==this.getClass())	{
			Peg p=(Peg)o;
			if(this.position==p.position)	{
				if(this.disks.size()==p.disks.size())	{
					boolean different=false;
					for(int i=0;i<this.disks.size()&&!different;i++)	{
						if(!(this.disks.get(i).equals(p.disks.get(i))))	{
							different=true;
						}
					}
					if(different)
						return false;
					else
						return true;
				} else	{
					return false;
				}
			} else	{
				return false;
			}
		} else	{
			return false;
		}
	}
	
	
	
}
