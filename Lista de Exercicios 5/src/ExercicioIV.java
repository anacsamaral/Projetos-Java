import javax.swing.*;
import java.io.*;

public class ExercicioIV {
    public static void main(String[] args) {
        // Escolher o arquivo de entrada (filmes.txt)
        JFileChooser seletorArquivo = new JFileChooser();
        seletorArquivo.setDialogTitle("Selecione o arquivo filmes.txt");
        int resultado = seletorArquivo.showOpenDialog(null);

        if (resultado != JFileChooser.APPROVE_OPTION) {
            System.out.println("Nenhum arquivo selecionado. Encerrando o programa.");
            return;
        }

        File arquivo = seletorArquivo.getSelectedFile();

        // Escolher onde salvar o HTML
        JFileChooser seletorDestino = new JFileChooser();
        seletorDestino.setDialogTitle("Escolha onde salvar o arquivo HTML");
        seletorDestino.setSelectedFile(new File("pagina.html"));
        resultado = seletorDestino.showSaveDialog(null);

        if (resultado != JFileChooser.APPROVE_OPTION) {
            System.out.println("Local de salvamento não selecionado.");
            return;
        }

        File arquivoHtml = seletorDestino.getSelectedFile();

        try (
                BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
                BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoHtml))
        ) {
            escritor.write("<!DOCTYPE html>\n");
            escritor.write("<html lang=\"pt-br\">\n");
            escritor.write("<head>\n");
            escritor.write("<meta charset=\"UTF-8\">\n");
            escritor.write("<title>Top Filmes</title>\n");
            escritor.write("</head>\n");
            escritor.write("<body>\n");

            String linha;
            String decadaAtual = "";
            boolean listaAberta = false;

            while ((linha = leitor.readLine()) != null) {
                linha = linha.trim();
                if (!linha.isEmpty() && linha.contains(";")) {
                    String[] partes = linha.split(";", 2);
                    String parteAno = partes[0].trim();
                    String titulo = partes[1].trim();

                    try {
                        int ano = Integer.parseInt(parteAno);
                        int decadaInicio = (ano / 10) * 10;
                        int decadaFim = decadaInicio + 9;
                        String decada = decadaInicio + "-" + decadaFim;

                        if (!decada.equals(decadaAtual)) {
                            if (listaAberta) {
                                escritor.write("</ul>\n");
                            }
                            escritor.write("<h1>" + decada + "</h1>\n");
                            escritor.write("<ul>\n");
                            decadaAtual = decada;
                            listaAberta = true;
                        }

                        escritor.write("<li>" + titulo + "</li>\n");
                    } catch (NumberFormatException e) {
                        System.err.println("Ano inválido na linha: " + linha);
                    }
                }
            }

            if (listaAberta) {
                escritor.write("</ul>\n");
            }

            escritor.write("</body>\n");
            escritor.write("</html>\n");

            System.out.println("HTML gerado com sucesso em: " + arquivoHtml.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}