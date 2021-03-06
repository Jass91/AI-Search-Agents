package seach.agent.ia;

import java.util.List;
import border.search.agent.ia.StackBorder;
import general.search.agent.ia.DomainRules;
import general.search.agent.ia.SearchNode;
import general.search.agent.ia.TreeAgent;

//agente que executa uma busca em profundidade iterativa
public class IDFSAgent extends TreeAgent{

	private int depth;

	public IDFSAgent(DomainRules rules) {
		super(rules);

		this.depth = 1;
		this.border = new StackBorder();

	}
	
	/*
	 * Sobrescreve o metodo de resolucao,
	 * pois esse agente executa n = 1, 2, ..., maxLimit
	 * 
	 */
	@Override
	public List<SearchNode> resolve(){

		int totalOfExploredNodes = 0;
		int totalOfGeneratedNodes = 0;
		int i = 1;
		
		// aumenta o limite de depth ate maxLimit gradativamente
		while(i <= depth){
			
			numberOfExploredNodes = 0;
			numberOfGeneratedNodes = 0;
			
			List<SearchNode> resolution = super.resolve();
			
			// atualiza as variaveis (para cada busca conta os estados gerados e explorados)
			totalOfExploredNodes += numberOfExploredNodes;
			totalOfGeneratedNodes += numberOfGeneratedNodes;
			
			if(resolution != null){
				numberOfExploredNodes = totalOfExploredNodes;
				numberOfGeneratedNodes = totalOfGeneratedNodes;
				return resolution;
			}
			
			// muda a profundidade limite
			depth++;
		}
		
		numberOfExploredNodes = totalOfExploredNodes;
		numberOfGeneratedNodes = totalOfGeneratedNodes;
		
		return null;
	}

	
	// Sobrescreve a funcao que expande o estado.
	// De acordo com o comportamento geral desse tipo de agente,
	// o estado sera expandido apenas se n.depth < limit
	public void expandNode(SearchNode node){
		if(node.getDepth() < depth){
			super.expandNode(node);
		}
	}
}
