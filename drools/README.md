### Drools Hello World

```
mvn compile exec:java -Dexec.mainClass=demo.App
```

```
************* Before Filter **************
PaymentMethod(name=ApplePay, disabled=false)
PaymentMethod(name=PayPal, disabled=true)
************* After Filter **************
time usage: 33.0 ms
PaymentMethod(name=ApplePay, disabled=false)
PaymentMethod(name=PayPal, disabled=false)
************************************
```
