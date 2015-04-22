
public class No {
	private Item info;
	private No prox;
	private No ant;
	
	public No() {
		
	}
	
	public No(Item info) {
		this.info = info;
	}

	public No getProx() {
		return prox;
	}
	
	public void setProx(No prox) {
		this.prox = prox;
	}

	public No getAnt() {
		return ant;
	}

	public void setAnt(No ant) {
		this.ant = ant;
	}

	public Item getInfo() {
		return info;
	}

	public void setInfo(Item info) {
		this.info = info;
	}
	
}
