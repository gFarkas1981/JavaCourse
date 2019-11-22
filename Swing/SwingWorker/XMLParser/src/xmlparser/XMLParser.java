/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlparser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.CD;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Gabor Farkas <info@gfarkas.com>
 */
public class XMLParser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            
            SAXBuilder builder = new SAXBuilder();
            File file = new File("src/resources/cd_catalog.xml");
            Document document = builder.build(file);
            Element root = document.getRootElement();
            
            List<Element> cdElements = root.getChildren();
            
            List<CD> cds = new ArrayList();
            for (Element cdElement : cdElements) {
                
                CD cd = new CD(
                        
                        cdElement.getChild("TITLE").getText(),
                        cdElement.getChild("ARTIST").getText(),
                        cdElement.getChild("COMPANY").getText(),
                        cdElement.getChild("COUNTRY").getText(),
                        Double.valueOf(cdElement.getChild("PRICE").getText()),
                        Integer.valueOf(cdElement.getChild("YEAR").getText()));
                cds.add(cd);
                
            }
            
            for (CD cd : cds) {
                
                System.out.println(cd);
                
            }
            
            
        } catch (JDOMException | IOException ex) {
            
            System.out.println(ex);
            
        }
        
    }
    
}
