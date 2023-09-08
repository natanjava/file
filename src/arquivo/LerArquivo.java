package arquivo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerArquivo {

	public static void main(String[] args) throws FileNotFoundException {

		FileInputStream entradaArquivo = new FileInputStream(
				new File("C:\\workspace-eclipse-web\\arquivo\\src\\arquivo\\texte.csv"));
		try (Scanner lerArquivo = new Scanner(entradaArquivo, "UTF-8")) {

			List<Pessoa> pessoas = new ArrayList<Pessoa>();

			while (lerArquivo.hasNext()) {
				String linha = lerArquivo.nextLine();

				if (linha != null && !linha.isEmpty()) {
					// System.out.println(linha); ao inves de imprimir no console cria uma lista,
					// armazena e imprime no console
					String lerLinha[] = linha.split("\\;");
					Pessoa pessoa = new Pessoa();
					pessoa.setNome(lerLinha[0]);
					pessoa.setIdade(Integer.parseInt(lerLinha[1]));
					pessoa.setEmail(lerLinha[2]);
					pessoas.add(pessoa);
				}
			}

			for (Pessoa pessoa : pessoas) {  // poderia gravar no banco de daados ou importar, ou fazer qualquer outra função;
				System.out.println(pessoa);
			}

		}

	}
}
