import java.io.*;
class randomico
{
    public static void main(String args[])
    {
        byte info;
        try
        { RandomAccessFile arq;
            arq=new RandomAccessFile("c:\\arquivo.txt","rw");
            System.out.println("Tam arquivo:"+arq.length()+"bytes");
            while(arq.getFilePointer()<arq.length())
            {
                info=arq.readByte();
                System.out.print((char)info);
            }
            arq.close();
        }
        catch(IOException e)
        { System.out.println("Problemas: "+e.toString()); }
    }
}