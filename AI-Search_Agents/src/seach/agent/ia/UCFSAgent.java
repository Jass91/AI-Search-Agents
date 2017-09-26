package seach.agent.ia;

import java.util.Comparator;
import border.search.agent.ia.PriorityQueueBorder;
import general.search.agent.ia.DomainRules;
import general.search.agent.ia.GraphAgent;
import general.search.agent.ia.SearchNode;

public class UCFSAgent extends GraphAgent implements Comparator<SearchNode> {

	public UCFSAgent(DomainRules rules) {
		super(rules);
		
		// instancia a borda como uma fila de prioridade
		this.border = new PriorityQueueBorder(this);
	}

	// compara os estados com base no custo
	@Override
	public int compare(SearchNode node1, SearchNode node2) {
		if(node1.getCoast() > node2.getCoast()) return 1;
		if(node1.getCoast() < node2.getCoast()) return -1;
		return 0;
	}

}
