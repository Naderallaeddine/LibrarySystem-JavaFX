package utils;

import controller.AddStudentController;
import controller.StatisticsController;

public interface LibraryVisitor {
    void visit(AddStudentController controller);
    void visit(StatisticsController controller);
}