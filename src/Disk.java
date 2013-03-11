
public class Disk implements Cloneable{

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
	
	protected Object clone(){
		Disk d = new Disk(size);
		return d;		
	}
	
	public static void main (String[] args)	{
		Disk d1 = new Disk(4);
		System.out.println("Disk 1:");
		System.out.println(d1.toString());
		
		//Disk clone
		Disk d2= (Disk)d1.clone();
		System.out.println("\nDisk cloned");
		d2.setSize(6);
		System.out.println("Disk cloned size changed to 6");
		System.out.println(d2.toString());
		
		//Checking previous disk has not be also changed
		System.out.println("\nPrevious disk");
		System.out.println(d1.toString());
	}
}
