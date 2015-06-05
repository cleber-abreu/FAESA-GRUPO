
public class NoSimples {
	private Item i;
	private NoSimples prox;
	
	
	public NoSimples(Item i, NoSimples prox) {
		super();
		this.i = i;
		this.prox = null;
	}


	public NoSimples() {
		// TODO Auto-generated constructor stub
	}


	public Item getI() {
		return i;
	}


	public void setI(Item i) {
		this.i = i;
	}


	public NoSimples getProx() {
		return prox;
	}


	public void setProx(NoSimples prox) {
		this.prox = prox;
	}
	
}
