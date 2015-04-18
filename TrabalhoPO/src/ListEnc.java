
public class ListEnc {
	private No prim;
	private No ult;
	
	public ListEnc() {
		prim = null;
		ult	 = null;
	}
	
	public boolean isVazia() {
		return (this.prim == null);
	}
	
	public void insereUltimo(Dados elem) {
		No novoNo = new No(elem);
		if (this.isVazia())
			this.prim = novoNo;
		else {
			novoNo.setAnt(this.ult);
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
	}
}
