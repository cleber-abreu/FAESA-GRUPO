
public class ListaEnc {
	private No prim;
	private No ult;
	
	public ListaEnc() {
		prim = null;
		ult	 = null;
	}
	
	public ListaEnc(Item elem) {
		this.insereUltimo(elem);
	}
	
	public No getPrim() {
		return prim;
	}

	public void setPrim(No prim) {
		this.prim = prim;
	}

	public No getUlt() {
		return ult;
	}

	public void setUlt(No ult) {
		this.ult = ult;
	}

	public boolean vazia() {
		return (this.prim == null);
	}
	
	public void insereUltimo(Item elem) {
		No novoNo = new No(elem);
		if (this.vazia())
			this.prim = novoNo;
		else {
			novoNo.setAnt(this.ult);
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
	}
	
}
