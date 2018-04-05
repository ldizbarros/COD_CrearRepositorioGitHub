package usolibreriagithub;

import java.io.IOException;
import org.kohsuke.github.GHCreateRepositoryBuilder;
import org.kohsuke.github.GitHub;

public class Metodos {
    
     public static void crearRepositorio() throws IOException{
        GitHub github = GitHub.connect();
        GHCreateRepositoryBuilder builder;
        builder = github.createRepository("Nuevo  Repositorio");
        builder.create();
    }
    
}
