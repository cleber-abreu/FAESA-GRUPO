

public class Item {
	private String nome;
	private String cpf;
	private String data;
	private double valor;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public Item(String cpf, String nome, String data, double valor) {
		this.cpf = cpf;
		this.nome = nome;
		this.data = data;
		this.valor = valor;
	}
	
	public Item(String cpf, String nome, String data, String valor) {
		this.cpf = cpf;
		this.nome = nome;
		this.data = data;
		this.valor = Double.parseDouble(valor);
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public long getCpfLong() {
		return Long.parseLong(cpf);
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
}