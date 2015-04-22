
public class ListEnc {
	private No prim;
	private No ult;
	private int quantElem;
	
	public ListEnc() {
		prim = null;
		ult	 = null;
		quantElem = 0;
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
		this.quantElem++;
	}
	
	public void quickSort() {
		No esq = this.prim;
		No dir = this.ult;
		ordenaQuickSort(esq , dir.getAnt());
	}
	
	private void ordenaQuickSort(No esq, No dir) {
		No pivo = esq;
		No i = esq;
		No j = dir;
		No temp = dir;
		
		while (pivo.getProx() != temp.getAnt()) {
			pivo = pivo.getProx();
			temp = temp.getAnt();
		}
		pivo = pivo.getProx();
		
		System.out.println("PIVO: "+pivo.getInfo().getCpf());
		
		do {
			while (i.getInfo().getCpf() < pivo.getInfo().getCpf()) {
				System.out.println(i.getInfo().getCpf() +" < "+ pivo.getInfo().getCpf());
				i = i.getProx();
			}
			
			while (j.getInfo().getCpf() > pivo.getInfo().getCpf()) {
				System.out.println(j.getInfo().getCpf() +" < "+ pivo.getInfo().getCpf());
				j = j.getAnt();
			}
			
			if (i.getInfo().getCpf() <= j.getInfo().getCpf()) {
				System.out.println("TROCA: "+ i.getInfo().getCpf() +"<->"+ j.getInfo().getCpf());
				temp = i.getProx();
				i.setProx(j.getProx());
				j.setProx(temp);
				
				temp = i.getAnt();
				i.setAnt(j.getAnt());
				j.setAnt(temp);
				
				i = i.getProx();
				j = i.getAnt();
				
			}
		} while (i.getInfo().getCpf() <= j.getInfo().getCpf());
		
		if (esq.getInfo().getCpf() < j.getInfo().getCpf())
			ordenaQuickSort(esq, j);
		
		if (dir.getInfo().getCpf() > i.getInfo().getCpf())
			ordenaQuickSort(i, dir);
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
