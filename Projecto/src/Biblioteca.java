import java.io.*;

public class Biblioteca{
    private BloomFilter biblioteca;

    public Biblioteca(String file) throws IOException{
        biblioteca = new BloomFilter(100, 3);
        BufferedReader read = new BufferedReader(new FileReader(file));
        String ln = read.readLine();
        while(ln != null) {
            String[] s = ln.split(";");
            for(int i=0; i<Integer.valueOf(s[2]); i++) {
                biblioteca.add(new Livro(s[0], s[1]));
            }
            System.out.printf("titulo: %s; categoria: %s; copias: %s\n", s[0], s[1], s[2]);
            ln = read.readLine();
        }
    }
}
