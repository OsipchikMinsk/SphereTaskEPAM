package xmlParser_medicines_task.parser.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import xmlParser_medicines_task.entity.Certificate;
import xmlParser_medicines_task.entity.Package;
import xmlParser_medicines_task.entity.Preparation;
import xmlParser_medicines_task.entity.Version;
import xmlParser_medicines_task.xml_tag_name.PreparationTagName;

import java.util.ArrayList;
import java.util.List;

public class SaxHandler extends DefaultHandler {

    private List<Preparation> listOfPreparations;
    private Preparation preparation;
    private StringBuilder drugsInformation;
    private Version version;
    private Certificate certificate;
    private Package packageOfDrugs;
    public List<Preparation> getListOfPreparations() {
        return listOfPreparations;
    }

    public void startDocument ()throws SAXException{
        System.out.println("Sax started parsing file");
    }
    public void finishDocument () throws SAXException{
        System.out.println("Sax finished parsing file");
        //TODO почему не срабатываеи вывод?
    }

    public void characters(char[] buffer, int start, int end) {
        drugsInformation.append(buffer, start, end);
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        drugsInformation = new StringBuilder();
        switch (qName) {
            case PreparationTagName.MEDICINS:
                listOfPreparations = new ArrayList<>();
                break;
            case PreparationTagName.PREPARATION:
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
    public void endElement(String uri, String localName, String qName) throws SAXException{
            switch (qName){
            case PreparationTagName.PREPARATION:
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
