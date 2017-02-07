package org.wuxinshui.boosters.xml;

import de.odysseus.staxon.json.JsonXMLConfig;
import de.odysseus.staxon.json.JsonXMLConfigBuilder;
import de.odysseus.staxon.json.JsonXMLInputFactory;
import de.odysseus.staxon.xml.util.PrettyXMLEventWriter;
import de.odysseus.staxon.xml.util.PrettyXMLStreamWriter;

import javax.xml.stream.*;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stax.StAXResult;
import javax.xml.transform.stax.StAXSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * Created by FujiRen on 2016/5/12.
 */
public class JSON2XML {

    /**
     * Copying JSON to XML via StAX Event API
     * @param jsonStr
     */
    public static void transToXml(String jsonStr) {
        InputStream input = new ByteArrayInputStream(jsonStr.getBytes());

        OutputStream output = System.out;
        /*
         * If the <code>multiplePI</code> property is
         * set to <code>true</code>, the StAXON reader will generate
         * <code>&lt;xml-multiple&gt;</code> processing instructions
         * which would be copied to the XML output.
         * These can be used by StAXON when converting back to JSON
         * to trigger array starts.
         * Set to <code>false</code> if you don't need to go back to JSON.
         */
        JsonXMLConfig config = new JsonXMLConfigBuilder().multiplePI(false).build();
        try {
            /*
             * Create reader (JSON).
             */
            XMLEventReader reader = new JsonXMLInputFactory(config).createXMLEventReader(input);

            /*
             * Create writer (XML).
             */
            XMLEventWriter writer = XMLOutputFactory.newInstance().createXMLEventWriter(output);
            writer = new PrettyXMLEventWriter(writer); // format output

            /*
             * Copy events from reader to writer.
             */
            writer.add(reader);

            /*
             * Close reader/writer.
             */
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            /*
             * As per StAX specification, XMLEventReader/Writer.close() doesn't close
             * the underlying stream.
             */
            try {
                output.close();
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Copying JSON to XML via XSL Transformation
     * @param jsonStr
     */
    public static void transToXml2(String jsonStr) {
        InputStream input = new ByteArrayInputStream(jsonStr.getBytes());
//        InputStream input = JSON2XML.class.getResourceAsStream("input.json");
        OutputStream output = System.out;
        JsonXMLConfig config = new JsonXMLConfigBuilder().multiplePI(false).build();
        try {
            /*
             * Create source (JSON).
             */
            XMLStreamReader reader = new JsonXMLInputFactory(config).createXMLStreamReader(input);
            Source source = new StAXSource(reader);

            /*
             * Create result (XML).
             */
            XMLStreamWriter writer = XMLOutputFactory.newInstance().createXMLStreamWriter(output);
            Result result = new StAXResult(new PrettyXMLStreamWriter(writer)); // format output

            /*
             * Copy source to result via "identity transform".
             */
            TransformerFactory.newInstance().newTransformer().transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /*
             * As per StAX specification, XMLStreamReader/Writer.close() doesn't close
             * the underlying stream.
             */
            try {
                output.close();
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        return "";
    }
}
