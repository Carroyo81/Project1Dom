package project1dom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Charlie
 */
public class DomManager {

    List<CD> cdList = new ArrayList();

    public List<CD> getCDList() {

        String filePath = "C:\\Users\\Charlie\\Documents\\NetBeansProjects\\Project1Dom\\src\\project1dom\\cd_catalog.xml";
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;

        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("CD");
            //now XML is loaded as Document in memory, lets convert it to Object List

            for (int i = 0; i < nodeList.getLength(); i++) {
                cdList.add(getCD(nodeList.item(i)));

            }

         //   for (CD s : cdList) {
            //    System.out.println(s.toString());

          //  }

        } catch (SAXException | ParserConfigurationException | IOException e1) {
            e1.printStackTrace();
        }
        return cdList;
    }

    private static CD getCD(Node node) {
        //XMLReaderDOM domReader = new XMLReaderDOM();
        CD cd = new CD();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            cd.setArtist(getTagValue("ARTIST", element));
            cd.setTitle(getTagValue("TITLE", element));
            cd.setCompany(getTagValue("COMPANY", element));
            cd.setCountry(getTagValue("COUNTRY", element));
            cd.setYear(Integer.parseInt(getTagValue("YEAR", element)));
            cd.setPrice(Double.parseDouble(getTagValue("PRICE", element)));
        }

        return cd;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}
