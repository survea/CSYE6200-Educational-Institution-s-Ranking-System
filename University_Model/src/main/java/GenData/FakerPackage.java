/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GenData;
import com.github.javafaker.Faker;
import java.util.Random;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/**
 *
 * @author jaspr
 */
public class FakerPackage {
    
    String[] universitiynames = {
            "Northeastern University",
            "BOSTON University",
    };
    

    Faker faker = new Faker();

    public void demo(){
        String streetname = faker.address().state();
        System.out.println(streetname);
    }
    
    public JSONObject getUniversities() {
        JSONObject univs = new JSONObject();
        Random rand = new Random();
        String univnames = universitiynames[rand.nextInt(universitiynames.length)];
        univs.put("univnames",universitiynames);
        System.out.println(univs);
        return univs;
    }



}
