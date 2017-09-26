package general.search.agent.ia;

public abstract class TreeAgent extends Agent {

	public TreeAgent(DomainRules rules)  {
		super(rules);
	}

	@Override
	protected void addNodeToBorder(SearchNode newNode) {
		border.add(newNode);
	}
	
}
