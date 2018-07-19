import java.util.*;
import java.io.*;
import com.google.gson.Gson;

public class Data{
	public Data(){}
		public static ArrayList<String> usernames = new ArrayList<String>();
		public static ArrayList<Channel> channels = new ArrayList<Channel>();
		public static ArrayList<String> messages = new ArrayList<String>();
	public boolean checkChannel(String u){
		for(int i = 0; i < channels.size(); ++i){
			if(usernames.get(i).equals(u)){
				return true;
			}
		}
		return false;
	}
	public static void addUser(String u){
		usernames.add(u);
		toJSON(1, "usernames.json");
	}
	public static void addChannel(String c){
		Channel ch =  new Channel(c);
		channels.add(ch);
		toJSON(2, "channels.json");
	}
	public static void addMessage(String c, String m){
		messages.add(m);
		toJSON(3, "messages.json");
	}
	public static void toJSON(int i, String out){
		Gson g = new Gson();
		String jstr = "";
		switch(i){
			case 1:
				jstr = g.toJson(usernames);
				break;
			case 2:
				jstr = g.toJson(channels);
				break;
			case 3:
				jstr = g.toJson(messages);
				break;
		}
		try{
			FileWriter writer = new FileWriter(out);
			writer.write(jstr);
			writer.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String printMessages(){
		String ret = "";
		try{
			FileReader reader = new FileReader("messages.json");
			List<String> list = Arrays.asList(new Gson().fromJson(reader, String[].class));
			for(int i = list.size()-1; i >= 0; --i){
				ret = ret + list.get(i) + "<br>";
			}
			reader.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}
}
