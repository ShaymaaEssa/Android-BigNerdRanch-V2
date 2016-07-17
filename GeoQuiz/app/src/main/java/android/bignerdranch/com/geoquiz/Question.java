package android.bignerdranch.com.geoquiz;

/**
 * Created by MOSTAFA on 14/07/2016.
 */
public class Question {
    int questionId;
    String question;
    boolean answer;

    public Question(int questionId, String question, boolean answer) {
        this.questionId = questionId;
        this.question = question;
        this.answer = answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
