package usolibreriagithub;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.eclipse.jgit.api.errors.GitAPIException;

/**
 * Clase Menu.
 * En esta clase tenemos un metodo menu() con un switch con las distintas opciones del programa.
 * @author ldizbarros
 */
public class Menu {
    
    /**
     * Metodo estatico menu().
     * En este metodo, primero se llama a la clase Display donde se muestran las opciones
     * del menu por pantalla.
     * Despues tenemos un bucle while con el que se pedira una opcion al usuario hasta
     * que este decida salir.
     * En el switch tenemos las distintas llamadas a los metodos de la clase Metodos
     */
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
                            Metodos.clonarRepositorio("https://github.com/usuario/repositorio.git", "/direccion/local/del/repositorio/NetBeansProjects/Repositorio");
                        } catch (GitAPIException ex) {
                            Logger.getLogger(MavenProject.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                case 3:  try {
                            Metodos.inicializarRepositorio("/direccion/local/del/repositorio/NetBeansProjects/Repositorio");
                        } catch (IOException | GitAPIException ex) {
                            Logger.getLogger(MavenProject.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                case 4: try {
                            Metodos.hacerCommit("/direccion/local/del/repositorio/NetBeansProjects/Repositorio/.git", "PRUEBA COMMIT");
                        } catch (GitAPIException | IOException ex) {
                            Logger.getLogger(MavenProject.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                case 5: try {
                            Metodos.hacerPush("/direccion/local/del/repositorio/NetBeansProjects/Repositorio/.git", "https://github.com/usuario/repositorio.git");
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
