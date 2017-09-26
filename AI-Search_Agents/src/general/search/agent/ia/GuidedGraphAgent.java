package general.search.agent.ia;

import java.util.Comparator;
import border.search.agent.ia.PriorityQueueBorder;
import general.search.heuristic.ia.Heuristic;

public abstract class GuidedGraphAgent extends GraphAgent implements Comparator<SearchNode> {

	// representa a funcao de avaliacao h(n)
	protected Heuristic h;

	public GuidedGraphAgent(DomainRules rules, Heuristic heuristic){
		super(rules);

		this.h = heuristic;

		// instancia a borda como uma fila de prioridade,
		// cuja a ordem eh dada pela funcao de comparacao
		this.border = new PriorityQueueBorder(this);
	}
	
}
