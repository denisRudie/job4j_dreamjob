package ru.job4j.dream.servlet;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.dream.Serializer.CustomCandidateSerializer;
import ru.job4j.dream.model.CandidateJson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(JsonServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("json.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String pwd = req.getParameter("password");

        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module =
                new SimpleModule("CustomCandidateSerializer", new Version(1, 0, 0, null, null,
                        null));
        module.addSerializer(CandidateJson.class, new CustomCandidateSerializer());
        mapper.registerModule(module);
        CandidateJson candidate = new CandidateJson(firstName, lastName, pwd);
        String candJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(candidate);

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.println(candJson);
        writer.flush();
    }
}
