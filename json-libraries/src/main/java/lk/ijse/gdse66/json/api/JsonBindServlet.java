package lk.ijse.gdse66.json.api;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import lk.ijse.gdse66.json.model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "JsonBindServlet", urlPatterns = "/jsonb")
public class JsonBindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            /* ================= java object ---> JSON ================== */
        /*Student s1 = new Student("S001", "Kasun Sampath", 18);
        Student s2 = new Student("S002", "Amal Perera", 20);

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);

        Jsonb jsonb = JsonbBuilder.create();

//        String json = jsonb.toJson(s1);
//        response.getWriter().write(json);

//        String json = jsonb.toJson(studentList);
//        response.getWriter().write(json);

        jsonb.toJson(studentList,response.getWriter());*/

        /* =====================JSON ---> java object ==================== */

        Jsonb jsonb = JsonbBuilder.create();
        /*Student student = jsonb.fromJson(request.getReader(), Student.class);
        System.out.println(student);*/

        ArrayList<Student> studentList = jsonb.fromJson(request.getReader(),
                new ArrayList<Student>() {}.getClass().getGenericSuperclass());
        System.out.println(studentList);


    }
}
