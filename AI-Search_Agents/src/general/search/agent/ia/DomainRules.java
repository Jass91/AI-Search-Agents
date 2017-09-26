package general.search.agent.ia;

import java.util.List;

public interface DomainRules {

	/*
	 * return a list of StateAction from node
	 */
	public List<StateAction>getChildrenOf(SearchNode node);
	
	public boolean isGoal(SearchNode node);
	
	public State getInitialState();
	
	//public String generateIdFor(State state);
}
