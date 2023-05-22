package fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme;

import fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.entities.bo.QuestionFichierBO;
import fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.modele.QuestionLoader;
import fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.modele.ServiceQuestionnaire;
import fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.utilities.exceptions.FileErrorLoadingCSVException;
import fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.utilities.exceptions.FileNotFoundException;
import junit.framework.TestCase;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class ServiceQuestionnaireTests extends TestCase {

    public void testUrlInvalideTest() throws FileErrorLoadingCSVException {
    	QuestionLoader questionLoader = new ServiceQuestionnaire();
		try {
			assertThrows(FileNotFoundException.class,questionLoader.chargerFichierQuestionnaire("urlnonvalide"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.utilities.exceptions.EmptyFileException e) {
			e.printStackTrace();
		}
	}

    public void testFileErrorLoadingCSVExceptionTest() throws FileErrorLoadingCSVException {
    	QuestionLoader questionLoader = new ServiceQuestionnaire();

		try {
			assertThrows(FileErrorLoadingCSVException.class,questionLoader.chargerFichierQuestionnaire("test/java/fr/iut/montreuil/S4_R04_02/_Quizzitos_questionnaire_sme/resources/IdQuestionnaireNonReference.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.utilities.exceptions.EmptyFileException e) {
			e.printStackTrace();
		}

		try {
			assertThrows(FileErrorLoadingCSVException.class,questionLoader.chargerFichierQuestionnaire("test/java/fr/iut/montreuil/S4_R04_02/_Quizzitos_questionnaire_sme/resources/IdQuestionNonReference.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.utilities.exceptions.EmptyFileException e) {
			e.printStackTrace();
		}

		try {
			assertThrows(FileErrorLoadingCSVException.class,questionLoader.chargerFichierQuestionnaire("test/java/fr/iut/montreuil/S4_R04_02/_Quizzitos_questionnaire_sme/resources/LangageNonReference.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.utilities.exceptions.EmptyFileException e) {
			e.printStackTrace();
		}

		try {
			assertThrows(FileErrorLoadingCSVException.class,questionLoader.chargerFichierQuestionnaire("test/java/fr/iut/montreuil/S4_R04_02/_Quizzitos_questionnaire_sme/resources/LibelleQuestionNonReference.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.utilities.exceptions.EmptyFileException e) {
			e.printStackTrace();
		}

	}
    public void testFileCorrect() throws FileErrorLoadingCSVException {
    	QuestionLoader questionLoader = new ServiceQuestionnaire();

		List<QuestionFichierBO> list = null;
		try {
			list = questionLoader.chargerFichierQuestionnaire("test/java/fr/iut/montreuil/S4_R04_02/_Quizzitos_questionnaire_sme/resources/questionsQuizz_V1.1.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.utilities.exceptions.EmptyFileException e) {
			e.printStackTrace();
		}

		assertEquals(1,list.get(0).getIdQuestion());
    }
}
