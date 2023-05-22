package fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.modele;

import fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.entities.bo.QuestionFichierBO;
import fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.utilities.exceptions.EmptyFileException;
import fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.utilities.exceptions.FileErrorLoadingCSVException;
import fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.utilities.exceptions.FileNotFoundException;

import java.util.List;

public interface QuestionLoader {
    public List<QuestionFichierBO> chargerFichierQuestionnaire(String filename) throws
            FileNotFoundException, FileErrorLoadingCSVException, EmptyFileException;
}
