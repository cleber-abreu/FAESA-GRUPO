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
		} else if (elem.getCpfLong() < no.getInfo().getCpfLong()) {
			// Insere à esquerda e verifica se precisa balancear à direita
			no.setEsq(this.insere(elem, no.getEsq()));
			no = this.balancearDir(no);
			return no;
		} else if (elem.getCpfLong() > no.getInfo().getCpfLong()) {
			// Insere à direita e verifica se precisa balancear à esquerda
			no.setDir(this.insere(elem, no.getDir()));
			no = this.balancearEsq(no);
			return no;
		}
		// Inserir CPF repetido
		else {
			if (no.getRepetido() == null)
				no.setRep(new No(elem));
			else {
				No repetido = no.getRepetido();
				while (repetido.getProx() != null)
					repetido = repetido.getProx();
				repetido.setProx(new No(elem));
			}
			this.h = false;
			return no;
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
			no.setFatorBalanceamento((byte) 0);
			no = temp1;
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
		//TEM A MESMA FUNÇÃO DO CAMCENTRAL
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
		vet[i[0]] = no.getInfo();
		i[0]++;
		if (no.getRepetido() != null) {
			No reptidos = no.getRepetido();
			while (reptidos != null) {
				vet[i[0]] = reptidos.getInfo();
				i[0]++;
				reptidos = reptidos.getProx();
			}
		}
		vetorOrdenado(no.getDir(), vet, i);
	}
	
	public String[] pesquisa(String[] cpfs) {
		String[] linha = new String[200];
		for (int i = 0; i < cpfs.length; i++) {
			linha[i] = this.pesquisa(Long.parseLong(cpfs[i]), this.raiz);
			if (linha[i].isEmpty()) {
				linha[i] = cpfs[i] + " - CPF INEXISTENTE";
			}
		}
		return linha;
	}

	private String pesquisa(long cpf, NoArvore no) {
		String str = "";
		double total = 0;
		if (no != null) {
			if (cpf < no.getInfo().getCpfLong())
				str = this.pesquisa(cpf, no.getEsq());
			else if (cpf > no.getInfo().getCpfLong())
				str = this.pesquisa(cpf, no.getDir());
			else {
				str = no.toString();
				total = no.getInfo().getValor();
				if (no.getRepetido() != null) {
					No repetidos = no.getRepetido();
					while (repetidos != null) {
						str += repetidos.getCompra();
						total += repetidos.getInfo().getValor();
						repetidos = repetidos.getProx();
					}
				}
				str += "TOTAL: " + total;
			}
		}
		return str;
	}
}