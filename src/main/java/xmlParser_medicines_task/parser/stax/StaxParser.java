package xmlParser_medicines_task.parser.stax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xmlParser_medicines_task.entity.Certificate;
import xmlParser_medicines_task.entity.Package;
import xmlParser_medicines_task.entity.Preparation;
import xmlParser_medicines_task.entity.Version;
import xmlParser_medicines_task.xml_tag_name.PreparationTagName;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import static xmlParser_medicines_task.parser.sax.Sax.PATH_MEDICINS;
import static xmlParser_medicines_task.xml_tag_name.PreparationTagName.*;

public class StaxParser {

    private static final Logger LOGGER = LogManager.getLogger(StaxParser.class);
    private List<Preparation> listOfPreparations;
    private Preparation preparation;
    private Version version;
    private Certificate certificate;
    private Package packageOfDrugs;

    private List<Preparation> process(XMLStreamReader reader) {
        LOGGER.info("Stax start parsing file");
        String tagName = null;
        try {
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: //1
                        tagName = reader.getLocalName().trim();
                        switch (tagName) {
                            case MEDICINS:
                                listOfPreparations = new ArrayList<>();
                                break;
                            case PREPARATION:
                                preparation = new Preparation();
                                preparation.setGroup(reader.getAttributeValue(
                                        null, PreparationTagName.GROUP));
                                break;
                            case VERSION:
                                version = new Version();
                                version.setTypeOfVersion(reader.getAttributeValue(
                                        null, PreparationTagName.TYPE_OF_VERSION));
                                preparation.setVersion(version);
                                break;
                            case CERTIFICATE:
                                certificate = new Certificate();
                                version.setCertificate(certificate);
                                break;
                            case PACKAGE:
                                packageOfDrugs = new Package();
                                version.setPackageOfPreparation(packageOfDrugs);
                                break;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS: //4
                        String text = reader.getText().trim();
                        if(text.isEmpty()){
                            break;
                        }
                        switch (tagName) {
                            case NAME:
                                preparation.setName(text);
                                break;
                            case PHARM:
                                preparation.setPharm(text);
                                break;
                            case ANALOG:
                                preparation.setAnalog(text);
                                break;
                            case CERTIFICATE_ID:
                                certificate.setId(Integer.parseInt(text));
                                break;
                            case CERTIFICATE_DATE_START:
                                certificate.setStartDate(text);
                                break;
                            case CERTIFICATE_DATE_FINISH:
                                certificate.setExpireDate(text);
                                break;
                            case REGISTRATION_ORAGANIZATION:
                                certificate.setRegistrationOfOrganization(text);
                                break;
                            case TYPE_OF_PACKAGE:
                                packageOfDrugs.setTypeOfPackage(text);
                                break;
                            case AMOUNT_IN_PACKAGE:
                                packageOfDrugs.setAmountInPackage(Integer.parseInt(text));
                                break;
                            case PACKAGE_PRICE:
                                packageOfDrugs.setPackagePrice(Double.parseDouble(text));
                                break;
                            case DOSAGE:
                                packageOfDrugs.setDosage(text);
                                break;
                            case PERIODICITY:
                                packageOfDrugs.setPeriodicity(text);
                                break;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT: //2
                        tagName = reader.getLocalName();
                        switch (tagName) {
                            case PREPARATION:
                                listOfPreparations.add(preparation);
                        }
                }
            }
        } catch (XMLStreamException e1) {
            e1.printStackTrace();
        }
        return listOfPreparations;
    }
    public void printPreparations() {
        for (Preparation p : listOfPreparations) {
            System.out.println(p);
        }
    }
    public StaxParser() {
    }
    public static void main(String[] args) throws FileNotFoundException {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        StaxParser staxParser = new StaxParser();

        try {
            InputStream input = new FileInputStream(PATH_MEDICINS);
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            List<Preparation> preparations = staxParser.process(reader);
            staxParser.printPreparations();

        } catch (XMLStreamException exception) {
            exception.printStackTrace();
        }
    }





}
