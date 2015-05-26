public class NoArvore {
	private Item info;
	private NoArvore esq, dir;
	private ListaEnc repetido;
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
	
	public ListaEnc getRepetido() {
		return repetido;
	}

	public void setRep(ListaEnc rep) {
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