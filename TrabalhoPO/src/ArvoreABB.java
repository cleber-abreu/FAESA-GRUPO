public class ArvoreABB {

	private No raiz;
	private int quantNos;

	public ArvoreABB() {
		this.raiz = null;
		this.quantNos = 0;
	}

	public boolean pesquisa(long chave) {
		No temp = this.pesquisa(chave, this.raiz);

		if (temp != null)
			return true;
		else
			return false;
	}

	private No pesquisa(long chave, No no) {
		No temp = no;
		if (temp != null) {
			if (chave < temp.getInfo().getCpfLong())
				temp = this.pesquisa(chave, temp.getEsq());
			else if (chave > temp.getInfo().getCpfLong())
				temp = this.pesquisa(chave, temp.getDir());
		}
		return temp;
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
