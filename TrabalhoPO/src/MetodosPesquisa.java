
public class MetodosPesquisa {
	
	public static void pesqBinaria(Item[] dados, String[] cpf) {
		String[] linha = new String[200];
		
		for (int i = 0; i < 200; i++) {
			linha[i] = pesqBinaria(dados, cpf[i]);
		}
		
		Arquivo.gravarCpf(linha, "cpf.txt");
		
	}
	
	private static String pesqBinaria (Item[] _items, String _cpf) {
		int meio, esq, dir;
		esq = 0;
		dir = _items.length-1;
		String cpfEncontrado = "";
		double total;
		int i;
		
		while (esq <= dir){
			meio = (esq + dir)/2;
			
			if (Long.parseLong(_cpf) == _items[meio].getCpfLong()){
				cpfEncontrado += _cpf + "\t-\t" 
						+ _items[meio].getNome() + "\r\n" 
						+ _items[meio].getData() + "\t"
						+ _items[meio].getValor() + "\r\n";
				total =  _items[meio].getValor();
				
				//ANDA COM O VETOR PARA A ESQUERDA PARA VERIFICAR SE EXISTE OUTRO ELEMENTO COM O MESMO CPF
				i = meio -1;
				while ( (i >= 0) && (Long.parseLong(_cpf) == _items[i].getCpfLong()) ){
					cpfEncontrado += _items[i].getData() + "\t"
							+ _items[i].getValor() + "\r\n";
					total += _items[i].getValor();
					i--;
				}
				
				//ANDA COM O VETOR PARA A DIREITA PARA VERIFICAR SE EXISTE OUTRO ELEMENTO COM O MESMO CPF
				i = meio +1;
				while ( (i < _items.length) && (Long.parseLong(_cpf) == _items[i].getCpfLong()) ){
					cpfEncontrado += _items[i].getData() + "\t"
							+ _items[i].getValor() + "\r\n";
					total += _items[i].getValor();
					i++;
				}
				cpfEncontrado += "TOTAL: " + total;
				return cpfEncontrado;
			
			} else {
				if (Long.parseLong(_cpf) < _items[meio].getCpfLong())
					dir = meio - 1;
				else
					esq = meio + 1;
			}
		}
		return (_cpf + " - CPF INEXISTENTE");
	}
}
