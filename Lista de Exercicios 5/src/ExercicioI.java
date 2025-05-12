import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class ExercicioI {
    public static void main(String[] args) {
        // qual pasta quer analisar
        JFileChooser jFileChooser = new JFileChooser("c:\\");
        jFileChooser.setDialogTitle("Escolha uma pasta:");
        jFileChooser.showOpenDialog(null);
        String pasta = jFileChooser.getCurrentDirectory().getAbsolutePath();
        File folder = new File(pasta);

        // verifica se é diretorio
        if(folder.isDirectory()){
            File[] arquivos = folder.listFiles();
            System.out.println("Arquivos da pasta selecionada:");
            for(File file : arquivos) // mostra arquivos na pasta
                System.out.println(file.getName());

            // que palavra você quer encontrar no arquivo
            Scanner lerPalavra = new Scanner(System.in);
            String palavra = JOptionPane.showInputDialog(null, "Que palavra você quer encontrar?");
            System.out.println("Ok, você deseja encontrar arquivos que tenham a palavra '" + palavra + "'.");

            String[] extensoesValidas = {".java", ".cpp", ".py", ".js"}; // extensoes permitidas
            String[] arquivosComPalavra = new String[arquivos.length]; // armazena arquivos que tem a palavra
            int i = 0;

            for (File file : arquivos) {
                if (file.isFile()) {
                    String nome = file.getName().toLowerCase();

                    // arquivo tem uma das extensoes?
                    boolean extensaoValida = false;
                    for (String ext : extensoesValidas) {
                        if (nome.endsWith(ext)) {
                            extensaoValida = true;
                            break;
                        }
                    }
                    if (extensaoValida) {
                        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                            String linha;
                            while ((linha = br.readLine()) != null) {
                                if (linha.contains(palavra)) {
                                    arquivosComPalavra[i] = file.getName();
                                    i++;
                                    break;
                                }
                            }
                        }
                        catch (Exception e){
                            System.err.println("Problemas: " +e.toString());
                        }
                    }
                }
            }

            // exibe os arquivos que tem a palavra
            if (i == 0)
                System.out.println("Nenhum arquivo contém a palavra '" + palavra + "'.");
            else
            {
                System.out.println("A palavra '" + palavra + "' foi encontrada nos seguintes arquivos:");
                for (int j = 0; j < i; j++)
                    System.out.println("- " + arquivosComPalavra[j]);
            }
        }
        else
            System.out.println("A seleção não é uma pasta válida.");
    }
}