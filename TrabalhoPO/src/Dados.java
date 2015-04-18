import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Dados {
	private String nome;
	private String cpf;
	private Date data;
	private double valor;
	
	public Dados() {
		// TODO Auto-generated constructor stub
	}
	
	public Dados(String cpf, String nome, Date data, double valor) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.data = data;
		this.valor = valor;
	}
	
	public Dados(String cpf, String nome, String data, String valor) throws ParseException {
		super();
		this.cpf = cpf;
		this.nome = nome;
		DateFormat formato = new SimpleDateFormat("dd/MM/yy");
		this.data = (Date)formato.parse(data);
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
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getData() {
		return data.toString();
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