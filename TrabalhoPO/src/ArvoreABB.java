public class ArvoreABB {

	private No raiz;
	private int quantNos;

	public ArvoreABB() {
		this.raiz = null;
		this.quantNos = 0;
	}
	
	public String[] pesquisa(String[] cpfs) {
		String[] linha = new String[200];
		for (int i = 0; i < cpfs.length; i++) {
			linha[i] = this.pesquisa(Long.parseLong(cpfs[i]), this.raiz, 0.0);
			if (linha[i].isEmpty()) {
				linha[i] = cpfs[i]  + " - CPF INEXISTENTE";
			}
		}
		return linha;
	}

	private String pesquisa(long chave, No no, double total) {
		String str = "";
		if (no != null) {
			if (chave < no.getInfo().getCpfLong())
				str = this.pesquisa(chave, no.getEsq(), total);
			else if (chave > no.getInfo().getCpfLong())
				str = this.pesquisa(chave, no.getDir(), total);
			else {
				if (total == 0) {
					str += no.getInfo().getCpf() + "; "
							+ no.getInfo().getNome() + "; "
							+ no.getInfo().getData() + "; "
							+ no.getInfo().getValor() + "; ";
					total = no.getInfo().getValor();
				}
				else {
					str += no.getInfo().getData() + "; "
							+ no.getInfo().getValor() + "; ";
					total += no.getInfo().getValor();
				}
				return str + this.pesquisa(chave, no.getEsq(), total);
			}
		}
		else if (total > 0)
			str += " TOTAL: "+total;
		return str;
	}

	public void insere(Item elem) {
		this.raiz = this.insere(elem, this.raiz);
		this.quantNos++;

	}

	private No insere(Item elem, No no) {
		No novo;
		if (no == null) {
			novo = new No(elem);
			return novo;
		} else if (elem.getCpfLong() <= no.getInfo().getCpfLong()) {
			no.setEsq(this.insere(elem, no.getEsq()));
			return no;
		} else {
			no.setDir(this.insere(elem, no.getDir()));
			return no;
		}
	}

	public Item[] camCentral() {
		Item[] vetOrdenado = new Item[this.quantNos];
		int[] i = new int[1];
		i[0] = 0;
		return (this.fazCamCentral(this.raiz, vetOrdenado, i));
	}

	private Item[] fazCamCentral(No arv, Item[] vetOrdenado, int[] i) {
		if (arv != null) {
			vetOrdenado = this.fazCamCentral(arv.getEsq(), vetOrdenado, i);
			vetOrdenado[i[0]] = arv.getInfo();
			i[0]++;
			vetOrdenado = fazCamCentral(arv.getDir(), vetOrdenado, i);
		}
		return vetOrdenado;
	}

	public ArvoreABB arvBalanceada() {
		ArvoreABB temp = new ArvoreABB();
		Item[] vetOrdenado = camCentral();
		this.balancear(vetOrdenado, temp, 0, this.quantNos - 1);
		return temp;
	}

	private void balancear(Item[] vetOrdenado, ArvoreABB temp, int ini, int fim) {
		int meio;
		if (fim >= ini) {
			meio = (ini + fim) / 2;
			temp.insere(vetOrdenado[meio]);
			this.balancear(vetOrdenado, temp, ini, meio - 1);
			this.balancear(vetOrdenado, temp, meio + 1, fim);
		}
	}
}
