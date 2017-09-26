package general.search.agent.ia;

public class SearchNode {

	private SearchNode parent;
	private State state;
	private Action action;
	private String id;
	private int depth;
	private int coast;

	public SearchNode(State state, SearchNode parent, Action action) {
		this.parent = parent;
		this.state = state;
		this.action = action;
		this.id = state.getId();
		this.depth = setDepth();
		this.coast = getCoastToGetHere();
	}

	private int getCoastToGetHere() {
		if(parent == null)
			return 0;
		else{
			return (parent.getCoast() + action.getCoast());
		}

	}

	public int getCoast() {
		return coast;
	}

	private int setDepth(){
		if(parent == null)
			return 0;
		else
			return parent.getDepth() + 1;
	}

	public int getDepth() {
		return depth;
	}

	public SearchNode getParent() {
		return parent;
	}

	public void setParent(SearchNode parent) {
		this.parent = parent;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public String getId(){
		return new String(id);
	}

	@Override
	public String toString(){
		return id;
	}
}
