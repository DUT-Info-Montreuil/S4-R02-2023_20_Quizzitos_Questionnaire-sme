package fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;



/**
 * Unit test for simple App.
 */
public class ServiceQuestionnaireTests extends TestCase {

	private QuestionLoader questionLoader;

	@BeforeEach
	public void init() {
		questionLoader = new ServiceQuestionnaire();
	}
    public void testUrlInvalideTest() {
        assertThrows(FileNotFoundException.class,questionLoader.chargerFichierQuestionnaire("urlnonvalide"));
    }

    public void testFileErrorLoadingCSVExceptionTest() {
    	assertThrows(FileErrorLoadingCSVException.class,questionLoader.chargerFichierQuestionnaire("test/java/fr/iut/montreuil/S4_R04_02/_Quizzitos_questionnaire_sme/resources/IdQuestionnaireNonReference.csv"));
   
    	assertThrows(FileErrorLoadingCSVException.class,questionLoader.chargerFichierQuestionnaire("test/java/fr/iut/montreuil/S4_R04_02/_Quizzitos_questionnaire_sme/resources/IdQuestionNonReference.csv"));

    	assertThrows(FileErrorLoadingCSVException.class,questionLoader.chargerFichierQuestionnaire("test/java/fr/iut/montreuil/S4_R04_02/_Quizzitos_questionnaire_sme/resources/LangageNonReference.csv"));

    	assertThrows(FileErrorLoadingCSVException.class,questionLoader.chargerFichierQuestionnaire("test/java/fr/iut/montreuil/S4_R04_02/_Quizzitos_questionnaire_sme/resources/LibelleQuestionNonReference.csv"));

    }
    public void testFileCorrect() {
    	List<QuestionBO> list = questionLoader.chargerFichierQuestionnaire("test/java/fr/iut/montreuil/S4_R04_02/_Quizzitos_questionnaire_sme/resources/questionsQuizz_V1.1.csv");
   
    	assertEquals(1,list.get(0).getidQuestion());
    }
	public void testFileEmpty() {
		assertThrows(EmptyFileException.class,questionLoader.chargerFichierQuestionnaire("test/java/fr/iut/montreuil/S4_R04_02/_Quizzitos_questionnaire_sme/resources/empty.csv"));
	}
}
