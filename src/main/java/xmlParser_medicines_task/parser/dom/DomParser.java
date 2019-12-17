package xmlParser_medicines_task.parser.dom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import xmlParser_medicines_task.entity.Certificate;
import xmlParser_medicines_task.entity.Package;
import xmlParser_medicines_task.entity.Preparation;
import xmlParser_medicines_task.entity.Version;
import xmlParser_medicines_task.parser.sax.Sax;
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

    private static Element getSingleChild (Element element, String childName){
        NodeList nodeList = element.getElementsByTagName(childName);
        Element child = (Element) nodeList.item(0);
        return child;
    }

    public List<Preparation> parse (String path) throws ParserConfigurationException {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(path);
            NodeList nodeListPreparation = document.getElementsByTagName(PreparationTagName.PREPARATION);
            System.out.println(nodeListPreparation.getLength());
            for (int i=0;i<nodeListPreparation.getLength();i++) {
                Node node = nodeListPreparation.item(i);
                Preparation preparation = new Preparation();
                Element element = (Element) node;
                NamedNodeMap attributePreparation = node.getAttributes();
                preparation.setGroup(attributePreparation.getNamedItem(PreparationTagName.GROUP).getNodeValue());
                preparation.setName(getSingleChild(element, PreparationTagName.NAME).getTextContent().trim());
                preparation.setPharm(getSingleChild(element, PreparationTagName.PHARM).getTextContent().trim());
                preparation.setAnalog(getSingleChild(element, PreparationTagName.ANALOG).getTextContent().trim());
                if (nodeListPreparation.item(i).hasChildNodes()) {
                    System.out.println(nodeListPreparation.item(i).getChildNodes());
                    Version version = new Version();
                    preparation.setVersion(version);
                    version.setTypeOfVersion(attributePreparation.getNamedItem(PreparationTagName.TYPE_OF_VERSION).
                            getNodeValue());
                    //TODO NullPointerException

                    Certificate certificate = new Certificate();
                    version.setCertificate(certificate);
                    certificate.setId(Integer.parseInt(getSingleChild(element, PreparationTagName.CERTIFICATE_ID).
                            getTextContent().trim()));
                    certificate.setStartDate(getSingleChild(element, PreparationTagName.CERTIFICATE_DATE_START).
                            getTextContent().trim());
                    certificate.setExpireDate(getSingleChild(element, PreparationTagName.CERTIFICATE_DATE_FINISH).
                            getTextContent().trim());
                    certificate.setRegistrationOfOrganization(getSingleChild(element, PreparationTagName.REGISTRATION_ORAGANIZATION).
                            getTextContent().trim());
                    Package packageOfDrug = new Package();
                    version.setPackageOfPreparation(packageOfDrug);
                    packageOfDrug.setTypeOfPackage(getSingleChild(element, PreparationTagName.TYPE_OF_PACKAGE).
                            getTextContent().trim());
                    packageOfDrug.setAmountInPackage(Integer.parseInt(getSingleChild(element, PreparationTagName.AMOUNT_IN_PACKAGE).
                            getTextContent().trim()));
                    packageOfDrug.setPackagePrice(Double.parseDouble(getSingleChild(element, PreparationTagName.PACKAGE_PRICE).
                            getTextContent().trim()));
                    packageOfDrug.setDosage(getSingleChild(element, PreparationTagName.DOSAGE).getTextContent().trim());
                    packageOfDrug.setPeriodicity(getSingleChild(element, PreparationTagName.PERIODICITY).
                            getTextContent().trim());
                    this.preparationList.add(preparation);
                }
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
        }
        return preparationList;
    }
    public void print (){
        for (Preparation p:preparationList ) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) throws ParserConfigurationException {
        DomParser domParser = new DomParser();
        domParser.parse(PATH_MEDICINS);
        domParser.print();

    }
}
