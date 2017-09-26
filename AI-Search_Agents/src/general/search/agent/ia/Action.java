package general.search.agent.ia;

public abstract class Action {

	protected int coast;

	public Action(int coast){
		this.coast = coast;
	}

	public int getCoast() {
		return coast;
	}

	public void setCoast(int coast) {
		this.coast = coast;
	}

	public abstract void showMovement();
}
