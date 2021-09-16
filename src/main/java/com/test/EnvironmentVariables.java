package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/variables")
public class EnvironmentVariables {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Variable> getVariablesJson() {
        
        List<Variable> variableList = new ArrayList<Variable>();
        
        Map<String, String> treeMap = new TreeMap<String, String>(System.getenv());
        
        for (Map.Entry <String, String> entry: treeMap.entrySet()) {
            Variable variable = new Variable();
            variable.setName(entry.getKey());
            variable.setValue(entry.getValue());
            variableList.add(variable);
        }
        
        return variableList;
        
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("text")
    public String getVariablesText() {
        
        String variables = "ENVIRONMENT VARIABLES:" + System.lineSeparator();
        
        Map<String, String> treeMap = new TreeMap<String, String>(System.getenv());
        
        for (Map.Entry <String, String> entry: treeMap.entrySet()) {
            variables = variables + System.lineSeparator() + entry.getKey() + " = " + entry.getValue();
        }
        
        return variables;
        
    }

}