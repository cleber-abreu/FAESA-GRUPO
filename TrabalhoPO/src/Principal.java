

public class Principal {
	private static Item[] vetorDados;

	public static void main(String[] args) {
		long tempoInicial = 0;// = System.currentTimeMillis();
		long tempoCarrega = 0, tempoOrdena = 0, tempoTotal = 0, tempoPesquisa = 0;
		ArvoreABB abb;
		ArvoreAVL avl;
		boolean primeiroLoop;
		long tempoVetorQS = 0, tempoVetorQI = 0, tempoABB = 0, tempoAVL = 0, tempoHash = 0;
		
		String[] tipos = {"alea","ord","inv"};
		//String[] tipos = {"alea"};
		String nomeArquivo = "";
		String[] cpf;
		//int[] tamanhos = {500,1000,5000,10000,50000};
		int[] tamanhos = {500};
		
		for (int j = 0; j < tamanhos.length; j++) {
			for (int k = 0; k < tipos.length; k++) {
				tempoVetorQS = 0; tempoVetorQI = 0; tempoABB = 0; tempoAVL = 0; tempoHash = 0;
				primeiroLoop = true;
				for (int l = 0; l < 6; l++) {
					tempoCarrega = 0; tempoOrdena = 0; tempoTotal = 0; tempoPesquisa = 0;
					
					/* VETOR QUICKSORT */
					tempoInicial = System.currentTimeMillis();
					
					vetorDados = new Item[tamanhos[j]];
					nomeArquivo = "cliente"+tamanhos[j]+tipos[k];
					Arquivo.ler(vetorDados, nomeArquivo);
					
					MetodosOrdenacao.quicksort(vetorDados);
					Arquivo.gravar(vetorDados, nomeArquivo);

					cpf = new String[200];
					Arquivo.lerCpf(cpf); //A gravação do arquivo cpf é feita diretamente no método "Arquivo.lerCpf"
					MetodosPesquisa.pesqBinaria(vetorDados, cpf);

					tempoTotal = System.currentTimeMillis() - tempoInicial;
					
					//Se não for o primeiro loop, começa a grava o tempo gasto, foi feito isso porque o tempo gasto 
					//para ler o arquivo na primeira vez é maior;  
					if (!primeiroLoop) {
						//System.out.println("Total Quick: "+tempoTotal);
						tempoVetorQS += tempoTotal;
					}
					
					/* VETOR QUICKSORT + INSERÇÃO */
					tempoInicial = System.currentTimeMillis();
					
					vetorDados = new Item[tamanhos[j]];
					nomeArquivo = "cliente"+tamanhos[j]+tipos[k];
					Arquivo.ler(vetorDados, nomeArquivo);
					
					MetodosOrdenacao.quickInsert(vetorDados);
					Arquivo.gravar(vetorDados, nomeArquivo);

					cpf = new String[200];
					Arquivo.lerCpf(cpf); 
					
					MetodosPesquisa.pesqBinaria(vetorDados, cpf);
					//A gravação do arquivo cpf é feita diretamente no método "MetodosPesquisa.pesqBinaria"

					tempoTotal = System.currentTimeMillis() - tempoInicial;
					
					//Se não for o primeiro loop, começa a grava o tempo gasto, foi feito isso porque o tempo gasto 
					//para ler o arquivo na primeira vez é maior;  
					if (!primeiroLoop) {
						//System.out.println("Total Quick Insert: "+tempoTotal);
						tempoVetorQI += tempoTotal;
					}
					
					/* ABB */
					//problema com ABB: estouro de pilha; pesquisar sobre como aumentar memoria ou outra opção;
					nomeArquivo = "cliente"+tamanhos[j]+tipos[k];
					tempoInicial = System.currentTimeMillis();
					abb = new ArvoreABB();
					Arquivo.ler(abb, nomeArquivo);
					//tempoCarrega = System.nanoTime() - tempoInicial;
					
					abb.arvBalanceada();
					//tempoOrdena = System.nanoTime() - tempoInicial - tempoCarrega;
					
					Arquivo.gravar( abb.camCentral(), "ABB-"+tamanhos[j]+tipos[k]);
					tempoTotal = System.currentTimeMillis() - tempoInicial;
					if (!primeiroLoop) tempoABB += tempoTotal;
					
					/*System.out.println("\nABB"
							+ "\nCarregar dados : " + tempoCarrega
							+ "\nBalanceamento  : " + tempoOrdena
							+ "\nTotal          : " + tempoTotal);
					*/
					
					/* AVL */
					/*
					tempoInicial = System.nanoTime();
					avl = new ArvoreAVL();
					Arquivo.ler(avl, nomeArquivo);
					tempoCarrega = System.nanoTime() - tempoInicial;
					
					Arquivo.gravar(avl.vetorOrdenado(), "AVL");
					tempoTotal = System.nanoTime() - tempoInicial;
					if (!primeiroLoop) tempoAVL += tempoTotal;
					System.out.println("\nAVL"
							+ "\nCarregar dados : " + tempoCarrega
							+ "\nTotal          : " + tempoTotal);

					*/
					
					/* HASHING */
					
					primeiroLoop = false;
				}
				System.out.println("Arquivo: " + tamanhos[j]+" - "+ tipos[k]+ " - Média Vetor Quick: " +(tempoVetorQS/5));
				System.out.println("Arquivo: " + tamanhos[j]+" - "+ tipos[k]+ " - Média Vetor Quick Insert: " +(tempoVetorQI/5));
				System.out.println("Arquivo: " + tamanhos[j]+" - "+ tipos[k]+ " - Média ABB: " +(tempoABB/5));
			}
		}
		System.out.println("FIM! =)");
		
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
