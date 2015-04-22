import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Item {
	private long cpf;
	private String nome;
	private Date data;
	private double valor;
	private DateFormat formato = new SimpleDateFormat("dd/MM/yy");
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public Item(int cpf, String nome, Date data, double valor) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.data = data;
		this.valor = valor;
	}
	
	public Item(long cpf, String nome, String data, String valor) throws ParseException {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.data = (Date)formato.parse(data);
		this.valor = Double.parseDouble(valor);
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public long getCpf() {
		return cpf;
	}
	
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	public String getData() {
		return formato.format(data);
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