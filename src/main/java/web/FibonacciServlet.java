package web;

import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.Fibonacci;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


@WebServlet("/aplikacja")
public class FibonacciServlet extends HttpServlet {

        private static final Logger LOG = LoggerFactory.getLogger(FibonacciServlet.class);
        private static final String TEMPLATE_NAME = "fibonacci";
        private static final String TEMPLATE_NAME2 = "mess";
        private static final String TEMPLATE_NAME3 = "fibonacciAns";
        private Pattern p = Pattern.compile("^[0-9][0-9]*$");

        @Inject
        TemplateProvider templateProvider;


        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws SecurityException, IOException {

                Map<String, Object> model = new HashMap<>();

                req.setCharacterEncoding("UTF-8");
                resp.setCharacterEncoding("UTF-8");

                Template template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME);

                try {
                        template.process(model, resp.getWriter());
                } catch (TemplateException e) {
                        LOG.error("Error while processing the template: " + e);
                }
        }
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

                Map<String, Object> model = new HashMap<>();
                List<BigDecimal> fibList;
                Template template;
                String fn = req.getParameter("fibonacciNumber");
                if (fn==null || !p.matcher(fn).matches()) {
                        template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME2);
                } else {
                        template = templateProvider.getTemplate(getServletContext(), TEMPLATE_NAME3);
                        fibList = Fibonacci.fibonacciCount(Integer.valueOf(fn));
                        model.put("fibAct", fibList.get(fibList.size()-1));
                        model.put("fibList", fibList);
                        model.put("fn",fibList.size()-1);
                        }
                try {
                        template.process(model, resp.getWriter());
                } catch (TemplateException e) {
                        LOG.error("Error while processing the template: " + e);
                }

        }
}
