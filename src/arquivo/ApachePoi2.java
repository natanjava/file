package arquivo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/*Cria um arquivo xls usando Biblioteca Apache POI*/

public class ApachePoi2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File file = new File("C:\\workspace-eclipse-web\\arquivo\\src\\arquivo\\teste_excel.xls");

		if (!file.exists()) {
			file.createNewFile();
		}

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
		
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); // usado para criar a planilha
		HSSFSheet linhasPessoa = hssfWorkbook.createSheet("Planilha de pessoas - Java");
		
		int numeroLinha = 0;
		for (Pessoa p : pessoas) {
			 Row linha = linhasPessoa.createRow(numeroLinha++); // cria a linha na planilha
			 int celula = 0; // celula(coluna) para cada atributo
			 
			 Cell cellNome = linha.createCell(celula++ );  /*cria celula 1*/
			 cellNome.setCellValue(p.getNome());
			 
			 Cell cellIdade = linha.createCell(celula++ ); /*cria celula 2*/
			 cellIdade.setCellValue(p.getIdade());
			 
			 Cell cellEmail = linha.createCell(celula++ ); /*cria celula 3*/
			 cellEmail.setCellValue(p.getEmail());			 
		
		} /*Terminou de montar a planilha*/
		
		FileOutputStream saida = new FileOutputStream(file);
		hssfWorkbook.write(saida);  /* Escreve a planilha em arquivo*/
		saida.flush();
		saida.close();
		
		System.out.println("Planilha criada com sucesso.");

	}

}
