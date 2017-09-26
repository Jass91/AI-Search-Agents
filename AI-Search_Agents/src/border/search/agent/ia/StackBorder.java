package border.search.agent.ia;

import java.util.NoSuchElementException;

import general.search.agent.ia.SearchNode;

/*
 * Representa a borda em forma de uma pilha,
 * resultando em uma busca em profundidade.
 * 
 */
public class StackBorder extends Border {

	public StackBorder() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void add(SearchNode state) {
		elements.add(state);
	}

	@Override
	public SearchNode get() {
		
		if(elements.size() == 0){
	       throw new NoSuchElementException();
		}
		
		SearchNode state = elements.get(elements.size() - 1);
		elements.remove(elements.size() - 1);
		
		return state;
	}

}
