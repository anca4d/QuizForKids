package com.example.android.quizforkids;

import java.util.ArrayList;
import java.util.List;

public class Questions {

    public static List<QuestionModel> getQuestion(){
        List<QuestionModel> questions = new ArrayList<QuestionModel>();
            questions.add( new QuestionModel("If I have 3 apples, and John gives me 2, how many apples do I have now?",
                    new String[]{"3", "4", "5"}, "5", true, false, false));
            questions.add( new QuestionModel("Bob’s father has 4 children. Momo, Meme, and Mumu are three of them. Who’s the fourth?",
                    new String[]{"Meme", "Bob", "Andrew"}, "Bob", true, false, false));
            questions.add( new QuestionModel("You have a match and you enter a wagon with a candle, a lamp and a fireplace. Which one do you light first?",
                    new String[]{"The candle", "The Lamp", "Your match"}, "Your match", true, false, false));
            questions.add(new QuestionModel("What do caterpillars become?",
                    new String[]{"An ant", "A ladybug", "A butterfly"}, "A butterfly", true, false, false));
            questions.add( new QuestionModel("Before Mount Everest was discovered, what was the highest mountain in the world?",
                    new String[]{"K2", "Everest", "Kangchenjunga"}, "Everest", true, false, false));
            questions.add(new QuestionModel("Which of the following do all living things do?",
                    new String[]{"Grow", "Have slumber parties", "Go shopping"}, "Grow", true, false, false));
            questions.add( new QuestionModel("Plants, animals, and ______ are examples of living things?",
                    new String[]{"Trains", "Bugs", "Bottles"}, "Bugs", true, false, false));
            questions.add(new QuestionModel("What colors belong to the rainbow?",
                    new String[]{"Red", "Orange", "Silver"}, new String[]{"Red", "Orange"}, false, false, true));
            questions.add(new QuestionModel("What day of the week comes next after Wednesday?",
                    new String[]{"Monday", "Tuesday", "Thursday"}, "Thursday", true, false, false));
            questions.add(new QuestionModel("Which letter of the English alphabet flies, sings, and stings?", null, "B", false, true, false));
        return questions;
    }
}
