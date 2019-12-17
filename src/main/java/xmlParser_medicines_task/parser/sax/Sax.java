package xmlParser_medicines_task.parser.sax;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import xmlParser_medicines_task.entity.Preparation;

import java.io.IOException;
import java.util.List;

public class Sax {

    private static final Logger LOGGER = LogManager.getLogger(Sax.class);
    public static final String PATH_MEDICINS = "src\\main\\resources\\medicins.xml";

    public static void main(String[] args) throws SAXException, IOException {

        LOGGER.info("Sax start parsing file");

        XMLReader reader = XMLReaderFactory.createXMLReader();
        SaxHandler saxHandler = new SaxHandler();
        reader.setContentHandler(saxHandler);
        reader.parse(PATH_MEDICINS);
        LOGGER.info("Sax finished parsing file");
        List<Preparation> listOfPreparation = saxHandler.getListOfPreparations();
        for (Preparation preparation : listOfPreparation) {
            System.out.println(preparation);
        }
    }



}
