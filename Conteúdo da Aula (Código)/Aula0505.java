import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.RandomAccess;

public class Aula0505 { // no final da linha é o código 10 da tabela ascii
//    public static void main(String[] args) { //throws Exception
//        RandomAccessFile arq;
//        String info;
//
//        try{
//            arq = new RandomAccessFile("E:\\Ferramentas Computacionais I\\Projetos-Java-main\\arquivo.txt", "r"); // quando abre um arquivo, o ponteiro está antes do primeiro caractere
////            info = arq.readByte(); // não pode ler um char em arquivo texto, então não usar readChar()
////            System.out.print((char)info);
////            info = arq.readByte();
////            System.out.print((char)info);
//
//            // leitura de caractere por caractere do arquivo até o final (byte por byte)
//            System.out.println("\nO arquivo tem "+arq.length()+" bytes"); // tamanho do arquivo
////            while (arq.getFilePointer() < arq.length()){
////                info = arq.readByte();
////                System.out.print((char)info);
////            }
//
//            // leitura da linha inteira do arquivo até o final dele
//            while (arq.getFilePointer() < arq.length()){
//                info = arq.readLine();
//                //if(info.toUpperCase().contains("WINDOWS");
//                System.out.println(info);
//            }
//
//            // leitura
//
//            arq.close();
//
//        }
//        catch (Exception e){
//            System.out.println("Erro ao abrir o arquivo: "+e.getMessage());
//        }
//
//        System.out.println("\nHello, Word!");
//    }

// leitura total do arquivo
public static void main(String[] args) {
    RandomAccessFile arq, arq2;
    byte[] info;

    try{
        arq = new RandomAccessFile("arquivo.txt", "r"); // quando abre um arquivo, o ponteiro está antes do primeiro caractere
        arq2 = new RandomAccessFile("arquivo2.txt", "rw");

            info = new byte[(int) arq.length()]; // não pode ler um char em arquivo texto, então não usar readChar()
            arq.readFully(info);
            String string = new String(info); // única forma de imprimir o vetor de string
            arq2.writeBytes(string.toUpperCase());

            arq.close();
            arq2.close();

    }
    catch (Exception e){
        System.out.println("\nErro ao abrir o arquivo: "+e.getMessage());
    }

    System.out.println("\nHello, Word!");
}
}
