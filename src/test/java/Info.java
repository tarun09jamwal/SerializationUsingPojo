import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Info {

    public static void main(String[] args) throws FileNotFoundException {

        File input = new File(System.getProperty("user.dir") + "/src/test/java/Info.json");

        JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
        JsonObject fileObject = fileElement.getAsJsonObject();

        String firstname = fileObject.get("firstname").getAsString();
        String lastname = fileObject.get("lastname").getAsString();
        String city = fileObject.get("city").getAsString();
        String state = fileObject.get("state").getAsString();
        int pincode = fileObject.get("pincode").getAsInt();

        System.out.println("First name is :- " + firstname);
        System.out.println("Last name is :- " + lastname);
        System.out.println("Name of my city is :- " + city);
        System.out.println("My state is :- " + state);
        System.out.println("Pincode of city is :- " + pincode);

        JsonArray jsonArrayOfPojo = fileObject.get("friends").getAsJsonArray();
        List<Pojo_Class> myFriends = new ArrayList();
        for (JsonElement pojoElement : jsonArrayOfPojo.getAsJsonArray()) {
            JsonObject pojoJsonObject = pojoElement.getAsJsonObject();
            String name = pojoJsonObject.get("name").getAsString();
            int age = pojoJsonObject.get("age").getAsInt();
            Pojo_Class info = new Pojo_Class(name, age);
            myFriends.add(info);
        }
        System.out.println("All my friends are " + myFriends);
    }
}
