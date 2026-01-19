package eu.kazernedossin.bibliotheekweb.dao;

import com.herminiogarcia.dmaog.dataAccess.DataAccess;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class DataAccessSingleton {

    private static DataAccess dataAccess;
    private static String dataFile;
    private static String mappingRules; //getMappingRules();
    private static String mappingLanguage; // = "shexml";
    private static Long reloadMinutes;
    private static String username;
    private static String password;
    //private static String drivers = "jdbc:ucanaccess%net.ucanaccess.jdbc.UcanaccessDriver";
    private static String drivers;
    private static String sparqlEndpoint = "https://bibliotheek.kazernedossin.eu/sparql";
    //private static String sparqlEndpoint;
    private static String sparqlEndpointUsername;
    private static String sparqlEndpointPassword;
    private static Map<String, String> prefixes = new HashMap<String, String>() {{
        put("kdbib","http://bibliotheek.kazernedossin.eu/books/");
        put("schema","http://schema.org/");
        put("","http://example.com/");
        put("dbr","http://dbpedia.org/resource/");
        put("xsd","http://www.w3.org/2001/XMLSchema#");
        put("dc","http://purl.org/dc/elements/1.1/");
    }};

    public static DataAccess getInstance() {
        if(dataAccess == null) {
            dataAccess = new DataAccess(dataFile, mappingRules, mappingLanguage, reloadMinutes,
                    username, password, drivers, sparqlEndpoint, sparqlEndpointUsername, sparqlEndpointPassword, prefixes);
        }
        return dataAccess;
    }

    private static String getMappingRules() {
        String rules = null;
        try {
            rules = String.join("", Files.readAllLines(Paths.get("books.shexml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rules;
    }
}
