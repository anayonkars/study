package code.demoutils.FTL;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

/**
 * Created by anayonkar on 17/1/16.
 */
public class FreemarkerDemo {

    public static void main(String[] args) throws IOException, TemplateException {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        URL[] urls = ((URLClassLoader)cl).getURLs();
        System.out.println("classpath is : ");
        for(URL url : urls) {
            System.out.println(url.getFile());
        }
        @SuppressWarnings("UnusedAssignment") FreemarkerDemo fd = new FreemarkerDemo();
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        //cfg.setClassForTemplateLoading(FreemarkerDemo.class, "FTL");
        //ClassTemplateLoader ctl = new ClassTemplateLoader(FreemarkerDemo.class, "template");
        //cfg.setTemplateLoader(ctl);
        cfg.setClassLoaderForTemplateLoading(FreemarkerDemo.class.getClassLoader(), "/");
        //cfg.setClassForTemplateLoading(FreemarkerDemo.class, "template");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        Map<String, Object> input = new HashMap<>();
        input.put("title", "FTL Example");
        input.put("exampleObject", new ValueExample("FTL Demo", "Anayonkar"));
        List<ValueExample> systems = new ArrayList<>();
        systems.add(new ValueExample("Android", "Google"));
        systems.add(new ValueExample("iOS States", "Apple"));
        systems.add(new ValueExample("Ubuntu", "Canonical"));
        systems.add(new ValueExample("Windows7", "Microsoft"));
        input.put("systems", systems);
        Template template = cfg.getTemplate("templates/helloworld.ftl");
        //System.out.println("Done");
        //TODO: http://www.vogella.com/tutorials/FreeMarker/article.html
        System.out.println("\n\nWriting to console:");
        Writer consoleWriter = new OutputStreamWriter(System.out);
        template.process(input, consoleWriter);
        System.out.println("\n\nWriting to String:");
        Writer stringWriter = new StringWriter();
        template.process(input, stringWriter);
        System.out.println(stringWriter);
    }
}
