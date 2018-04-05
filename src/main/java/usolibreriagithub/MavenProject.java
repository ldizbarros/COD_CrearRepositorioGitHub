package usolibreriagithub;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MavenProject {

    public static void main(String[] args) {
        try {
            Metodos.crearRepositorio();
        } catch (IOException ex) {
            Logger.getLogger(MavenProject.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
