package code.demoutils.FTL;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.*;

/**
 * Created by anayonkar on 22/1/16.
 */
public class FTLTest {
    @Test
    public void testFTL() throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        cfg.setClassLoaderForTemplateLoading(FreemarkerDemo.class.getClassLoader(), "/");
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
        System.out.println("\n\nWriting to console:");
        Writer consoleWriter = new OutputStreamWriter(System.out);
        template.process(input, consoleWriter);
        System.out.println("\n\nWriting to String:");
        Writer stringWriter = new StringWriter();
        template.process(input, stringWriter);
        System.out.println(stringWriter);
        Assert.assertTrue(stringWriter.toString().contains("FTL Demo"));
    }
}
