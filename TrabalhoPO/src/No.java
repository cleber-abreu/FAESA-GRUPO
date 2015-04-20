
public class No {
	private Dados info;
	private No prox;
	private No ant;
	
	public No() {
		
	}
	
	public No(Dados info) {
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

	public Dados getInfo() {
		return info;
	}

	public void setInfo(Dados info) {
		this.info = info;
	}
	
}
