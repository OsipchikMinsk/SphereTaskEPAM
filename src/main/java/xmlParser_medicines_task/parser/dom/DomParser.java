package xmlParser_medicines_task.parser.dom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import xmlParser_medicines_task.entity.Certificate;
import xmlParser_medicines_task.entity.Package;
import xmlParser_medicines_task.entity.Preparation;
import xmlParser_medicines_task.entity.Version;
import xmlParser_medicines_task.xml_tag_name.PreparationTagName;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static xmlParser_medicines_task.parser.sax.Sax.PATH_MEDICINS;


public class DomParser {
    private static final Logger LOGGER = LogManager.getLogger(DomParser.class);
    private List<Preparation> preparationList = new ArrayList<>();
    private Preparation.Builder builderPreparation;
    private Version.Builder builderOfVersion;
    private Certificate.Builder builderOfCertificate;
    private Package.Builder builderOfPackage;

    private static Element getSingleChild (Element element, String childName){
        NodeList nodeList = element.getElementsByTagName(childName);
        Element child = (Element) nodeList.item(0);
        return child;
    }


    public List<Preparation> parse (String path) throws ParserConfigurationException {
        LOGGER.info("Dom start parsing file");
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(path);
            Element root = document.getDocumentElement();
            NodeList nodeListPreparation = root.getElementsByTagName(PreparationTagName.PREPARATION);
            NodeList nodeListVersion = root.getElementsByTagName(PreparationTagName.VERSION);
            NodeList nodeListAnalog = root.getElementsByTagName(PreparationTagName.ANALOG);


            builderOfCertificate = new Certificate.Builder();

            for (int i=0;i<nodeListPreparation.getLength();i++) {
                Node node = nodeListPreparation.item(i);
                Element element = (Element) node;
                builderPreparation = new Preparation.Builder();
                NamedNodeMap attributePreparation = node.getAttributes();
                builderPreparation.withGroup(attributePreparation.getNamedItem
                        (PreparationTagName.GROUP).getNodeValue());
                builderPreparation.withName(getSingleChild
                        (element, PreparationTagName.NAME).getTextContent().trim());
                builderPreparation.withPharm(getSingleChild
                        (element, PreparationTagName.PHARM).getTextContent().trim());
                builderPreparation.withAnalog(getSingleChild
                        (element, PreparationTagName.ANALOG).getTextContent().trim());
                 for (int j = 0; j < nodeListVersion.getLength(); j++) {
                   Node nodeVersion = nodeListVersion.item(i);
                   element = (Element) nodeVersion;
                    NamedNodeMap attributeVersion = nodeVersion.getAttributes();
                    builderOfVersion = new Version.Builder();

                    builderOfVersion.withTypeOfVersion(attributeVersion.getNamedItem(
                            PreparationTagName.TYPE_OF_VERSION).getNodeValue());
                    builderOfCertificate = new Certificate.Builder();
                    builderOfCertificate.withId(Integer.parseInt(getSingleChild(element,
                            PreparationTagName.CERTIFICATE_ID).
                            getTextContent().trim()));
                    builderOfCertificate.withStartDate(getSingleChild(element,
                            PreparationTagName.CERTIFICATE_DATE_START).
                            getTextContent().trim());
                    builderOfCertificate.withExpireDate(getSingleChild(element,
                            PreparationTagName.CERTIFICATE_DATE_FINISH).
                            getTextContent().trim());
                    builderOfCertificate.witRegistrationOrganization(getSingleChild(element,
                            PreparationTagName.REGISTRATION_ORAGANIZATION).
                            getTextContent().trim());
                    builderOfPackage = new Package.Builder();
                    builderOfPackage.withTypeOfPackage(getSingleChild(element,
                            PreparationTagName.TYPE_OF_PACKAGE).
                            getTextContent().trim());
                    builderOfPackage.withAmountInPackage(Integer.parseInt(getSingleChild(element,
                           PreparationTagName.AMOUNT_IN_PACKAGE).
                           getTextContent().trim()));
                    builderOfPackage.withPackagePrice(Double.parseDouble(getSingleChild(element,
                          PreparationTagName.PACKAGE_PRICE).
                          getTextContent().trim()));
                    builderOfPackage.withDosage(getSingleChild(element,
                            PreparationTagName.DOSAGE).getTextContent().trim());
                    builderOfPackage.withPeriodicity(getSingleChild(element,
                            PreparationTagName.PERIODICITY).
                            getTextContent().trim());
                     builderOfVersion.withPackage(builderOfPackage.build());
                     builderOfVersion.withCertificate(builderOfCertificate.build());
                     builderPreparation.withVersion(builderOfVersion.build());
                    /* todo неверно работает добавление версии (добавляет лишнюю версию)
                      и аналогов (не добавляет второй аналог)*/
                 }
                this.preparationList.add(builderPreparation.build());
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return preparationList;
    }

    public void printPreparations() {
        for (Preparation p : preparationList) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) throws ParserConfigurationException {
        DomParser domParser = new DomParser();
        domParser.parse(PATH_MEDICINS);
        domParser.printPreparations();

    }
}
