package arquivo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**edita celulas ja existentes em um arquivo excel */
public class ApachePoiEditando2 {

	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		File file = new File("C:\\workspace-eclipse-web\\arquivo\\src\\arquivo\\teste_excel.xls");
		FileInputStream entrada = new FileInputStream(file);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); // prepara a entrada do arquivo excel
		HSSFSheet planilha = hssfWorkbook.getSheetAt(0); // pega a planilha
		Iterator<Row> linhaIterator = planilha.iterator();
		
		while (linhaIterator.hasNext()) {   // enquanto tiver linha
			Row linha = linhaIterator.next();   // dados da pessoa na linha
			String valorCelula = linha.getCell(0).getStringCellValue();
			linha.getCell(0).setCellValue((valorCelula + " XX"));
		}
		entrada.close();
		
		FileOutputStream saida = new FileOutputStream(file); 
		hssfWorkbook.write(saida);
		saida.flush();
		saida.close();
		
		System.out.println("Planilha atualizada");
	}

}
