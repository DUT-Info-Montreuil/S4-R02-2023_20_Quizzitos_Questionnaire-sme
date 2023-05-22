package fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme;
import fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.entities.bo.QuestionFichierBO;
import fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.modele.QuestionLoader;
import fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.modele.ServiceQuestionnaire;
import fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.utilities.exceptions.EmptyFileException;
import fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.utilities.exceptions.FileErrorLoadingCSVException;
import fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.utilities.exceptions.OpenFileCSVException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit test for simple App.
 */
public class ServiceQuestionnaireTests{
	private QuestionLoader questionLoader;

	@BeforeEach
	public void init() {
		questionLoader = new ServiceQuestionnaire();
	}
	@Test
    public void testUrlInvalideTest() throws FileErrorLoadingCSVException, OpenFileCSVException, EmptyFileException {
		assertThrows(OpenFileCSVException.class, () -> {
			questionLoader.chargerFichierQuestionnaire("urlnonvalide");
		});
	}

	@Test
	public void testFileErrorLoadingCSVExceptionTest() throws FileErrorLoadingCSVException, OpenFileCSVException, EmptyFileException {
    	assertThrows(FileErrorLoadingCSVException.class,() -> {questionLoader.chargerFichierQuestionnaire("src/test/java/fr/iut/montreuil/S4_R04_02/_Quizzitos_questionnaire_sme/resources/IdQuestionnaireNonReference.csv");});
   
    	assertThrows(FileErrorLoadingCSVException.class, () -> {questionLoader.chargerFichierQuestionnaire("src/test/java/fr/iut/montreuil/S4_R04_02/_Quizzitos_questionnaire_sme/resources/IdQuestionNonReference.csv");});

		assertThrows(FileErrorLoadingCSVException.class, () -> {questionLoader.chargerFichierQuestionnaire("src/test/java/fr/iut/montreuil/S4_R04_02/_Quizzitos_questionnaire_sme/resources/LangageNonReference.csv");});

		assertThrows(FileErrorLoadingCSVException.class, () -> {questionLoader.chargerFichierQuestionnaire("src/test/java/fr/iut/montreuil/S4_R04_02/_Quizzitos_questionnaire_sme/resources/LibelleQuestionNonReference.csv");});
	}

	@Test
	public void testFileCorrect() throws FileErrorLoadingCSVException, OpenFileCSVException, EmptyFileException {
    	List<QuestionFichierBO> list = questionLoader.chargerFichierQuestionnaire("src/test/java/fr/iut/montreuil/S4_R04_02/_Quizzitos_questionnaire_sme/resources/questionsQuizz_V1.1.csv");
    	assertEquals(1,list.get(0).getIdQuestion());
    }

	@Test
	public void testFileEmpty() throws FileErrorLoadingCSVException, OpenFileCSVException, EmptyFileException {
		assertThrows(EmptyFileException.class, () -> {questionLoader.chargerFichierQuestionnaire("src/test/java/fr/iut/montreuil/S4_R04_02/_Quizzitos_questionnaire_sme/resources/empty.csv");});
	}
}
