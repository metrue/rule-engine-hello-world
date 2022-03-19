import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;


public class App {
    static int count = 1;

    public static void main(String args[]) throws Exception {
        // AviatorEvaluator.setOptimize(AviatorEvaluator.COMPILE);
        // AviatorEvaluator.setTrace(true);
        // AviatorEvaluator.setTraceOutputStream(new FileOutputStream(new
        // File("aviator.log")));
        String exp = " if country == \"cn\" && currency == \"USD\" && name == \"PAYPAL\" && exp == true && include(allowedAsserts, \"id-1\") {"
            + "return true;"
            + "} else {"
            + "return false;"
            +"}";
        Map<String, Object> env = new HashMap<String, Object>(){
            {
                put("country", "cn");
                put("currency", "USD");
                put("name", "PAYPAL");
                put("exp", true);
                put("allowedAsserts", new ArrayList<String>() {
                    {
                        add("id-1");
                    }
                });
            }
        };
        aviatarRun(exp, env);
        exp = " if (country == \"cn\" && currency == \"USD\" && name == \"PAYPAL\" && exp == true && allowedAsserts.contains(\'id-1\')) {"
            + "return true;"
            + "} else {"
            + "return false;"
            +"}";
        groovyRun(exp, env);
    }

    public static void aviatarRun(String exp, Map<String, Object> env) throws Exception {
        Expression expression = AviatorEvaluator.compile(exp);
        long start = System.currentTimeMillis();
        Object result = null;
        for (int i = 0; i < count; i++) {
            result = expression.execute(env);
        }
        System.out.println("aviator time usage: " + ((System.currentTimeMillis() - start) * 1.0));
        System.out.println("=====================");
        System.out.println("result is: " + result);
        System.out.println("=====================");
    }

    public static void groovyRun(String exp, Map<String, Object> env) throws Exception {
        GroovyClassLoader loader = new GroovyClassLoader(Thread.currentThread().getContextClassLoader());
        Class clazz = loader.parseClass(exp);
        GroovyObject groovyObject = (GroovyObject) clazz.newInstance();

        for (Map.Entry<String, Object> entry : env.entrySet()) {
            groovyObject.setProperty(entry.getKey(), entry.getValue());
        }
        long start = System.currentTimeMillis();
        Object result = null;
        for (int i = 0; i < count; i++) {
            result = groovyObject.invokeMethod("run", null);
        }
        System.out.println("groovy time usage: " + (System.currentTimeMillis() - start) * 1.0);
        System.out.println("=====================");
        System.out.println("result is: " + result);
        System.out.println("=====================");
    }
}
