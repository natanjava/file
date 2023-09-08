package arquivo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**adiciona colunas em arquivo excel que ja existe */
public class ApachePoiEditando {

	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		File file = new File("C:\\workspace-eclipse-web\\arquivo\\src\\arquivo\\teste_excel.xls");
		FileInputStream entrada = new FileInputStream(file);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); // prepara a entrada do arquivo excel
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0); // pega a planilha
		Iterator<Row> linhaIterator = planilha.iterator();
		
		while (linhaIterator.hasNext()) {   // enquanto tiver linha
			Row linha = linhaIterator.next();   // dados da pessoa na linha
			int numeroCelulas = linha.getPhysicalNumberOfCells();  // quantidade de celulas
			Cell cell = linha.createCell(numeroCelulas);  // cria um novo campo
			cell.setCellValue("3.500,30"); /** faz esse campo receber um numero, por exemplo salário, todos tem o mesmo salário; 
			 								poderia consultar o salario no banco e gravar na planilha e evniar pra algum email **/
		}
		entrada.close();
		
		FileOutputStream saida = new FileOutputStream(file); 
		hssfWorkbook.write(saida);
		saida.flush();
		saida.close();
		
		System.out.println("Planilha atualizada");
	}

}
