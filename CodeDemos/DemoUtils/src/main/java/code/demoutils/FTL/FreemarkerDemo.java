package code.demoutils.FTL;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.IOException;
import java.util.*;

/**
 * Created by anayonkar on 17/1/16.
 */
public class FreemarkerDemo {

    public static void main(String[] args) throws IOException {
        FreemarkerDemo fd = new FreemarkerDemo();
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        //cfg.setClassForTemplateLoading(FreemarkerDemo.class, "FTL");
        //ClassTemplateLoader ctl = new ClassTemplateLoader(FreemarkerDemo.class, "template");
        //cfg.setTemplateLoader(ctl);
        cfg.setClassLoaderForTemplateLoading(FreemarkerDemo.class.getClassLoader(), "FTL");
        //cfg.setClassForTemplateLoading(FreemarkerDemo.class, "template");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.DEBUG_HANDLER.RETHROW_HANDLER);
        Map<String, Object> input = new HashMap<>();
        input.put("title", "FTL Example");
        input.put("exampleObject", new ValueExample("FTL Demo", "Anayonkar"));
        List<ValueExample> systems = new ArrayList<>();
        systems.add(new ValueExample("Android", "Google"));
        systems.add(new ValueExample("iOS States", "Apple"));
        systems.add(new ValueExample("Ubuntu", "Canonical"));
        systems.add(new ValueExample("Windows7", "Microsoft"));
        input.put("systems", systems);
        //Template template = cfg.getTemplate("helloworld.ftl");
        System.out.println("Done");
        //TODO: http://www.vogella.com/tutorials/FreeMarker/article.html
    }
}
