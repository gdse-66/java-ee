package lk.ijse.gdse66.json.api;

import jakarta.json.*;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name="JsonProcessServlet", urlPatterns = "/jsonp")
public class JsonProcessServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* ----------------------- Read JSON--------------------*/
        /*{
            "id":"C001",
            "name":"Kasun Sampath",
            "address":{
                "no":17,
                "street":"main street",
                "city":"Galle"
            },
            "contacts":["011-1234567", "022-7654321"]
        }*/
        /* without json libraries */
        /*BufferedReader reader = req.getReader();
        String line;
        String json = "";
        while((line = reader.readLine()) != null ){
            json += line + "\n";
        }
        System.out.println(json);*/

        /* using JSON-P library */
        /*JsonReader reader = Json.createReader(req.getReader());
        JsonObject jsonObject = reader.readObject();
        System.out.println(jsonObject);

        String id = jsonObject.getString("id");
        String name = jsonObject.getString("name");
        JsonObject addressJsonObject = jsonObject.getJsonObject("address");

        int no = addressJsonObject.getInt("no");
        String street = addressJsonObject.getString("street");
        String city = addressJsonObject.getString("city");

        JsonArray contactsJsonArray = jsonObject.getJsonArray("contacts");
        String firstContact = contactsJsonArray.getString(0);
        String secondContact = contactsJsonArray.getString(1);


        System.out.println("id: "+ id);
        System.out.println("name: "+ name);
        System.out.println("address: "+ addressJsonObject);
        System.out.println("contacts: "+ contactsJsonArray);

        System.out.println("no: " + no);
        System.out.println("street: " + street);
        System.out.println("city: " + city);

        System.out.println("first contact: " + firstContact);
        System.out.println("second contact: " + secondContact);*/


        /* ----------------------- Write JSON--------------------*/

        /* without json libraries */
        /*resp.getWriter().write("{\n" +
                "    \"id\":\"C001\",\n" +
                "    \"name\":\"Kasun Sampath\",\n" +
                "    \"address\":{\n" +
                "        \"no\":17,\n" +
                "        \"street\":\"main street\",\n" +
                "        \"city\":\"Galle\"\n" +
                "    },\n" +
                "    \"contacts\":[\"011-1234567\", \"022-7654321\"]\n" +
                "}");*/

        /* using JSON-P library */

        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();

        objectBuilder.add("id", "C001");
        objectBuilder.add("name", "Kasun");

        JsonObjectBuilder addressObjBuilder = Json.createObjectBuilder();
        addressObjBuilder.add("no",10);
        addressObjBuilder.add("street","main street");
        addressObjBuilder.add("city","Galle");

        objectBuilder.add("address",addressObjBuilder);

        JsonArrayBuilder contactArrayBuilder = Json.createArrayBuilder();
        contactArrayBuilder.add("011-1234567");
        contactArrayBuilder.add("022-1234567");

        objectBuilder.add("contacts",contactArrayBuilder);

        JsonObject jsonObject = objectBuilder.build();

        resp.getWriter().write(jsonObject.toString());

        /*JsonObject jsonObject = Json.createObjectBuilder()
                .add("id", "C001")
                .add("name", "Kasun")
                .add("address", "Galle").build();

        resp.getWriter().write(jsonObject.toString());*/
    }
}
