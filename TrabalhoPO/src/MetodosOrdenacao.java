
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
	
	public void quickInsert (Item[] _lista) {
		quickInsert (_lista, 0, _lista.length-1);
	}
	
	private void quickInsert (Item[] _lista, int esq, int dir) {
		int i = left, j = right;
        Item tmp;
        Long pivot = _lista[(i+j)/2].getCpfLong();

        while (i <= j) {
            while (_lista[i].getCpfLong() < pivot) {
                i++;
            }

            while (_lista[j].getCpfLong() > pivot) {
                j--;
            }
            if (i <= j) {
                tmp = _lista[i];
                _lista[i] = _lista[j];
                _lista[j] = tmp;
                i++;
                j--;
            }
        }

        if (left < j) {
            if ((j - left) > 25) {
                quickInsert(_lista, left, j);
            } else {
                insertionSort(_lista, left, j);
            }
        }
        if (right > i) {
            if ((right - i) > 25) {
                quickInsert(_lista, i, right);
            } else {
                insertionSort(_lista, i, right);
            }
        }
	}
	
	private static void insertionSort(Item[] _lista, int left, int right) {
        int i, j;
        Item tmp;
        for (i = left + 1; i <= right; i++) {
            tmp = _lista[i];
            j = i;
            while (j > 0 && _lista[j - 1].getCpfLong() > tmp.getCpfLong()) {
                _lista[j] = _lista[j - 1];
                j--;
            }
            _lista[j] = tmp;
        }
    }
}
