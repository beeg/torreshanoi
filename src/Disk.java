
public class Disk {

	private int size;

	public Disk(int size) {
		super();
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
	public String toString()	{
		return "Disk size: "+size+"\n";
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o)	{
		if(o!=null && o.getClass()==this.getClass())	{
			Disk d=(Disk)o;
			if(this.size==d.size)	{
				return true;
			} else	{
				return false;
			}
		} else	{
			return false;
		}
	}
}
