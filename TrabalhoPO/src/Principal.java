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
					
					nomeArquivo = "cliente"+tamanhos[j]+tipos[k]+".txt";
					Arquivo.ler(vetorDados, nomeArquivo);
					tempoCarrega = System.nanoTime() - tempoInicial;
					
					metodos.quicksort(vetorDados);
					tempoOrdena = System.nanoTime() - tempoInicial - tempoCarrega;
					
					tempoTotal = System.nanoTime() - tempoInicial;
					System.out.println(nomeArquivo);

					imprimeVetorDados();
					
					System.out.println("TEMPO"
							+ "\nCarrega dados : " + tempoCarrega
							+ "\nOrdena        : " + tempoOrdena
							+ "\nTotal         : " + tempoTotal);
						
				}
			}
		}
		//problema com ABB: estouro de pilha; pesquisar sobre como aumentar memória ou outra opção;
		retornaListaItensCPF(vetorDados,retornaVetorCPF());
	}
	
	public static void imprimeVetorDados(){
		String mostraVetor = "\n";
		for (int i = 0; i < vetorDados.length; i++) {
			mostraVetor += vetorDados[i].getCpf() + " \t-\t" 
					+ vetorDados[i].getNome() + " \t-\t" 
					+ vetorDados[i].getData() + " \t-\t" 
					+ vetorDados[i].getValor() + "\n";
		}
		System.out.println(mostraVetor);
		
	}
	
	public static String[] retornaVetorCPF(){
		String[] VetorCPF = new String[200];
		Arquivo.lerCpf(VetorCPF);

		return VetorCPF;
	}
	
	//BUSCA OS CPFs NO VETOR DE ITEM E GRAVA OS DADOS NO ARQUIVO
	public static void retornaListaItensCPF(Item[] items, String[] cpfs){
		for (int i = 0; i < cpfs.length; i++) {
			String indices = pesqBinaria(items,cpfs[i]);//A PESQUISA RETORNA UMA STRING COM OS INDICES ENCONTRADOS PARA O CPF ENVIADO
			double soma = 0;
			
			if (indices != null){
				String[] encontrados = indices.split(","); //CRIA UM VETOR COM A STRING DA PESQUISA
				for (int j = 0; j < encontrados.length; j++) {
					//PARA CADA INDICE ENCONTRADO, MOSTRA OS DADOS CORRESPONDENTE (ALTERAR PARA GRAVAR EM UM ARQUIVO)
					int encontrado = Integer.parseInt(encontrados[j]);
					System.out.println(items[encontrado].getCpf()+" - "+items[encontrado].getNome()+" - "+
						items[encontrado].getData()+" - "+items[encontrado].getValor());
					soma += items[encontrado].getValor();
				}
				System.out.println("Total = "+soma);
			}else{
				//SE NAO ENCONTRAR NENHUM ELEMENTO DO VETOR ITEM COM O CPF ENVIADO, RETORNA A MENSAGEM (GRABAR NO ARQUIVO A MENSAGEM)
				System.out.println("CPF INVÁLIDO");
			}
		}
	}
	
	public static String pesqBinaria (Item[] _items, String _cpf){
		int meio, esq, dir;
		esq = 0;
		dir = _items.length-1;
		String posicoes = "";
		int i;
		while (esq <= dir){
			meio = (esq + dir)/2;
			if (Long.parseLong(_cpf) == _items[meio].getCpfLong()){
				posicoes += meio+","; //SE ACHAR O CPF NA POSICAO DO MEIO, VERIFICA AS POSICOES ADJACENTES;
				//ANDA COM O VETOR PARA A ESQUERDA PARA VERIFICAR SE EXISTE OUTRO ELEMENTO COM O MESMO CPF
				i = meio -1;
				while ( (i >= 0) && (Long.parseLong(_cpf) == _items[i].getCpfLong()) ){
					posicoes += i+",";
					i--;
				}
				//ANDA COM O VETOR PARA A DIREITA PARA VERIFICAR SE EXISTE OUTRO ELEMENTO COM O MESMO CPF
				i = meio +1;
				while ( (i < _items.length) && (Long.parseLong(_cpf) == _items[i].getCpfLong()) ){
					posicoes += i+",";
					i++;
				}
				return posicoes;
			
			}else{
				if (Long.parseLong(_cpf) < _items[meio].getCpfLong())
					dir = meio - 1;
				else
					esq = meio + 1;
			}
		}
		return null;
	}
}
