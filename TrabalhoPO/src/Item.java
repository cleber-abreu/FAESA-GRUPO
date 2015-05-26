import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Item {
	private String nome;
	private String cpf;
	private Date data;
	private double valor;
	private DateFormat formato = new SimpleDateFormat("dd/MM/yy");
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public Item(String cpf, String nome, Date data, double valor) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.data = data;
		this.valor = valor;
	}
	
	public Item(String cpf, String nome, String data, String valor) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.valor = Double.parseDouble(valor);
		
		try {
			this.data = (Date)formato.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
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