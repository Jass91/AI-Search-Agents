package seach.agent.ia;

import general.search.agent.ia.DomainRules;
import general.search.agent.ia.GuidedGraphAgent;
import general.search.agent.ia.SearchNode;
import general.search.heuristic.ia.Heuristic;

/*
 * 
 * Agente que executa uma busca informada usando melhor escolha. 
 * Esse agente utiliza uma funcao heuristica dada como entrada:
 * 
 */
public class GBFSAgent extends GuidedGraphAgent{

	public GBFSAgent(DomainRules rules, Heuristic heuristic) {
		super(rules, heuristic);
	}

	// utiliza o valor de h(n) e a definicao do que eh melhor (max(h(n)) ou min(h(n)))
	// para determinar a ordem dos nos na borda
	@Override
	public int compare(SearchNode node1, SearchNode node2) {

		// obtem os valores heuristicos para os nos
		int val1 = h.getValueTo(node1);
		int val2 = h.getValueTo(node2);

		// monta um heap de maximo
		// se o melhor no eh o de maior valor h(n),
		// retorna o valor da comparacao
		// de forma que esse no va para o topo do heap
		if(h.isMaxBetter()){

			// node1 tem maior prioridade que node2
			if(val1 > val2) return -1;

			// node2 tem maior prioridade que node1
			if(val1 < val2) return 1;

			// se tem a mesma prioridade
			return 0;
		}

		// monta um heap de minimo
		// se o melhor no eh o de menor valor h(n),
		// retorna o valor da comparacao
		// de forma que esse no va para o topo do heap

		// node1 tem maior prioridade que node2
		if(val1 < val2) return -1;

		// node2 tem maior prioridade que node1
		if(val1 > val2) return 1;

		// se tem a mesma prioridade
		return 0;

	}
}
