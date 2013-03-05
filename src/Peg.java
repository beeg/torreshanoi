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
				//Checks if the number of disks is the same
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
	
	/**
	 * Gets the top disk of the stack without popping it
	 * @return
	 */
	public Disk getPeek()	{
		return this.disks.peek();
	}
	
	/**
	 * Gets the size of the stack of disks
	 * @return
	 */
	public int getSize()	{
		return this.disks.size();
	}
	
	/**
	 * Checks if the stack of disks is empty
	 * @return
	 */
	public boolean isEmpty()	{
		return this.disks.isEmpty();
	}
	
	/**
	 * Inserts a new disk into the stack
	 * @param d
	 */
	public void push(Disk d)	{
		this.disks.push(d);
	}
	
	/**
	 * Takes the disk from the stack
	 * @return
	 */
	public Disk pop()	{
		return this.disks.pop();
	}
	
	/**
	 * Empties the stack of disk
	 */
	public void clear()	{
		this.disks.clear();
	}
	
}
