package demo;

import demo.model.PaymentMethod;
import demo.model.PaymentMethodCriterial;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class App {
    public static final void main(String[] args) {
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");

            PaymentMethodCriterial criterial = new PaymentMethodCriterial("cn","USD", "PAYPAL", new String[]{"id-1"}, true);
            PaymentMethod paypal = new PaymentMethod("PayPal",true);
            PaymentMethod applepay = new PaymentMethod("ApplePay", false);

            // insert facts into working memory
            kSession.insert(criterial);
            kSession.insert(applepay);
            kSession.insert(paypal);

            System.out.println("************* Before Filter **************");
            System.out.println(applepay);
            System.out.println(paypal);
            System.out.println("************* After Filter **************");
            // apply rules
            long start = System.currentTimeMillis();
            int count = 1;
            for (int i = 0; i < count; i++) {
               kSession.fireAllRules();
            }
            System.out.println("time usage: " + (System.currentTimeMillis() - start) * 1.0/count  + " ms");
            System.out.println(applepay);
            System.out.println(paypal);
            System.out.println("************************************\n");
            kSession.dispose();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
