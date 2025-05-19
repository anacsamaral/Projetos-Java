import java.io.RandomAccessFile;
import java.util.Arrays;

public class Main {
    // leitura total do arquivo
    public static void main(String[] args) {
        RandomAccessFile arq,arq2;
        byte[] info;
        try {
            arq = new RandomAccessFile("C:\\Users\\anaca\\OneDrive - unoeste.edu.br\\3º Semestre\\2º Bimestre\\Ferramentas Computacionais I\\Conteúdo da Aula (Código)\\arquivo.txt", "r");
            arq2= new RandomAccessFile("novo.txt","rw");
            info=new byte[(int)arq.length()];
            arq.readFully(info);
            String string=new String(info);
            arq2.writeBytes(string.toUpperCase());
            arq.close();
            arq2.close();
        }catch (Exception e){
            System.out.println("Erro ao abrir o arquivo: "+e.getMessage());
        }
    }

    // leitura linha a linha
//    public static void main(String[] args) {
//        RandomAccessFile arq;
//        String info;
//        try {
//            arq = new RandomAccessFile("C:\\Python\\Python311\\news.txt", "r");
//            while(arq.getFilePointer() < arq.length()) {
//                info = arq.readLine();
//                //if(info.toUpperCase().contains("WINDOWS"))
//                System.out.println(info);
//            }
//            arq.close();
//        }catch (Exception e){
//            System.out.println("Erro ao abrir o arquivo: "+e.getMessage());
//        }
//    }
    // leitura byte a byte
//    public static void main(String[] args) {
//        RandomAccessFile arq;
//        byte info;
//        try {
//            arq = new RandomAccessFile("C:\\Python\\Python311\\news.txt", "r");
//            System.out.println("O arquivo tem "+arq.length()/1024./1024+" Mbytes");
//            while(arq.getFilePointer() < arq.length()) {
//                info = arq.readByte();
//                System.out.print((char) info);
//            }
//            arq.close();
//        }catch (Exception e){
//            System.out.println("Erro ao abrir o arquivo: "+e.getMessage());
//        }
//    }
}