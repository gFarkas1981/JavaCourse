package com.gfarkas;

public class ITStudent extends Student {

    private String favLanguage;

    public ITStudent() {
    }

    public ITStudent(String name, int achievedScore, String favLanguage) {
        super(name, achievedScore);
        this.favLanguage = favLanguage;
    }

    public void hateWindows(String hate) {

        System.out.println("This windows is " + hate);

    }

    @Override
    public void evaluator(int maxScore) {
        super.evaluator(getAchievedScore());
    }

    @Override
    public void display() {

        System.out.println(getName() + "'s mark is: "
                + getMark() + " and the achieved score is "
                + getAchievedScore() + " favorite language is " +favLanguage);

    }

    public String getFavLanguage() {
        return favLanguage;
    }

    public void setFavLanguage(String favLanguage) {
        this.favLanguage = favLanguage;
    }
}
