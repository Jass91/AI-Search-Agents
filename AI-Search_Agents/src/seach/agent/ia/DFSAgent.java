package seach.agent.ia;

import border.search.agent.ia.StackBorder;
import general.search.agent.ia.DomainRules;
import general.search.agent.ia.GraphAgent;

// agente que executa a busca em profundidade
public class DFSAgent extends GraphAgent {

	public DFSAgent(DomainRules rules) {
		super(rules);
		
		// inicializa a borda como uma pilha
		this.border = new StackBorder();
	}
	
}
