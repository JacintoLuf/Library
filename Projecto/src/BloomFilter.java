import java.util.HashMap;

public class BloomFilter {
    private HashMap<Integer, Livro> lista;
    private int kHashes;

    public BloomFilter(int n, int k){
        lista = new HashMap<>();
        this.kHashes = k;
    }
    public void add(Livro l){
        for(int i=1; i<kHashes; i++){
            int index = l.hashCode();
            lista.put(index, l);
        }
    }
    public boolean contains(Livro l){
        for(int i=1; i<kHashes; i++){
            int index = l.hashCode();
            if(!lista.containsKey(index)){
                return false;
            }
        }
        return true;
    }
}
