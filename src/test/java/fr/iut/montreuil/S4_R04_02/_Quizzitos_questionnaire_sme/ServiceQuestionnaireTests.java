package fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ServiceQuestionnaireTests extends TestCase {

    public void testUrlInvalideTest() {
    	QuestionLoader questionLoader = new ServiceQuestionnaire();
        assertThrows(FileNotFoundException.class,questionLoader.chargerFichierQuestionnaire("urlnonvalide"));
    }

    public void testFileErrorLoadingCSVExceptionTest() {
    	QuestionLoader questionLoader = new ServiceQuestionnaire();

    	assertThrows(FileErrorLoadingCSVException.class,questionLoader.chargerFichierQuestionnaire("test/java/fr/iut/montreuil/S4_R04_02/_Quizzitos_questionnaire_sme/resources/IdQuestionnaireNonReference.csv"));
   
    	assertThrows(FileErrorLoadingCSVException.class,questionLoader.chargerFichierQuestionnaire("test/java/fr/iut/montreuil/S4_R04_02/_Quizzitos_questionnaire_sme/resources/IdQuestionNonReference.csv"));

    	assertThrows(FileErrorLoadingCSVException.class,questionLoader.chargerFichierQuestionnaire("test/java/fr/iut/montreuil/S4_R04_02/_Quizzitos_questionnaire_sme/resources/LangageNonReference.csv"));

    	assertThrows(FileErrorLoadingCSVException.class,questionLoader.chargerFichierQuestionnaire("test/java/fr/iut/montreuil/S4_R04_02/_Quizzitos_questionnaire_sme/resources/LibelleQuestionNonReference.csv"));

    }
    public void testFileCorrect() {
    	QuestionLoader questionLoader = new ServiceQuestionnaire();

    	List<QuestionBO> list = questionLoader.chargerFichierQuestionnaire("test/java/fr/iut/montreuil/S4_R04_02/_Quizzitos_questionnaire_sme/resources/questionsQuizz_V1.1.csv");
   
    	assertEquals(1,list.get(0).getidQuestion());
    }
}
