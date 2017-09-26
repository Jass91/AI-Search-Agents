package seach.agent.ia;

import border.search.agent.ia.QueueBorder;
import general.search.agent.ia.DomainRules;
import general.search.agent.ia.GraphAgent;

// agente que executa a busca em largura
public class BFSAgent extends GraphAgent {

	public BFSAgent(DomainRules rules) {
		super(rules);

		// inicializa a borda como uma fila
		this.border = new QueueBorder();
	}

	
}
