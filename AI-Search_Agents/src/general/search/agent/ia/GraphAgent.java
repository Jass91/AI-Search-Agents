package general.search.agent.ia;

import java.util.HashMap;

public abstract class GraphAgent extends Agent {

	// armazena como chave o id do no e o valor como o id do no
	// representa o conjunto de nos ja gerados
	protected HashMap<String, String> generatedNodes;

	public GraphAgent(DomainRules rules){
		super(rules);
		this.generatedNodes = new HashMap<String, String>();
	}

	@Override
	protected void addNodeToBorder(SearchNode newNode) {
		if(canAddNodeToBorder(newNode)){
			border.add(newNode);
			generatedNodes.put(newNode.getId(), newNode.getId());
		}
	}
	
	private boolean canAddNodeToBorder(SearchNode node){
		String nodeId = generatedNodes.get(node.getId());
		if(nodeId == null)
			return true;
		else
			return false;
	}
	
}
