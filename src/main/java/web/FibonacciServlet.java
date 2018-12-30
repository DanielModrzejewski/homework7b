package web;

import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/application")
public class FibonacciServlet extends HttpServlet {

        private static final Logger LOG = LoggerFactory.getLogger(FibonacciServlet.class);
        private static final String TEMPLATE_NAME = "fibonacci";

        @Inject
        TemplateProvider templateProvider;

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws SecurityException, IOException {

                Map<String, Object> model = new HashMap<>();
                model.put("member1", "Bartosz Wiśniewski");
                model.put("member2", "Daniel Modrzejewski");
                model.put("member3", "Przemek Grabski");
                model.put("member4", "Waldek Wódczak");

                req.setCharacterEncoding("UTF-8");
                resp.setCharacterEncoding("UTF-8");

                Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

                try {
                        template.process(model, resp.getWriter());
                } catch (TemplateException e) {
                        LOG.error("Error while processing the template: " + e);
                }
        }
}
