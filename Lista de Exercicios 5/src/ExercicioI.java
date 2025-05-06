import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class ExercicioI {
    public static void main(String[] args) {
        // qual pasta quer analisar
        // que palavra você quer encontrar no arquivo
        // listar todos os arquivos, se tiver a extensão, abrir o arquivo e ler linha por linha


        JFileChooser jFileChooser = new JFileChooser("c:\\");
        jFileChooser.setDialogTitle("Escolha uma pasta:");
        jFileChooser.showOpenDialog(null);
        String pasta = jFileChooser.getCurrentDirectory().getAbsolutePath();
        File folder = new File(pasta);
        if(folder.isDirectory()){
            File[] arquivos = folder.listFiles();
            System.out.println("Arquivos da pasta selecionada:");
            for(File file : arquivos)
                System.out.println(file.getName());

            Scanner lerPalavra = new Scanner(System.in);
            System.out.print("Que palavra você quer encontrar no arquivo?: ");
            String palavra = lerPalavra.next();
            System.out.println("Ok, você deseja encontrar arquivos que tenham a palavra "+"'"+palavra+"'.");

                       

        }
    }
}
