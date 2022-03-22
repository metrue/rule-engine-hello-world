package demo;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Groovy {
    static int count = 10000;

    public static void main(String args[]) throws Exception {
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
        String exp = " if (country == \"cn\" && currency == \"USD\" && name == \"PAYPAL\" && exp == true && allowedAsserts.contains(\'id-1\')) {"
            + "return true;"
            + "} else {"
            + "return false;"
            +"}";
        groovyRun(exp, env);
    }

    public static void groovyRun(String exp, Map<String, Object> env) throws Exception {
        long start = System.currentTimeMillis();
        GroovyClassLoader loader = new GroovyClassLoader(Thread.currentThread().getContextClassLoader());
        Object result = null;
        for (int i = 0; i < count; i++) {
            Class clazz = loader.parseClass(exp);
            GroovyObject groovyObject = (GroovyObject) clazz.newInstance();
            for (Map.Entry<String, Object> entry : env.entrySet()) {
                groovyObject.setProperty(entry.getKey(), entry.getValue());
            }
            result = groovyObject.invokeMethod("run", null);
        }
        System.out.println("groovy time usage: " + (System.currentTimeMillis() - start) * 1.0);
        System.out.println("=====================");
        System.out.println("result is: " + result);
        System.out.println("=====================");
    }
}
