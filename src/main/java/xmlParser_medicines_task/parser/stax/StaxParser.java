package xmlParser_medicines_task.parser.stax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import xmlParser_medicines_task.entity.Certificate;
import xmlParser_medicines_task.entity.Package;
import xmlParser_medicines_task.entity.Preparation;
import xmlParser_medicines_task.entity.Version;
import xmlParser_medicines_task.xml_tag_name.PreparationTagName;


import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import java.util.ArrayList;
import java.util.List;

import static xmlParser_medicines_task.xml_tag_name.PreparationTagName.MEDICINS;
import static xmlParser_medicines_task.xml_tag_name.PreparationTagName.PREPARATION;

public class StaxParser {

    private static final Logger LOGGER = LogManager.getLogger(StaxParser.class);
    private List<Preparation> listOfPreparations;
    private Preparation preparation;
    private StringBuilder drugsInformation;
    private Version version;
    private Certificate certificate;
    private Package packageOfDrugs;
    private XMLInputFactory inputFactory;


    public List<Preparation> process(XMLStreamReader reader) {
        LOGGER.info("Stax start parsing file");
        PreparationTagName tagName = null;
        try {
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                      tagName = reader.getLocalName()

                }
            }
        } catch (XMLStreamException e1) {
            e1.printStackTrace();
        }
    } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }



    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        drugsInformation = new StringBuilder();
        switch (qName) {
            case PreparationTagName.MEDICINS:
                listOfPreparations = new ArrayList<>();
                break;
            case PREPARATION:
                preparation = new Preparation();
                preparation.setGroup(attributes.getValue(PreparationTagName.GROUP));
                break;
            case PreparationTagName.VERSION:
                version = new Version();
                version.setTypeOfVersion(attributes.getValue(PreparationTagName.TYPE_OF_VERSION));
                preparation.setVersion(version);
                break;
            case PreparationTagName.CERTIFICATE:
                certificate = new Certificate();
                break;
            case PreparationTagName.PACKAGE:
                packageOfDrugs = new Package();
                break;
        }
    }
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case PREPARATION:
                listOfPreparations.add(preparation);
                break;
            case PreparationTagName.NAME:
                preparation.setName(drugsInformation.toString());
                break;
            case PreparationTagName.PHARM:
                preparation.setPharm(drugsInformation.toString());
                break;
            case PreparationTagName.ANALOG:
                preparation.setAnalog(drugsInformation.toString());
                break;
            case PreparationTagName.CERTIFICATE:
                version.setCertificate(certificate);
                break;
            case PreparationTagName.CERTIFICATE_ID:
                certificate.setId(Integer.parseInt(drugsInformation.toString()));
                break;
            case PreparationTagName.CERTIFICATE_DATE_START:
                certificate.setStartDate(drugsInformation.toString());
                break;
            case PreparationTagName.CERTIFICATE_DATE_FINISH:
                certificate.setExpireDate(drugsInformation.toString());
                break;
            case PreparationTagName.REGISTRATION_ORAGANIZATION:
                certificate.setRegistrationOfOrganization(drugsInformation.toString());
                break;
            case PreparationTagName.PACKAGE:
                version.setPackageOfPreparation(packageOfDrugs);
                break;
            case PreparationTagName.TYPE_OF_PACKAGE:
                packageOfDrugs.setTypeOfPackage(drugsInformation.toString());
                break;
            case PreparationTagName.AMOUNT_IN_PACKAGE:
                packageOfDrugs.setAmountInPackage(Integer.parseInt(drugsInformation.toString()));
                break;
            case PreparationTagName.PACKAGE_PRICE:
                packageOfDrugs.setPackagePrice(Double.parseDouble(drugsInformation.toString()));
                break;
            case PreparationTagName.DOSAGE:
                packageOfDrugs.setDosage(drugsInformation.toString());
                break;
            case PreparationTagName.PERIODICITY:
                packageOfDrugs.setPeriodicity(drugsInformation.toString());
                break;
        }

    }

}
