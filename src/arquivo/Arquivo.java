package arquivo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Arquivo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("nome-1");
		pessoa1.setIdade(34);
		pessoa1.setEmail("email-1");
				
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setNome("nome-2");
		pessoa2.setIdade(39);
		pessoa2.setEmail("email-2");
		
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setNome("nome-3");
		pessoa3.setIdade(69);
		pessoa3.setEmail("email-3");
		
		// pode vir de qualquer fonte de dados, p.ex: um banco de dados
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);			
		
		File arquivo = new File("C:\\workspace-eclipse-web\\arquivo\\src\\arquivo\\texte.csv"); // se quiser um csv so mudar a extensão
		if (!arquivo.exists()) {
			arquivo.createNewFile();
		}
		
		FileWriter escrever_no_arquivo = new FileWriter(arquivo);		
		/*
		for (int i=1; i<=10; i++) {
			escrever_no_arquivo.write("Texto na linha "+i+"\n");
		}*/
		
		for (Pessoa p : pessoas) {
			escrever_no_arquivo.write(p.getNome() + ";" +p.getIdade() + ";" +p.getEmail() + "\n");
		}
		
		
		
		escrever_no_arquivo.flush();
		escrever_no_arquivo.close();

	}

}
