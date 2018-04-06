package usolibreriagithub;

import java.io.File;
import java.io.IOException;
import org.eclipse.jgit.api.AddCommand;
import org.eclipse.jgit.api.CommitCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.InitCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.kohsuke.github.GHCreateRepositoryBuilder;
import org.eclipse.jgit.lib.Repository;
import org.kohsuke.github.GitHub;


public class Metodos {
    
    public static void crearRepositorio(String nuevoRepositorio) throws IOException{
        GitHub github = GitHub.connect();
        GHCreateRepositoryBuilder builder;
        builder = github.createRepository(nuevoRepositorio);
        builder.create();
    }
    
    public static void clonarRepositorio(String URIrepositorio, String directorio) throws GitAPIException{
        Git git = Git.cloneRepository()
            .setURI(URIrepositorio)
            .setDirectory(new File(directorio))
            .setCloneAllBranches(true)
            .call();
    }
    
    public static void inicializarRepositorio(String direcionRepositorio) throws IOException, GitAPIException {
        InitCommand inicializar = new InitCommand();
        inicializar.setDirectory(new File(direcionRepositorio))
                .call();
    } 
    
    public static void hacerCommit(String direcionRepositorio, String fraseCommit) throws IOException, GitAPIException{
        FileRepositoryBuilder constructorRepositorio = new FileRepositoryBuilder();
        Repository repositorio = constructorRepositorio.setGitDir(new File(direcionRepositorio))
                .readEnvironment() // scan environment GIT_* variables
                .findGitDir() // scan up the file system tree
                .setMustExist(true)
                .build();
        
        Git git = new Git(repositorio);
        AddCommand add = git.add();
        add.addFilepattern(direcionRepositorio).call();
        
        CommitCommand commit = git.commit();
        commit.setMessage(fraseCommit).call();
    }
}
