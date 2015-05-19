

public class Principal {
	private static Item[] vetorDados;
	private static MetodosOrdenacao metodos = new MetodosOrdenacao();
	
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
					Arquivo.ler(vetorDados, nomeArquivo);
					tempoCarrega = System.nanoTime() - tempoInicial;
					
					metodos.quicksort(vetorDados);
					tempoOrdena = System.nanoTime() - tempoInicial - tempoCarrega;
					
					tempoTotal = System.nanoTime() - tempoInicial;
					System.out.println(nomeArquivo);

					Arquivo.gravar(vetorDados, nomeArquivo);
					
					System.out.println("TEMPO"
							+ "\nCarrega dados : " + tempoCarrega
							+ "\nOrdena        : " + tempoOrdena
							+ "\nTotal         : " + tempoTotal);
						
				}
			}
		}
		//problema com ABB: estouro de pilha; pesquisar sobre como aumentar memória ou outra opção;
		//retornaListaItensCPF(vetorDados,retornaVetorCPF());
		String[] cpf = new String[200];
		Arquivo.lerCpf(cpf);
		MetodosPesquisa.pesqBinaria(vetorDados, cpf);
		
		// balanceamento e caminhamento central não funcionando 
		nomeArquivo = "cliente"+tamanhos[0]+tipos[0];
		ArvoreABB abb = new ArvoreABB();
		Arquivo.ler(abb, nomeArquivo);
		abb.arvBalanceada();
		Item[] vetorABB = abb.camCentral();
		for (int i = 0; i < vetorABB.length; i++) {
			System.out.println(vetorABB[i].getCpf());
		}
		
		// Falta implementar avl.vetorOrdenado()
		ArvoreAVL avl = new ArvoreAVL();
		Arquivo.ler(avl, nomeArquivo);
		Arquivo.gravar(avl.vetorOrdenado(), "AVL");
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
	
}
