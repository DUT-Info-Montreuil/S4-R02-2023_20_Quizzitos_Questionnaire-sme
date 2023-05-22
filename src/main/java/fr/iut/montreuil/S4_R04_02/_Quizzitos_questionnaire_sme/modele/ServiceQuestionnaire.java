package fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.modele;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.entities.bo.QuestionFichierBO;
import fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.utilities.exceptions.EmptyFileException;
import fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.utilities.exceptions.FileErrorLoadingCSVException;
import fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.utilities.exceptions.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServiceQuestionnaire implements  QuestionLoader {

    @Override
    public List<QuestionFichierBO> chargerFichierQuestionnaire(String filename) throws FileNotFoundException, FileErrorLoadingCSVException, EmptyFileException {
        List<QuestionFichierBO> list = new ArrayList<>();
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filename))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {
            List<String[]> csvData = reader.readAll();
            if (csvData.size() == 0)
                throw new EmptyFileException();
            for (String[] row : csvData) {
                // Accédez aux colonnes par leur index, en fonction de l'ordre spécifié
                int idQuestionnaire = Integer.parseInt(row[0].replaceAll("\\p{C}", ""));
                int idQuestion = Integer.parseInt(row[1]);
                String langue = row[2];
                String question = row[3];
                String reponse = row[4];
                int difficulte = Integer.parseInt(row[5]);
                String explication = row[6];
                String source = row[7];
                QuestionFichierBO questionBO = new QuestionFichierBO(idQuestionnaire,idQuestion,langue,question,reponse,difficulte,explication,source);
                list.add(questionBO);
            }
            return list;
        } catch (CsvException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
