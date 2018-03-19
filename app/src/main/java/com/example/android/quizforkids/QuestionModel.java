package com.example.android.quizforkids;

import java.io.Serializable;

public class QuestionModel implements Serializable{

    String question;
    String choices[];
    String answer;
    String answers[];
    boolean isRadioGroup;
    boolean isTextEntry;
    boolean isCheckBox;

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public boolean isRadioGroup() {
        return isRadioGroup;
    }

    public void setRadioGroup(boolean radioGroup) {
        isRadioGroup = radioGroup;
    }

    public boolean isTextEntry() {
        return isTextEntry;
    }

    public void setTextEntry(boolean textEntry) {
        isTextEntry = textEntry;
    }

    public boolean isCheckBox() {
        return isCheckBox;
    }

    public void setCheckBox(boolean checkBox) {
        isCheckBox = checkBox;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getChoices() {
        return choices;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionModel() {
    }

    public QuestionModel(String question, String[] choices, String answer, boolean isRadioGroup, boolean isTextEntry, boolean isCheckBox) {
        this.question = question;
        this.choices = choices;
        this.answer = answer;
        this.isRadioGroup = isRadioGroup;
        this.isTextEntry = isTextEntry;
        this.isCheckBox = isCheckBox;
    }

    public QuestionModel(String question, String[] choices, String[] answers, boolean isRadioGroup, boolean isTextEntry, boolean isCheckBox) {
        this.question = question;
        this.choices = choices;
        this.answers = answers;
        this.isRadioGroup = isRadioGroup;
        this.isTextEntry = isTextEntry;
        this.isCheckBox = isCheckBox;
    }
}
