import java.util.*;

public class MinHashing {
	
	private int nrHashFunc;
	private List<String> lista;
	private String titulo;
	
	public MinHashing(int nrHashFunc, List<String> lista) {
		this.nrHashFunc = nrHashFunc;
		this.lista = lista;
	}
	
	public MinHashing(int nrHashFunc, String titulo) {
		this.nrHashFunc = nrHashFunc;
		this.titulo = titulo;
	}

	
	public int[] getMinHashValuesList() {
		return getMinHashValuesList(lista,nrHashFunc);
	}
	
	public int[] getMinHashValuesTitle() {
		return getMinHashValuesTitulo(titulo,nrHashFunc);
	}
	
	private int[] getMinHashValuesList(List<String> list,int numeroHash) { //para uma lista de livros
		int[] minHash = new int[numeroHash];
		String title;
		int hash,temp;
		
		for (int i = 0; i < numeroHash; i++) {
			temp = 100000000;
			
			for (int j = 0; j < list.size(); j++) {
				
				title = Math.sqrt(i)+lista.get(j)+Math.sqrt(i);
				
				hash = Math.abs(title.hashCode()/lista.size());
				
				if (hash<temp)
					temp = hash;
			}
			
			minHash[i] = temp;
		}
		return minHash;
	}
	
	private int[] getMinHashValuesTitulo(String titulo,int numeroHash) { //so para um livro
		int[] minHash = new int[numeroHash];
		String title;
		int hash;
		
		for (int i = 0; i < numeroHash; i++) {
							
			title = Math.sqrt(i)+titulo+Math.sqrt(i);
				
			hash = Math.abs(title.hashCode()/lista.size());
									
			minHash[i] = hash;
		}
		return minHash;
	}
	
	public static double jaccardIndex(Set<Integer> set1,Set<Integer> set2) {
		Set<Integer> intersecao = new HashSet<>(set1);
		intersecao.retainAll(set2);
		
		Set<Integer> uniao = new HashSet<>(set1);
		uniao.addAll(set2);
		
		if(uniao.isEmpty()) return 0;
		return (double) intersecao.size()/uniao.size();
	}
	
	public static double indiceSimilaridade(int[] ind1,int[] ind2) {
		int size =1;
		int w =0;
		int[]array;
		
		if (ind1.length == ind2.length) {
			size = ind2.length;
			for (int i = 0; i < size; i++) {
				if(ind1[i]==ind2[i])
					w+=1;
			}
		}
		
		if(ind1.length < ind2.length) {
			size = ind2.length;
			array = new int[ind2.length];
			
			for (int i = 0; i < ind2.length; i++) {
				if (i<ind1.length)
					array[i]=ind1[i];
				else
					array[i]=0;
			}
			for (int i = 0; i <size; i++) {
				if(ind2[i]==array[i])
					w+=1;
			}
		}else {
			size = ind1.length;
			array = new int[ind1.length];
			
			for (int i = 0; i < ind1.length; i++) {
				if (i<ind2.length)
					array[i]=ind2[i];
				else
					array[i]=0;
			}
			for (int i = 0; i <size; i++) {
				if(ind1[i]==array[i])
					w+=1;
			}
		}
		
		return (double)w/size;
	}
	
	
	
	

}
