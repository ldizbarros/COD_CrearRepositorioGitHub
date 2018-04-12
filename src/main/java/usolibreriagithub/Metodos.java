package usolibreriagithub;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;
import org.eclipse.jgit.api.AddCommand;
import org.eclipse.jgit.api.CommitCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.InitCommand;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.RemoteAddCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.kohsuke.github.GHCreateRepositoryBuilder;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.kohsuke.github.GitHub;

/**
 * Clase Metodos.
 * Esta clase contiene todos los metodos que hacen funcionar la aplicacion.
 * @author ldizbarros
 */
public class Metodos {
    
    /**
     * Metodo estatico crearRepositorioRemoto. En este metodo se hace una conexion
     * con la cuenta del usuario de github y se crea un repositorio nuevo con el 
     * nombre que se le pasa por parametro.
     * @param nuevoRepositorio string que sera el nombre de nuestro repositorio en github
     * @throws IOException lanza una excepcion si hay algun problema con la conexion de la cuenta
     */
    public static void crearRepositorioRemoto(String nuevoRepositorio) throws IOException{
        GitHub github = GitHub.connect();
        GHCreateRepositoryBuilder builder;
        builder = github.createRepository(nuevoRepositorio);
        builder.create();
    }
    
    /**
     * Metodo estatico clonarRepositorio. Este metodo clona un repositiorio de
     * github a partir de la url del repositorio la cual le pasamos por parametro.
     * @param URIrepositorio url del repositorio que queremos clonar
     * @param directorio direccion del direcorio donde queremos guardar el repositorio
     * @throws GitAPIException lanza una excepcion si se produce algun problema en la conexion con la API
     */
    public static void clonarRepositorio(String URIrepositorio, String directorio) throws GitAPIException{
        Git git = Git.cloneRepository()
            .setURI(URIrepositorio)
            .setDirectory(new File(directorio))
            .setCloneAllBranches(true)
            .call();
    }
    
    /**
     * Metodo estatico inicializarRepositorio. Este metodo inicualiza en git el repositorio 
     * que se pasa por parametro
     * @param direcionRepositorio direccion del repositorio que queremos inicializar
     * @throws IOException lanza una excepcion si hay algun problema con la conexion
     * @throws GitAPIException lanza una excepcion si se produce algun problema en la conexion con la API
     */
    public static void inicializarRepositorio(String direcionRepositorio) throws IOException, GitAPIException {
        InitCommand inicializar = new InitCommand();
        inicializar.setDirectory(new File(direcionRepositorio))
                .call();
    } 
    
    /**
     * Metodo estatico hacerCommit. Este metodo coge un proyecto que le pasas por parametro
     * (tiene que estar inicializado ya en git), añadde las furntes y hace un commit
     * con el texto que se le pasa por parametro.
     * @param direcionRepositorio direccion de la carpeta .git del proyecto 
     * @param fraseCommit frase que queremos que tenga el commit
     * @throws IOException lanza una excepcion si hay algun problema con la conexion
     * @throws GitAPIException lanza una excepcion si se produce algun problema en la conexion con la API
     */
    public static void hacerCommit(String direcionRepositorio, String fraseCommit) throws IOException, GitAPIException{
        FileRepositoryBuilder constructorRepositorio = new FileRepositoryBuilder();
        Repository repositorio = constructorRepositorio.setGitDir(new File(direcionRepositorio))
                .readEnvironment() 
                .findGitDir() 
                .setMustExist(true)
                .build();
        
        Git git = new Git(repositorio);
        AddCommand add = git.add();
        add.addFilepattern(direcionRepositorio).call();
        
        CommitCommand commit = git.commit();
        commit.setMessage(fraseCommit).call();
    }
    
    /**
     * Metodo estatica hacerPush. Este metodo hace push del direcctorio que se le
     * pasa por parametro al repositorio remoto con la url que tambien pasamos como
     * parametro.
     * @param direcionRepositorio direccion del direcctorio .git del repositorio del que queremos hacer push
     * @param URIrepositorio url del repositorio remoto donde queremos hacer push
     * @throws IOException lanza una excepcion si hay algun problema con la conexion
     * @throws URISyntaxException lanza una excepcion si hay algun error con la url del repositorio remoto
     * @throws GitAPIException lanza una excepcion si se produce algun problema en la conexion con la API
     */
    public static void hacerPush(String direcionRepositorio,String URIrepositorio) throws IOException, URISyntaxException, GitAPIException{
        FileRepositoryBuilder constructorRepositorio = new FileRepositoryBuilder();
        Repository repositorio = constructorRepositorio.setGitDir(new File(direcionRepositorio))
                .readEnvironment() 
                .findGitDir() 
                .setMustExist(true)
                .build();
        
        Git git = new Git(repositorio);

        RemoteAddCommand remoteAddCommand = git.remoteAdd();
        remoteAddCommand.setName("origin");
        remoteAddCommand.setUri(new URIish(URIrepositorio));
        remoteAddCommand.call();

        PushCommand pushCommand = git.push();
        pushCommand.setCredentialsProvider(new UsernamePasswordCredentialsProvider(JOptionPane.showInputDialog("Introduce el usuario de git"), JOptionPane.showInputDialog("Introduce la contraseña de git")));
        pushCommand.call();
    }
}
