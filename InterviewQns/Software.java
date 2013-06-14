
public class Software{
	
	public String Name;
	public boolean IsInstalled;
	
	@Override
	public boolean equals(Object o){
		return ((Software) o ).Name.equals(Name);
	}
	
	@Override
	public int hashCode(){
		return Name.hashCode();
	}
	
	@Override
	public String toString(){
		return "Name: " + Name ; //IsInstalled: " + IsInstalled;
	}
	public Software(String name){
		Name = name;
	}
}