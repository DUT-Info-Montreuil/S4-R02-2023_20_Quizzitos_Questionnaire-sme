package fr.iut.montreuil.S4_R04_02._Quizzitos_questionnaire_sme.entities.bo;

public class QuestionFichierBO {
    private int idQuestionnaire;
    private int idQuestion;
    private String langue;
    private String libQuestion;
    private String reponseQuestion;
    private int difficultQuestion;
    private String explicationQuestion;
    private String refQuestion;

    public QuestionFichierBO(int idQuestionnaire,int idQuestion,String langue, String libQuestion, String reponseQuestion,int difficultQuestion,String explicationQuestion, String refQuestion) {
        this.idQuestionnaire = idQuestionnaire;
        this.idQuestion = idQuestion;
        this.langue = langue;
        this.libQuestion = libQuestion;
        this.reponseQuestion = reponseQuestion;
        this.difficultQuestion = difficultQuestion;
        this.explicationQuestion = explicationQuestion;
        this.refQuestion = refQuestion;
    }

    public int getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public String getLangue() {
        return langue;
    }

    public String getLibQuestion() {
        return libQuestion;
    }

    public String getReponseQuestion() {
        return reponseQuestion;
    }

    public int getDifficultQuestion() {
        return difficultQuestion;
    }

    public String getExplicationQuestion() {
        return explicationQuestion;
    }

    public String getRefQuestion() {
        return refQuestion;
    }
}
