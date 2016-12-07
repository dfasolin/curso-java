package app.filmes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dfasolin
 */
public class Cinemateca {
    
    private List<Filme> filmes = new ArrayList<>();
    
    public Cinemateca() {
        Filme f1 = new Filme();
        f1.setAno(2016);
        f1.setDiretor("Jonh");
        f1.setDuracao(120);
        f1.setImdb("tt2543164");
        f1.setTitulo("The Arrival");
        
        Filme f2 = new Filme();
        f2.setAno(2016);
        f2.setDiretor("Paul");
        f2.setDuracao(120);
        f2.setImdb("tt3748528");
        f2.setTitulo("Rogue One: A Star Wars Story");
        
        filmes.add(f1);
        filmes.add(f2);
    } 

    public List<Filme> getFilmes() {
        return filmes;
    }
    
}
