package utils;

import controller.AddStudentController;
import controller.StatisticsController;

public class NewFeatureVisitor implements LibraryVisitor {
    @Override
    public void visit(AddStudentController controller) {
        // code for visiting AddBookController
    }

    @Override
    public void visit(StatisticsController controller) {
        // code for visiting BookStatisticsController
    }
}

