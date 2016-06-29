package com.landscape.schoolexandroid.mode.worktask;

/**
 * Created by 1 on 2016/6/28.
 */
public class QuestionInfo {


    /**
     * $id : 4
     * Id : 2389836
     * QuestionTypeId : 1
     * AlternativeContent : [{"Id":"A","Content":"某厂生产的电灯使用寿命"},{"Id":"B","Content":"全国初中生的视力情况<br>"},{"Id":"C","Content":"某校七年级学生的身高情况"},{"Id":"D","Content":"\"娃哈哈\"产品的合格率"}]
     * AnswerType : [{"Id":"1","Content":"$option:1$","TypeId":1}]
     * Answer : [{"Id":"1","Answer":"C"}]
     * Fraction : 4
     * Sort : 1
     * StudentsAnswer : [
     {
     "Answer" : "C",
     "Id" : 1,
     "TypeId" : 1
     }
     ]
     */

    private int Id;
    private int QuestionTypeId;
    private String AlternativeContent;
    private String AnswerType;
    private String Answer;
    private int Fraction;
    private int Sort;
    private String StudentsAnswer;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getQuestionTypeId() {
        return QuestionTypeId;
    }

    public void setQuestionTypeId(int QuestionTypeId) {
        this.QuestionTypeId = QuestionTypeId;
    }

    public String getAlternativeContent() {
        return AlternativeContent;
    }

    public void setAlternativeContent(String AlternativeContent) {
        this.AlternativeContent = AlternativeContent;
    }

    public String getAnswerType() {
        return AnswerType;
    }

    public void setAnswerType(String AnswerType) {
        this.AnswerType = AnswerType;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String Answer) {
        this.Answer = Answer;
    }

    public int getFraction() {
        return Fraction;
    }

    public void setFraction(int Fraction) {
        this.Fraction = Fraction;
    }

    public int getSort() {
        return Sort;
    }

    public void setSort(int Sort) {
        this.Sort = Sort;
    }

    public String getStudentsAnswer() {
        return StudentsAnswer;
    }

    public void setStudentsAnswer(String StudentsAnswer) {
        this.StudentsAnswer = StudentsAnswer;
    }
}
