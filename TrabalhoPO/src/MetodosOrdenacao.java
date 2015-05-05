
public class MetodosOrdenacao {
	
	public void quicksort (Item[] _lista) {
		ordena (0, _lista.length-1, _lista);
	}
	
	private void ordena (int esq, int dir, Item[] _lista) {
		int i = esq, j = dir;
		long pivo;
		Item temp;
		pivo = _lista[(i+j)/2].getCpfLong();
		
		do {
			while (_lista[i].getCpfLong() < pivo)
				i++;
			
			while (_lista[j].getCpfLong() > pivo)
				j--;
			
			if (i <= j) {
				temp = _lista[i];
				_lista[i] = _lista[j];
				_lista[j] = temp;
				i++;
				j--;
			}
		} while (i <= j);
		
		if (esq < j){
			ordena (esq, j, _lista);
		}
		if (dir > i){
			ordena (i, dir, _lista);
		}
	}
}
