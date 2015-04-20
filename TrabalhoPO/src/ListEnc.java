
public class ListEnc {
	private No prim;
	private No ult;
	private int quantNos;
	
	public ListEnc() {
		prim = null;
		ult	 = null;
		quantNos = 0;
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
		quantNos++;
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
