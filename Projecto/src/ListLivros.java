import java.util.*;

public class ListLivros {
	private ArrayList<Livro> livros = new ArrayList<>();
	private ArrayList<Integer> quantidade = new ArrayList<>();
	
	public int getQuantidade(Livro liv) {
		return quantidade.get(livros.indexOf(liv));
	}
	
	public Livro getLivro(int j) {
		return livros.get(j);
	}
	
	public int getLivroIndex(Livro liv) {
		if(livros.contains(liv))
			return livros.indexOf(liv);
		return -1;
	}

	public ArrayList<Livro> getLivros() {
		return livros;
	}
	
	public int size() {
		return livros.size();
	}
	
	public boolean addLivro(Livro liv,int qnt) {
		if (size()>0) {
			for (int i = 0; i < size(); i++) {
				if(liv.getTitulo().equals(livros.get(i).getTitulo()))
					return false;
			}
		}
		
		livros.add(liv);
		liv.setId(livros.size());
		quantidade.add(qnt);
		return true;
	}
	
	public boolean removeLivro(Livro liv) {
		if(!livros.contains(liv))
			return false;
		
		quantidade.remove(getQuantidade(liv));
		livros.remove(liv);
		return true;
	}
	
	public boolean addUnidade(Livro liv,int qnt) {
		if(!livros.contains(liv))
			return false;
		quantidade.set(getQuantidade(liv),getQuantidade(liv)+qnt);
		return true;
	}
	
	public boolean removeunidade(Livro liv,int qnt) {
		if(!livros.contains(liv))
			return false;
		if(getQuantidade(liv)-qnt <=0) {
			livros.remove(liv);
			System.out.println("O livro foi removido");
			return true;
		}
		quantidade.set(getQuantidade(liv),getQuantidade(liv)-qnt);
		return true;
	}

	@Override
	public String toString() {
		String str = "Livros na Bibioteca:\nTitulo";
		for (int i = 0; i < 73; i++) {
			str+=" ";
			if(i==71)
				str+="|";
		}
		
		str+="Quantidade";
		
		for (int i = 0; i < livros.size(); i++) {
			str+="\n"+livros.get(i).toString();
			int tmp =79-livros.get(i).toString().length();
			for (int j = 0; j < tmp; j++) {
				str+=" ";
				if(j==tmp-2)
					str = "|";
			}
			
			str+=quantidade.get(i);
		}
		return str;
	}
	
}
