package general.search.agent.ia;

public class StateAction {

	private Action action;
	private State state;
	
	public StateAction(State state, Action action) {
		super();
		this.action = action;
		this.state = state;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	

}
