import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Principal {
	private static Item[] vetorDados;
	private static MetodosOrdenacao metodos = new MetodosOrdenacao();
	
	private static void carregaDados(String caminho) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(caminho));
			String linha = "";
			String campo[];
			int i = 0;
			
			while ((linha = in.readLine()) != null) {
				campo = linha.split(";");
				vetorDados[i] = new Item(campo[0], campo[1], campo[2], campo[3]);
				i++;
			}
			
			in.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		long tempoInicial;// = System.currentTimeMillis();
		long tempoCarrega, tempoOrdena, tempoTotal = 0;
		
		//String[] tipos = {"alea","ord","inv"};
		String[] tipos = {"alea"};
		String nomeArquivo = "";
		//int[] tamanhos = {500,1000,5000,10000,50000};
		int[] tamanhos = {500};
		
		for (int j = 0; j < tamanhos.length; j++) {
			for (int k = 0; k < tipos.length; k++) {
				for (int l = 0; l < 1; l++) {
					vetorDados = new Item[tamanhos[j]];
					tempoInicial = System.nanoTime();
					
					nomeArquivo = "cliente"+tamanhos[j]+tipos[k];
					carregaDados("./Dados/Entrada/"+nomeArquivo+".txt");
					tempoCarrega = System.nanoTime() - tempoInicial;
					
					metodos.quicksort(vetorDados);
					tempoOrdena = System.nanoTime() - tempoInicial - tempoCarrega;
					
					tempoTotal = System.nanoTime() - tempoInicial;
					System.out.println(nomeArquivo);
					ImprimeVetorDados();
					
					System.out.println("TEMPO"
							+ "\nCarrega dados : " + tempoCarrega
							+ "\nOrdena        : " + tempoOrdena
							+ "\nTotal         : " + tempoTotal);
						
				}
			}
		}
		//problema com ABB: estouro de pilha; pesquisar sobre como aumentar memória ou outra opção;
		RetornaListaItensCPF(vetorDados,RetornaVetorCPF());
	}
	
	public static void ImprimeVetorDados(){
		String mostraVetor = "\n";
		for (int i = 0; i < vetorDados.length; i++) {
			mostraVetor += vetorDados[i].getCpf() + " \t-\t" 
					+ vetorDados[i].getNome() + " \t-\t" 
					+ vetorDados[i].getData() + " \t-\t" 
					+ vetorDados[i].getValor() + "\n";
		}
		System.out.println(mostraVetor);
	}
	
	public static String[] RetornaVetorCPF(){
		String[] VetorCPF = new String[200];
		try {
			BufferedReader in = new BufferedReader(new FileReader("./Dados/Entrada/cpf.txt"));
			String linha = "";
			int i = 0;
			
			while ((linha = in.readLine()) != null) {
				VetorCPF[i] = linha;
				i++;
			}
			in.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return VetorCPF;
	}
	
	public static void RetornaListaItensCPF(Item[] items, String[] cpfs){
		for (int i = 0; i < cpfs.length; i++) {
			int indice = pesqBinaria(items,cpfs[i]);
			
			if (indice != -1){
				System.out.println(items[indice].getCpf()+" - "+items[indice].getNome()+" - "+
					items[indice].getData()+" - "+items[indice].getValor());
			}else{
				System.out.println("CPF INVÁLIDO");
			}
		}
	}
	
	public static int pesqBinaria (Item[] _items, String _cpf){
		int meio, esq, dir;
		esq = 0;
		dir = _items.length-1;
		while (esq <= dir){
			meio = (esq + dir)/2;
			if (Long.parseLong(_cpf) == _items[meio].getCpfLong())
				return meio;
			else{
				if (Long.parseLong(_cpf) < _items[meio].getCpfLong())
					dir = meio - 1;
				else
					esq = meio + 1;
			}
		}
		return -1;
	}
}
