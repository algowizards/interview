import java.util.*;
public class Neighbor{
	private ArrayList<Software> dependsOn = new ArrayList<Software>(); 
	private ArrayList<Software> neededFor = new ArrayList<Software>();
	
	public void AddtoDependsOn(Software s){
		dependsOn.add(s);
	}
	
	public void AddtoNeededFor(Software s){
		neededFor.add(s);
	}
	
	public ArrayList<Software> GetDependencies(){
		return dependsOn;
	}
	public ArrayList<Software> GetNeededFors(){
		return neededFor;
	}


}