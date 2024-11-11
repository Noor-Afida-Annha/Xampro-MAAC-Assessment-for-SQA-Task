package utilss;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import setup.SetUp;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils extends SetUp {
    public static void saveUsers(String fullname, String email, String phone, String password) throws IOException, ParseException {
        String fileLocation="./src/test/resources/users.json";
        JSONParser parser = new JSONParser();
        JSONArray userArray = (JSONArray) parser.parse(new FileReader(fileLocation));

        JSONObject userObj = new JSONObject();
        userObj.put("fullname",fullname);
        userObj.put("email",email);
        userObj.put("phone",phone);
        userObj.put("password",password);

        userArray.add(userObj);
        FileWriter writer = new FileWriter(fileLocation);
        writer.write(userArray.toJSONString());
        writer.flush();
        writer.close();

    }

    public static JSONArray readJSONData() throws IOException, ParseException {
        String fileLocation = "./src/test/resources/users.json";
        JSONParser parser = new JSONParser();
        JSONArray userArray = (JSONArray) parser.parse(new FileReader(fileLocation));
        return userArray;
    }


    public static int generateRandomId(int min, int max){
        double random=Math.random()*(max-min)+min;
        int randId=(int) random;
        return randId;
    }
}
