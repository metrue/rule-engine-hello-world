package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

public class Aviator {
    static int count = 10000;

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
    }

    public static void aviatarRun(String exp, Map<String, Object> env) throws Exception {
        long start = System.currentTimeMillis();
        Object result = null;
        for (int i = 0; i < count; i++) {
            Expression expression = AviatorEvaluator.compile(exp);
            result = expression.execute(env);
        }
        System.out.println("aviator time usage: " + ((System.currentTimeMillis() - start) * 1.0));
        System.out.println("=====================");
        System.out.println("result is: " + result);
        System.out.println("=====================");
    }
}

