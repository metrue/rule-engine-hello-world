package demo;

import demo.model.PaymentMethod;
import demo.model.PaymentMethodCriterial;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieContainerSessionsPool;
import org.kie.api.runtime.KieSession;

public class AppSessionPool {

    public static final void main(String[] args) {
        try {
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieContainerSessionsPool pool = kContainer.newKieSessionsPool(10);

            long start = System.currentTimeMillis();
            int count = 10000;
            for (int i = 0; i < count; i++) {
                KieSession kSession = pool.newKieSession("ksession-rules");

                PaymentMethodCriterial criterial = new PaymentMethodCriterial("cn", "USD", "PAYPAL",
                    new String[]{"id-1"}, true);
                PaymentMethod paypal = new PaymentMethod("PayPal", true);
                PaymentMethod applepay = new PaymentMethod("ApplePay", false);

                // insert facts into working memory
                kSession.insert(criterial);
                kSession.insert(applepay);
                kSession.insert(paypal);
                // System.out.println("************* Before Filter **************");
                // System.out.println(applepay);
                // System.out.println(paypal);
                // System.out.println("************* After Filter **************");

                // apply rules
                kSession.fireAllRules();
                // System.out.println(applepay);
                // System.out.println(paypal);
                // System.out.println("************************************\n");
                kSession.dispose();
            }
            pool.shutdown();
            System.out.println("time usage: " + (System.currentTimeMillis() - start) * 1.0 + " ms");
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}

