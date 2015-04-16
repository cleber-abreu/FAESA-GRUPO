import java.util.Date;


public class Dados {
	private String nome;
	private String cpf;
	private Date data;
	private double valor;
	
	public Dados() {
		// TODO Auto-generated constructor stub
	}
	
	public Dados(String nome, String cpf, Date data, double valor) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.data = data;
		this.valor = valor;
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
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
	
}
