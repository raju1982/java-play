package rest.assured.prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JAXBtest {

    public static void main(String[] args) throws JAXBException {

        Location location = new Location();
        location.setLat(-33.8669710);
        location.setLng(151.1958750);

        ArrayList<String> types = new ArrayList<String>();
        types.add("shoe_store");

        PlaceAddRequest places = new PlaceAddRequest();
        places.setLocation(location);
        places.setAccuracy(50);
        places.setName("Google Shoes!");
        places.setPhone_number("(02) 9374 4000");
        places.setAddress("48 Pirrama Road, Pyrmont, NSW 2009, Australia");
        places.setTypes(types);
        places.setWebsite("http://www.google.com.au/");
        places.setLanguage("en-AU");

        //File file = new File("C:\\file.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(PlaceAddRequest.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //jaxbMarshaller.marshal(places, file);
        jaxbMarshaller.marshal(places, System.out);

    }
}
