
public class ListEnc {
	private No prim;
	private No ult;
	
	public ListEnc() {
		prim = null;
		ult	 = null;
	}
	
	public boolean vazia() {
		return (this.prim == null);
	}
	
	public void insereUltimo(Dados elem) {
		No novoNo = new No(elem);
		if (this.vazia())
			this.prim = novoNo;
		else {
			novoNo.setAnt(this.ult);
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
	}
	
	@Override
	public String toString() {
		String lista = "";
		No atual = this.prim;
		
		while (atual != null) {
			lista += atual.getInfo().getCpf() + " \t-\t" 
					+ atual.getInfo().getNome() + " \t-\t" 
					+ atual.getInfo().getData() + " \t-\t" 
					+ atual.getInfo().getValor() + "\n";
			atual = atual.getProx();
		}
		
		return lista;
	}
}
