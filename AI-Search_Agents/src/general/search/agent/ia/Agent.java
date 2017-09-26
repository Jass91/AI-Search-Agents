package general.search.agent.ia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import border.search.agent.ia.Border;

// define o comportamento comum a todos os agentes
public abstract class Agent{

	protected int problemSize;
	protected long numberOfGeneratedNodes;
	protected long numberOfExploredNodes;
	protected long depth;
	protected Border border;
	protected SearchNode initialNode;
	protected SearchNode goalNode;
	protected DomainRules rules;

	public Agent(DomainRules rules){
		this.rules = rules;
		this.goalNode = null;
		this.numberOfExploredNodes = 0;
		this.numberOfGeneratedNodes = 0;
		this.depth = 0;
		this.initialNode = createInicialNode(rules);
	}

	protected abstract void addNodeToBorder(SearchNode newNode);

	private SearchNode createInicialNode(DomainRules rules) {
		State state = rules.getInitialState();
		return new SearchNode(state, null, null);
	}

	protected void expandNode(SearchNode node)  {

		// recupera os filhos do no baseado na regra do dominio
		List<StateAction> children = rules.getChildrenOf(node);

		// atualiza a quantidade de nos gerados
		numberOfGeneratedNodes += children.size();

		// adiciona a borda
		for(StateAction child : children){
			SearchNode n = new SearchNode(child.getState(), node, child.getAction());
			addNodeToBorder(n);
		}

		// se expandiu o no
		if(children.size() > 0){
			numberOfExploredNodes++;
		}
	}

	protected SearchNode getNodeFromBorder() {
		return this.border.get();
	}

	// calcula o caminho do no meta ate o no inicial
	private List<SearchNode> getSolutionPath(){

		if(goalNode == null)
			return null;

		List<SearchNode> solutionPath = new ArrayList<SearchNode>();
		SearchNode node = goalNode;

		while(node != null){
			solutionPath.add(node);
			node = node.getParent();
		}

		// inverte a lista
		Collections.reverse(solutionPath);

		return solutionPath;
	}


	// **************************************** //
	//											//
	// Acessiveis atraves da instancia de Agent //
	//											//
	// **************************************** //

	// retorna o caminho encontrado (lista de nos)
	public List<SearchNode> resolve() {

		addNodeToBorder(initialNode);

		// enquanto a borda nao estiver vazia
		while(border.getSize() > 0){

			// retira um no da borda
			SearchNode node = getNodeFromBorder();

			// se o eh objetivo
			if(rules.isGoal(node)){

				// guarda o estado meta
				goalNode = node;

				// retorna a solucao
				return getSolutionPath();

			}

			// inicia a busca a partir do no
			expandNode(node);
			
		}

		return getSolutionPath();
	}

	public int getAverageBranchingFactor(){
		if(numberOfExploredNodes == 0)
			return 1;
		
		return (int)Math.abs(numberOfGeneratedNodes / numberOfExploredNodes);
	}

	public long getNumberOfExploredNodes(){
		return numberOfExploredNodes;
	}

	public long getNumberOfGeneratedNodes(){
		return numberOfGeneratedNodes;
	}

	// retorna a profundidade do estado meta
	public int getDepthOfSolution(){

		if(goalNode == null)
			return 0;

		return goalNode.getDepth();
	}

	public SearchNode getGoalNode() {
		return goalNode;
	}

	public SearchNode getInitialNode() {
		return initialNode;
	}

	public int getSolutionCoast(){

		if(goalNode == null)
			return 0;

		return goalNode.getCoast();
	}

}
