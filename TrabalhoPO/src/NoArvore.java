public class NoArvore {
	private Item info;
	private NoArvore esq, dir;
	private No repetido;
	private byte fatorBalanceamento;

	public NoArvore(Item i) {
		this.info = i;
		this.fatorBalanceamento = 0;
	}

	public NoArvore getDir() {
		return this.dir;
	}

	public void setDir(NoArvore dir) {
		this.dir = dir;
	}

	public NoArvore getEsq() {
		return this.esq;
	}

	public void setEsq(NoArvore esq) {
		this.esq = esq;
	}
	
	public No getRepetido() {
		return repetido;
	}

	public void setRep(No rep) {
		this.repetido = rep;
	}

	public byte getFatorBalanceamento() {
		return this.fatorBalanceamento;
	}

	public void setFatorBalanceamento(byte fatorBalanceamento) {
		this.fatorBalanceamento = fatorBalanceamento;
	}

	public Item getInfo() {
		return this.info;
	}
	
	@Override
	public String toString() {
		return this.getInfo().getCpf() + "\t-\t"
					+ this.getInfo().getNome() + "\r\n"
					+ this.getInfo().getData() + "\t-\t "
					+ this.getInfo().getValor() + "\r\n";
	}
}
