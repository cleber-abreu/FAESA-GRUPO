
public class Hashing {
	private ListaEnc[] vetEnc ;
	private int m;
	
	public void insereH(Item item){
		int n = (int) (item.getCpfLong() % m);
		vetEnc[n].insereUltimo(item);
	}

	public Hashing(int tam) {
		int t = (int) (tam*(1.1));
		this.m = Prime.closestPrime(t);	
		this.vetEnc = new ListaEnc[this.m];
		for (int i = 0; i < vetEnc.length; i++) {
			vetEnc[i] = new ListaEnc();
		}
		
	}
	
	public String[] pesquisa(String[] cpfs){
		String[] linha = new String[cpfs.length];
		for (int i = 0; i < cpfs.length; i++) {
			linha[i] = this.pesquisa(Long.parseLong(cpfs[i]));
			if (linha[i].isEmpty()) {
				linha[i] = cpfs[i] + " - CPF INEXISTENTE";
			}
		}
		return linha;
	}
	
	private String pesquisa(long cpf) {
		String str = "";
		double total = 0;
		int n = (int)(cpf % this.m);
		ListaEnc lista = this.vetEnc[n];
		No no = lista.getPrim();
		while(no != null){
			if (no.getInfo().getCpfLong() == cpf){
				str += no.toString() + "\n";
				total += no.getInfo().getValor();
			}
			no = no.getProx();
		}
		if (!(str.isEmpty())){ 
			str += "TOTAL: " + total;
		}
		return str;
	}

}
