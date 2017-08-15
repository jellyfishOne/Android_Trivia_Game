package com.trivia_game.android.triviagame;

public class Questions {
    //Intance variables
    String[] questions;
    String[][] choices;
    String[] correctAnswers;
    String[] correct;
    String[] wrong;


    public Questions(){

        this.questions = setQuestions();
        this.choices = setChoices();
        this.correctAnswers = setAnswers();
        this.correct = setCorrect();
        this.wrong = setWrong();
    }
    public String[] getCorrect(){
        return correct;
    }

    public String[] getWrong(){
        return wrong;
    }

    public String[] getQuestions(){
        return questions;

    }

    public String[][] getChoices(){
        return choices;
    }

    public  String[] getAnsewers(){
        return correctAnswers;
    }

    private String[] setQuestions() {
        String[] q = {
                "A cat's genome is what percent tiger?",
                "Cants are belived to not be able to taste: ",
                "How many toes are cat supposed to have?",
                "How many bones do cats have?",
                "Cats typically sleep for how many hours a day?",
                "A cat with a question-mark-shaped tail is asking: ",
                "Cats find it threatening when you: ",
                "If a cat approaches you with a very straight, almost vibrating tail, this means: ",
                "Kneading is a sign of: ",
                "A cat's learning style is about the same as: ",
        };
        return q;
    }

    private String[][] setChoices(){
        String[][] c = {
                {"65%", "15%", "0%", "95%"},
                {"sour", "sweet", "bitter", "spicy"},
                {"20", "16", "18", "12"},
                {"230", "206", "180", "300"},
                {"6-8 hours", "4-6 hours ", "12-16 hours", "9-12 hours"},
                {"Who are you?", "What time is it?", "Want to play?", "Are we there yet?"},
                {"Shake their paw", "Rub their belly", "Make eye contact", "Yawn at them"},
                {"You are invading personal space", "The cat is happy to see you", "Nothing",
                        "The cat is very angry"},
                {"Signs of wanting to go to culinary school", "Content and happiness", "Sleepiness",
                        "Desires attention"},
                {"0-6 month baby", "6-11 month baby", "1-2 year-old child", "2-3 year-old child"}
        };
        return c;
    }

    private String[] setAnswers(){
        String[] a = {
               "95%",
                "sweet",
                "18",
                "230",
                "12-16 hours",
                "Want to play?",
                "Make eye contact",
                "The cat is happy to see you",
                "Content and happiness",
                "2-3 year-old child",

        };
        return a;
    }

    private String[] setCorrect(){
        String[] c ={
                "Great Job!",
                "Correct!",
                "Awesome!",
                "Keep it up!"
        };
        return c;
    }

    private String[] setWrong(){
        String[] w = {
                "Wrong!",
                "Nope",
                "Incorrect",
                "No good"
        };
        return w;
    }
}
