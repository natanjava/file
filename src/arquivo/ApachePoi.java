package arquivo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/*Ler um arquivo xls usando Biblioteca Apache POI e envia dados para uma lista de objetos e ler no consol */

public class ApachePoi {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream entrada = new FileInputStream(
				new File("C:\\workspace-eclipse-web\\arquivo\\src\\arquivo\\teste_excel.xls"));
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); /* prepara a entrada do arquivo excel para ler */
		HSSFSheet planilha = hssfWorkbook
				.getSheetAt(0); /*
								 * Um arquivo excel pode ter varias planilhas, nesse caso vai ppegar a primeira
								 */

		Iterator<Row> linhaIterator = planilha.iterator();
		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		while (linhaIterator.hasNext()) { /* Enquanto tiver linha no arquivo do excel */
			Row linha = linhaIterator.next(); /* dados da pessoa na linha */
			Iterator<Cell> celula = linha.iterator();

			Pessoa pessoa = new Pessoa(); /* enquanto percorre as celulas, cada linha é uma pessoa */

			while (celula.hasNext()) {
				Cell cell = celula.next();

				switch (cell.getColumnIndex()) {
				case 0:
					pessoa.setNome(cell.getStringCellValue());
					break;
				case 1:
					pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
					break;
				case 2:
					pessoa.setEmail(cell.getStringCellValue());
					break;
				}

			} /* fim das celulas da linha, passa para outra linha, cria nov objeto */
			pessoas.add(pessoa);
		}
		entrada.close(); /* terminou de ler o arquivo*/

		/* Escreve em tela as informacoes vindas do arquivo	, poderia enviar para um Banco de Dados*/
		for (Pessoa p : pessoas) {
			System.out.println(p);
		}

	}

}
