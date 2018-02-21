import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class CalculatorProvider {


    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"applicationContext-dubbo.xml",
                        "applicationContext-dao.xml",
                        "applicationContext-service.xml",
                        "applicationContext-quartz.xml",
                        "applicationContext-redis.xml"
                });

        context.start();


        System.in.read();
    }


}
