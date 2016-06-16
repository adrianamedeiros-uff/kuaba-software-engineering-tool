package br.ucam.kuabaSubsystem.kuabaModel;

//import edu.stanford.smi.protegex.owl.model.*;

import java.util.*;

/**
 * Generated by Protege-OWL  (http://protege.stanford.edu/plugins/owl).
 * Source OWL Class: http://www.tecweb.inf.puc-rio.br/DesignRationale/KuabaOntology.owl#Argument
 *
 * @version generated on Sat Jun 21 10:48:19 BRT 2008
 */
public interface Argument extends ReasoningElement {

    // Property http://www.tecweb.inf.puc-rio.br/DesignRationale/KuabaOntology.owl#considers

    Question getConsiders();

//    RDFProperty getConsidersProperty();

    boolean hasConsiders();

    void setConsiders(Question newConsiders);


    // Property http://www.tecweb.inf.puc-rio.br/DesignRationale/KuabaOntology.owl#inFavorOf

    Collection<Idea> getInFavorOf();

//    RDFProperty getInFavorOfProperty();

    boolean hasInFavorOf();

    Iterator<Idea> listInFavorOf();

    void addInFavorOf(Idea newInFavorOf);

    void removeInFavorOf(Idea oldInFavorOf);

    void setInFavorOf(Collection<Idea> newInFavorOf);


    // Property http://www.tecweb.inf.puc-rio.br/DesignRationale/KuabaOntology.owl#isVersionOf

    Argument getIsVersionOf();

//    RDFProperty getIsVersionOfProperty();

    boolean hasIsVersionOf();

    void setIsVersionOf(Argument newIsVersionOf);


    // Property http://www.tecweb.inf.puc-rio.br/DesignRationale/KuabaOntology.owl#objectsTo

    //Retorna os argumentos contra uma ideia
    Collection<Idea> getObjectsTo();

//    RDFProperty getObjectsToProperty();

    boolean hasObjectsTo();

    Iterator<Idea> listObjectsTo();

    
    void addObjectsTo(Idea newObjectsTo);

    
    void removeObjectsTo(Idea oldObjectsTo);

    void setObjectsTo(Collection<Idea> newObjectsTo);
}
