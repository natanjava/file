package arquivo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

/** ---> grava dados de objetos em uma lista e depois em um arquivo JSON
 *  ---> le o arquivo JSON
 *  Util para fazer integração de sistemas, exportação de dados **/
public class EscreveJSON {

	public static void main(String[] args) throws IOException {
		
		Usuario usuario1 = new Usuario();
		usuario1.setCpf("0983423");
		usuario1.setLogin("joão");
		usuario1.setSenha("2341");
		usuario1.setNome("Alex fernando");
		
		Usuario usuario2 = new Usuario();
		usuario2.setCpf("7636363");
		usuario2.setLogin("pedro");
		usuario2.setSenha("vvasd");
		usuario2.setNome("Pedro Luis");
		
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonUser = gson.toJson(usuarios); // ao inves de criar o JSON direto cria o GSON builder
  		
		
		System.out.println(jsonUser);
		
		FileWriter fileWriter = new FileWriter("C:\\workspace-eclipse-web\\arquivo\\src\\arquivo\\file_json.json"); 
		fileWriter.write(jsonUser);
		fileWriter.flush();
		fileWriter.close();
				
		
		
		 /*-------------------- Le Arquivo JSON ---------------------*/
		
		FileReader fileReader = new FileReader("C:\\workspace-eclipse-web\\arquivo\\src\\arquivo\\file_json.json");
		//JsonArray jasonArray = Jason
		JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);		
		List<Usuario> listUsuarios = new ArrayList<Usuario>();
		for (JsonElement jsonElement : jsonArray) {
			Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
			listUsuarios.add(usuario);			
		}
		
		System.out.println("Leitura do arquivo JSON :" );		
		for (Usuario u : listUsuarios) {
			System.out.println(u);
		}
		
	}

}
