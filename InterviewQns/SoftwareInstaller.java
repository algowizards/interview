import java.util.*;
public class SoftwareInstaller{
	DepGraph _graph;
	public SoftwareInstaller(){
		_graph = new DepGraph();
	}
	
	public void Depends(Software software, ArrayList<Software> dependencies){
		//create software node
		if(!_graph.ContainsNode(software)){
			_graph.AddNode(software);
		}
		//create dependencies if they don't exist
		for(Software dep:dependencies){
			if(!_graph.ContainsNode(dep)){
				_graph.AddNode(dep);
			}
			//mark an edge from the software to its dependencies (dependency graph)			
			_graph.AddDependsOnEdge(software, dep);
			_graph.AddNeededForEdge(dep, software);
		}
		
		
	}
	
	public void Depends(String software, String[] dependencies){
		ArrayList<Software> deps = new ArrayList<Software>();
		for(String d:dependencies){
			deps.add(new Software(d));
		}
		Depends(new Software(software), deps);
	}
	
	public boolean Uninstall(Software s, boolean firstCall){
		if(s  == null){
			return true;
		}
		if(!s.IsInstalled && firstCall){
			System.out.println(s.Name + " has already been uninstalled!");
			return true;
		}
		ArrayList<Software> neededFors = _graph.GetNeededFors(s);
		for(Software neededFor:neededFors){
			if(neededFor.IsInstalled){
				if(firstCall){ //print error only on first call
					System.out.println("Software " + s.Name + " cannot be deleted as it is needed for " + neededFor.Name);
				}
				return false;
			}
		}
		//none of the s/w that requires s is installed. we can safely remove s
		System.out.println("Deleting software : " + s.Name);
		s.IsInstalled = false;
		
		//remove dependencies recursively if they are not needed
		ArrayList<Software> dependencies = _graph.GetDependencies(s);
		for(Software dep:dependencies){
			Uninstall(dep, false);
		}
		return true;
	}
	
	public void Install(Software s){
		if(s == null){
			return;
		}
		if(s.IsInstalled){
			System.out.println("Already installed  " + s.Name);
			return;
		}
		ArrayList<Software> dependencies = _graph.GetDependencies(s);
			if(dependencies != null){
				for(Software dep:dependencies){
					if(!dep.IsInstalled){
						Install(dep);
					}
				}
			}
		System.out.println( "Installing software : " + s);	
		s.IsInstalled = true;
	}
	
	public static void main(String args[]){
		
		Test();
	
	}
	public static void Test(){
		SoftwareInstaller si = new SoftwareInstaller();
		
		Software eth = new Software("Ethernet");
		
		Software tcp = new Software("TCP");
		ArrayList<Software> tcpDeps = new ArrayList<Software>();
		tcpDeps.add(eth);
		si.Depends(tcp, tcpDeps);
		
		Software http = new Software("HTTP");
		ArrayList<Software> httpDeps = new ArrayList<Software>();
		httpDeps.add(tcp);
		si.Depends(http, httpDeps);
		si.Install(http);
		
		si.Install(eth);
		
		//si.Uninstall(http, true);
		//si.Uninstall(http, true);
		si.Uninstall(eth, true);
	}
	
}