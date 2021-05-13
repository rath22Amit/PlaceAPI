package Resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {
    public static RequestSpecification req;

    public RequestSpecification requestSpec() throws IOException {
        if(req==null){
        PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));
         req=new RequestSpecBuilder().setBaseUri(getGloablValue())
                .addQueryParam("key","qaclick123")
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON).build();
        return req;
        }
        return req;
    }

    public static String getGloablValue() throws IOException {
        Properties prop= new Properties();
        FileInputStream fis= new FileInputStream("D:\\MyGitWorld\\RestAssuredBDD\\src\\test\\java\\Resources\\global.properties");
        prop.load(fis);
        return prop.getProperty("baseURL");

    }
}
