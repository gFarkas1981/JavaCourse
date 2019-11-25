package carrental.xml;


import carrental.model.Car;
import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


public class ToXML {
    
    private List<Car> cars;
    
    public ToXML(List<Car> cars) {
        
        this.cars = cars;
        export(cars);
        
    }

    public void export(List<Car> cars1) throws JAXBException {
        JAXBContext jaxbContext = cars1;
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Marshal the employees list in console
        jaxbMarshaller.marshal(cars, System.out);

        //Marshal the employees list in file
        jaxbMarshaller.marshal(cars, new File("c:/temp/cars.xml"));
    }

}
