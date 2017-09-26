package seach.agent.ia;

import border.search.agent.ia.StackBorder;
import general.search.agent.ia.DomainRules;
import general.search.agent.ia.SearchNode;
import general.search.agent.ia.TreeAgent;

// agente que executa uma busca em profundidade limitada
public class LDFSAgent extends TreeAgent {

	private int limit;
	
	public LDFSAgent(DomainRules rules, int limit) {
		super(rules);
		
		this.limit = limit;
		this.border = new StackBorder();
		
	}

	public void setLimit(int limit){
		this.limit = limit;
	}
	
	
	public int getLimit(){
		return limit;
	}
	
	// Sobrescreve a funcao que expande o estado.
	// De acordo com o comportamento geral desse tipo de agente,
	// O estado sera expandido apenas se n.depth < limit
	@Override
	public void expandNode(SearchNode node){
		if(node.getDepth() < limit){
			super.expandNode(node);
		}
	}
}
