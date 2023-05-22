package fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme;

import fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.entities.bo.QuestionFichierBO;
import fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.modele.QuestionLoader;
import fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.modele.ServiceQuestionnaire;
import fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.utilities.exceptions.FileErrorLoadingCSVException;
import fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.utilities.exceptions.FileNotFoundException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class ServiceQuestionnaireTests extends TestCase {

    public void testUrlInvalideTest() throws FileErrorLoadingCSVException {
    	QuestionLoader questionLoader = new ServiceQuestionnaire();
        assertThrows(FileNotFoundException.class,questionLoader.chargerFichierQuestionnaire("urlnonvalide"));
    }

    public void testFileErrorLoadingCSVExceptionTest() throws FileErrorLoadingCSVException {
    	QuestionLoader questionLoader = new ServiceQuestionnaire();

    	assertThrows(FileErrorLoadingCSVException.class,questionLoader.chargerFichierQuestionnaire("test/java/fr/iut/montreuil/S4_R04_02/_Quizzitos_questionnaire_sme/resources/IdQuestionnaireNonReference.csv"));
   
    	assertThrows(FileErrorLoadingCSVException.class,questionLoader.chargerFichierQuestionnaire("test/java/fr/iut/montreuil/S4_R04_02/_Quizzitos_questionnaire_sme/resources/IdQuestionNonReference.csv"));

    	assertThrows(FileErrorLoadingCSVException.class,questionLoader.chargerFichierQuestionnaire("test/java/fr/iut/montreuil/S4_R04_02/_Quizzitos_questionnaire_sme/resources/LangageNonReference.csv"));

    	assertThrows(FileErrorLoadingCSVException.class,questionLoader.chargerFichierQuestionnaire("test/java/fr/iut/montreuil/S4_R04_02/_Quizzitos_questionnaire_sme/resources/LibelleQuestionNonReference.csv"));

    }
    public void testFileCorrect() throws FileErrorLoadingCSVException {
    	QuestionLoader questionLoader = new ServiceQuestionnaire();

    	List<QuestionFichierBO> list = questionLoader.chargerFichierQuestionnaire("test/java/fr/iut/montreuil/S4_R04_02/_Quizzitos_questionnaire_sme/resources/questionsQuizz_V1.1.csv");
   
    	assertEquals(1,list.get(0).getIdQuestion());
    }
}
