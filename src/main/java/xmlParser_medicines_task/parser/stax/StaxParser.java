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
    private Preparation.Builder builderPreparation;
    private Version.Builder builderOfVersion;
    private Certificate.Builder builderOfCertificate;
    private Package.Builder builderOfPackage;

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
                                builderPreparation= new Preparation.Builder();
                                builderPreparation.withGroup(reader.getAttributeValue(
                                        null,PreparationTagName.GROUP));
                                break;
                            case VERSION:
                                builderOfVersion = new Version.Builder();
                                builderOfVersion.withTypeOfVersion(reader.getAttributeValue(
                                        null,PreparationTagName.TYPE_OF_VERSION));
                                break;
                            case CERTIFICATE:
                                builderOfCertificate = new Certificate.Builder();
                                break;
                            case PACKAGE:
                                builderOfPackage = new Package.Builder();
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
                                builderPreparation.withName(text);
                                break;
                            case PHARM:
                                builderPreparation.withPharm(text);
                                break;
                            case ANALOG:
                                builderPreparation.withAnalog(text);
                                break;
                            case CERTIFICATE_ID:
                                builderOfCertificate.withId(Integer.parseInt(text));
                                break;
                            case CERTIFICATE_DATE_START:
                                builderOfCertificate.withStartDate(text);
                                break;
                            case CERTIFICATE_DATE_FINISH:
                                builderOfCertificate.withExpireDate(text);
                                break;
                            case REGISTRATION_ORAGANIZATION:
                                builderOfCertificate.witRegistrationOrganization(text);
                                builderOfVersion.withCertificate(builderOfCertificate.build());
                                break;
                            case TYPE_OF_PACKAGE:
                                builderOfPackage.withTypeOfPackage(text);
                                break;
                            case AMOUNT_IN_PACKAGE:
                                builderOfPackage.withAmountInPackage(Integer.parseInt(text));
                                break;
                            case PACKAGE_PRICE:
                                builderOfPackage.withPackagePrice(Double.parseDouble(text));
                                break;
                            case DOSAGE:
                                builderOfPackage.withDosage(text);
                                break;
                            case PERIODICITY:
                                builderOfPackage.withPeriodicity(text);
                                builderOfVersion.withPackage(builderOfPackage.build());
                                break;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT: //2
                        tagName = reader.getLocalName();
                        switch (tagName) {
                            case PREPARATION:
                                listOfPreparations.add(builderPreparation.build());
                            case VERSION:
                                builderPreparation.withVersion(builderOfVersion.build());
                                break;
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
