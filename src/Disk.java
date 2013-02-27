
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
	
	public boolean equals(Object o)	{
		Disk d=(Disk)o;
		if(this.size==d.size)	{
			return true;
		} else	{
			return false;
		}
	}
}
