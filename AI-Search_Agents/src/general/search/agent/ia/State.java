package general.search.agent.ia;

public abstract class State {

	protected String id;
	
	public State(String id){
		this.id = id;
	}
	
	public String getId(){
		return id;
	}
	
	public abstract String toString();
	
}
