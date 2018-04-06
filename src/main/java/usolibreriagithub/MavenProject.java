package usolibreriagithub;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jgit.api.errors.GitAPIException;

public class MavenProject {

    public static void main(String[] args) {
        
            //        try {
//            Metodos.crearRepositorio("RepositorioPrueba");
//        } catch (IOException ex) {
//            Logger.getLogger(MavenProject.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        try {
//            Metodos.clonarRepositorio("https://github.com/ldizbarros/COD_CrearRepositorioGitHub.git", "/home/local/DANIELCASTELAO/ldizbarros/NetBeansProjects/CrearRepositorioGitHub");
//        } catch (GitAPIException ex) {
//            Logger.getLogger(MavenProject.class.getName()).log(Level.SEVERE, null, ex);
//        }
        try {
            Metodos.hacerCommit("/home/local/DANIELCASTELAO/ldizbarros/NetBeansProjects/JavaApplication125/.git", "PRUEBA COMMIT");
        } catch (GitAPIException | IOException ex) {
            Logger.getLogger(MavenProject.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
