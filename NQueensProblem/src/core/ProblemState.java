package core;

import general.search.agent.ia.State;

public class ProblemState extends State{

	private POS_STATE [][] matrix;
	private int queens = 0;;
	
	public ProblemState(String id, POS_STATE [][] matrix, int queens) {
		super(id);
		this.matrix = matrix;
		this.queens = queens;
	}

	@Override
	public String toString() {
		String s = "";
		for(int i = 0; i < matrix.length; i++) {			
			for(int j = 0; j < matrix.length; j++) {
				String str = "";
				if(matrix[i][j] == POS_STATE.FREE || matrix[i][j] == POS_STATE.INVALID)
					str = "0";
				if(matrix[i][j] == POS_STATE.OCUPIED)
					str = "x";
				
				if(j == matrix.length - 1)					
					s += str;				
				else
					s += str + " ";					
			}
			s += "\n";
		}
		
		return s;
	}

	public POS_STATE[][] getStateInfo() {
		return matrix;
	}
	
	public int getQueens() {
		return queens;
	}
	
	public void setQueens(int queens) {
		this.queens = queens;
	}
}
