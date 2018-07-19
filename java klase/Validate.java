import java.io.*;
import java.util.*;
import com.google.gson.Gson;
public class Validate{
	public static boolean checkUser(String u){
		boolean ret = true;
		for(int i = 0; i < Data.usernames.size(); ++i){
				if(u.equals(Data.usernames.get(i))){
					ret = false;
					break;
				}
			}
		/*try{
			FileReader reader = new FileReader("usernames.json");
			BufferedReader br = new BufferedReader(reader);
			if( br.readLine() == null) return true;
			List<String> list = Arrays.asList(new Gson().fromJson(reader, String[].class));
			for(int i = 0; i < list.size(); ++i){
				if(u.equals(list.get(i))){
					ret = false;
					break;
				}
			}
			reader.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}*/
		return ret;
	}
}
