package usolibreriagithub;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.eclipse.jgit.api.errors.GitAPIException;

public class Menu {
    
    public static void menu(){
        Display.mostrarMenu();
        
        int opcion = Integer.parseInt(JOptionPane.showInputDialog("Intruduce una opcion"));
        
        while(opcion!=0){
            switch(opcion){
                case 1: try {
                            Metodos.crearRepositorioRemoto("RepositorioPrueba");
                        } catch (IOException ex) {
                            Logger.getLogger(MavenProject.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                case 2: try {
                            Metodos.clonarRepositorio("https://github.com/ldizbarros/COD_CrearRepositorioGitHub.git", "/home/local/DANIELCASTELAO/ldizbarros/NetBeansProjects/CrearRepositorioGitHub");
                        } catch (GitAPIException ex) {
                            Logger.getLogger(MavenProject.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                case 3:  try {
                            Metodos.inicializarRepositorio("/home/local/DANIELCASTELAO/ldizbarros/NetBeansProjects/JavaApplication126");
                        } catch (IOException | GitAPIException ex) {
                            Logger.getLogger(MavenProject.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                case 4: try {
                            Metodos.hacerCommit("/home/local/DANIELCASTELAO/ldizbarros/NetBeansProjects/JavaApplication125/.git", "PRUEBA COMMIT");
                        } catch (GitAPIException | IOException ex) {
                            Logger.getLogger(MavenProject.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                case 5: try {
                            Metodos.hacerPush("/home/local/DANIELCASTELAO/ldizbarros/NetBeansProjects/JavaApplication133/.git", "https://github.com/ldizbarros/prueba.git");
                        } catch (IOException ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (URISyntaxException ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (GitAPIException ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                case 0: break;
                default: System.out.println("Opcion no valida");
            }
            
            Display.mostrarMenu();
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Intruduce una opcion"));
        }
    }
}
