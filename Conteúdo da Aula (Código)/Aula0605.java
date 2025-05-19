import javax.swing.*;
import java.io.File;

public class Aula0605 {
    public static void main(String[] args) {
          // Mostra o espaço total do disco onde está o arquivo
//        File file = new File("d:/Ferramentas Computacionais I/news.txt");
//        System.out.println(file.getTotalSpace()/1024/1024/1024); // espaço do disco
//        if(file.isDirectory())
//            System.out.println(file.getAbsolutePath()+" é uma pasta");
//        file.delete();

        // Mostra quais arquivos pertencem a determinada pasta
//        File folder = new File("d:/Ferramentas Computacionais I");
//        if(folder.isDirectory()){
            //String[] arquivos = folder.list();
//            File[] arquivos = folder.listFiles();

            //for(int i = 0; i < arquivos.length; i++)
//            for(File file : arquivos)
                //System.out.println(arquivos[i]);
//                if(file.isFile() && file.getName().endsWith("exe"))
//                    file.delete();

            // Lista os arquivos da pasta selecionada na caixa de diálogo
            JFileChooser jFileChooser = new JFileChooser("c:\\");
            jFileChooser.showOpenDialog(null);
            String pasta = jFileChooser.getCurrentDirectory().getAbsolutePath();
            File folder = new File(pasta);
            if(folder.isDirectory()){
                File[] arquivos = folder.listFiles();
                for(File file : arquivos)
                    System.out.println(file.getName());
        }
    }
}
