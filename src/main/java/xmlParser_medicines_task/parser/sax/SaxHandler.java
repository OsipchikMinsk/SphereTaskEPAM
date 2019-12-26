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
    private StringBuilder drugsInformation;
    private Preparation.Builder builderPreparation;
    private Version.Builder builderOfVersion;
    private Certificate.Builder builderOfCertificate;
    private Package.Builder builderOfPackage;


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
                builderPreparation = new Preparation.Builder();
                builderPreparation.withGroup(attributes.getValue(PreparationTagName.GROUP));
                break;
            case PreparationTagName.VERSION:
                builderOfVersion = new Version.Builder();
                builderOfVersion.withTypeOfVersion(attributes.getValue(PreparationTagName.TYPE_OF_VERSION));
                break;
            case PreparationTagName.CERTIFICATE:
                builderOfCertificate = new Certificate.Builder();
                break;
            case PreparationTagName.PACKAGE:
                builderOfPackage = new Package.Builder();
                break;
        }
    }
    public void endElement(String uri, String localName, String qName) throws SAXException{
        switch (qName) {
            case PreparationTagName.PREPARATION:
                builderOfVersion.withPackage(builderOfPackage.build());
                builderOfVersion.withCertificate(builderOfCertificate.build());
                listOfPreparations.add(builderPreparation.build());
                break;
            case PreparationTagName.VERSION:
                builderPreparation.withVersion(builderOfVersion.build());
                break;
            case PreparationTagName.NAME:
                builderPreparation.withName(drugsInformation.toString());
                break;
            case PreparationTagName.PHARM:
                builderPreparation.withPharm(drugsInformation.toString());
                break;
            case PreparationTagName.ANALOG:
                builderPreparation.withAnalog(drugsInformation.toString());
                break;
            case PreparationTagName.CERTIFICATE:
                builderOfVersion.withCertificate(builderOfCertificate.build());
                break;
            case PreparationTagName.CERTIFICATE_ID:
                builderOfCertificate.withId(Integer.parseInt(drugsInformation.toString()));
                break;
            case PreparationTagName.CERTIFICATE_DATE_START:
                builderOfCertificate.withStartDate(drugsInformation.toString());
                break;
            case PreparationTagName.CERTIFICATE_DATE_FINISH:
                builderOfCertificate.withExpireDate(drugsInformation.toString());
                break;
            case PreparationTagName.REGISTRATION_ORAGANIZATION:
                builderOfCertificate.witRegistrationOrganization(drugsInformation.toString());
                break;
            case PreparationTagName.PACKAGE:
                builderOfVersion.withPackage(builderOfPackage.build());
                break;
            case PreparationTagName.TYPE_OF_PACKAGE:
                builderOfPackage.withTypeOfPackage(drugsInformation.toString());
                break;
            case PreparationTagName.AMOUNT_IN_PACKAGE:
                builderOfPackage.withAmountInPackage(Integer.parseInt(drugsInformation.toString()));
                break;
            case PreparationTagName.PACKAGE_PRICE:
                builderOfPackage.withPackagePrice(Double.parseDouble(drugsInformation.toString()));
                break;
            case PreparationTagName.DOSAGE:
                builderOfPackage.withDosage(drugsInformation.toString());
                break;
            case PreparationTagName.PERIODICITY:
                builderOfPackage.withPeriodicity(drugsInformation.toString());
                break;
        }
    }
    public List<Preparation> getListOfPreparations() {
        return listOfPreparations;
    }
}
