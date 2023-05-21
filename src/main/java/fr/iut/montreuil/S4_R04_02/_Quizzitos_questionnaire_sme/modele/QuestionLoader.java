package fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.modele;

import fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.entities.bo.QuestionFichierBO;
import fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.utilities.exceptions.FileErrorLoadingCSV;

import java.util.List;

public interface QuestionLoader {
    public List<QuestionFichierBO> chargerFichierQuestionnaire(String filename) throws
            FileErrorLoadingCSV, FileErrorLoadingCSV;
}
