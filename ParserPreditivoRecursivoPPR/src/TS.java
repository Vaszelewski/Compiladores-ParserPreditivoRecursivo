import java.lang.reflect.Field;
import java.util.HashMap;

public class TS {
	//String - the type of keys maintained by this map
	//Token - the type of mapped values
	HashMap<String, Token> ts;
	
	public TS() {
		ts = new HashMap<>();
	}
	
	//Operacao Insert -> put()
	//Operacao Lookup -> get()
	
	public void setAtributo(String chave, String atributo, String valor) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Token t = ts.get(chave);
		Field f = t.getClass().getDeclaredField(atributo);
		f.set(t, valor);
	}
	
	public String getAtributo(String chave, String atributo) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Token t = ts.get(chave);
		Field f = t.getClass().getDeclaredField(atributo);
		return (String) f.get(t);
	}
	
	

}
