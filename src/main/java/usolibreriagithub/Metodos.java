package usolibreriagithub;

import java.io.IOException;
import org.kohsuke.github.GHCreateRepositoryBuilder;
import org.kohsuke.github.GitHub;

public class Metodos {
    
    public static void crearRepositorio(String nuevoRepositorio) throws IOException{
        GitHub github = GitHub.connect();
        GHCreateRepositoryBuilder builder;
        builder = github.createRepository(nuevoRepositorio);
        builder.create();
    }
    
}
