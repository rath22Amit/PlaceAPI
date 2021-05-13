package Resources;

import pojoClass.POJO_AddPlace;
import pojoClass.POJO_Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public POJO_AddPlace addPlacePayload(String name,String address, String language){
        POJO_AddPlace p =new POJO_AddPlace();
        p.setAccuracy(50);
        p.setAddress(address);
        p.setLanguage(language);
        p.setPhone_number("(+91) 983 893 3937");
        p.setWebsite("https://rahulshettyacademy.com");
        p.setName(name);
        List<String> myList =new ArrayList<String>();
        myList.add("shoe park");
        myList.add("shop");

        p.setTypes(myList);
        POJO_Location l =new POJO_Location();
        l.setLat(-38.383494);
        l.setLng(33.427362);

        p.setLocation(l);

        return p;
    }
}
