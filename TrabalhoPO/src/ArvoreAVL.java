public class ArvoreAVL {

	private NoArvore raiz;
	private boolean h;
	private int quantNos;

	public ArvoreAVL() {
		this.raiz = null;
		this.h = true;
		this.quantNos = 0;
	}

	public void insereRaiz(Item elem) {
		this.raiz = this.insere(elem, this.raiz);
		this.quantNos++;
	}

	private NoArvore insere(Item elem, NoArvore no) {
		if (no == null) {
			NoArvore novo = new NoArvore(elem);
			this.h = true;
			return novo;
		} else {
			if (elem.getCpfLong() <= no.getInfo().getCpfLong()) {
				// Insere à esquerda e verifica se precisa balancear à direita
				no.setEsq(this.insere(elem, no.getEsq()));
				no = this.balancearDir(no);
				return no;
			} else {
				// Insere à direita e verifica se precisa balancear à esquerda
				no.setDir(this.insere(elem, no.getDir()));
				no = this.balancearEsq(no);
				return no;
			}
		}
	}

	private NoArvore balancearDir(NoArvore no) {
		if (this.h) {
			switch (no.getFatorBalanceamento()) {
			case 1:
				no.setFatorBalanceamento((byte) 0);
				this.h = false;
				break;
			case 0:
				no.setFatorBalanceamento((byte) -1);
				break;
			case -1:
				no = this.rotacaoDireita(no);
			}
		}
		return no;
	}

	private NoArvore balancearEsq(NoArvore no) {
		if (this.h) {
			switch (no.getFatorBalanceamento()) {
			case -1:
				no.setFatorBalanceamento((byte) 0);
				this.h = false;
				break;
			case 0:
				no.setFatorBalanceamento((byte) 1);
				break;
			case 1:
				no = this.rotacaoEsquerda(no);
			}
		}
		return no;
	}

	private NoArvore rotacaoDireita(NoArvore no) {
		NoArvore temp1, temp2;
		temp1 = no.getEsq();
		if (temp1.getFatorBalanceamento() == -1) {
			no.setEsq(temp1.getDir());
			temp1.setDir(no);
			no.setFatorBalanceamento((byte) 0);
			no = temp1;
		} else {
			temp2 = temp1.getDir();
			temp1.setDir(temp2.getEsq());
			temp2.setEsq(temp1);
			no.setEsq(temp2.getDir());
			temp2.setDir(no);
			if (temp2.getFatorBalanceamento() == -1) {
				no.setFatorBalanceamento((byte) 1);
			} else {
				no.setFatorBalanceamento((byte) 0);
			}
			if (temp2.getFatorBalanceamento() == 1) {
				temp1.setFatorBalanceamento((byte) -1);
			} else {
				temp1.setFatorBalanceamento((byte) 0);
			}
			no = temp2;
		}
		no.setFatorBalanceamento((byte) 0);
		this.h = false;
		return no;
	}

	private NoArvore rotacaoEsquerda(NoArvore no) {
		NoArvore temp1, temp2;
		temp1 = no.getDir();
		if (temp1.getFatorBalanceamento() == 1) {
			no.setDir(temp1.getEsq());
			temp1.setEsq(no);
		} else {
			temp2 = temp1.getEsq();
			temp1.setEsq(temp2.getDir());
			temp2.setDir(temp1);
			no.setDir(temp2.getEsq());
			temp2.setEsq(no);
			if (temp2.getFatorBalanceamento() == 1) {
				no.setFatorBalanceamento((byte) -1);
			} else {
				no.setFatorBalanceamento((byte) 0);
			}
			if (temp2.getFatorBalanceamento() == -1) {
				temp1.setFatorBalanceamento((byte) 1);
			} else {
				temp1.setFatorBalanceamento((byte) 0);
			}
			no = temp2;
		}
		no.setFatorBalanceamento((byte) 0);
		this.h = false;
		return no;
	}
	
	public Item[] vetorOrdenado() {
		Item[] vet = new Item[this.quantNos];
		int[] i = new int[1];
		i[0] = 0;
		vetorOrdenado(this.raiz, vet, i);
		
		return vet;
	}

	private void vetorOrdenado(NoArvore no, Item[] vet, int[] i) {
		if (no == null) {
			return;
		}
		vetorOrdenado(no.getEsq(), vet, i);
		//System.out.println(i[0] +" - "+ no.getInfo().getCpf());
		vet[i[0]] = no.getInfo();
		i[0]++;
		vetorOrdenado(no.getDir(), vet, i);
	}
}