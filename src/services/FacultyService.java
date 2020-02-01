package services;

import main.Faculty;
import main.Group;

public class FacultyService {

    public static void initializeGroups(int numberOfGroups, Faculty faculty) {
        faculty.setNumberOfGroups(numberOfGroups);
        Group[] groups;
        groups = new Group[numberOfGroups];
        for (int i = 0; i < numberOfGroups; i++) {
            groups[i] = new Group();
            groups[i].setNumberOfGroup(i + 1);
        }
        faculty.setGroups(groups);
        for (int i = 0; i < numberOfGroups; i++) {
            System.out.print("Please enter the number of students in group " + (i + 1) + ": ");
            GroupService.initializeStudents(InputController.checkForWrongInput("groups"),groups[i]);
        }
    }

    public static double getAveragePointOfStudent(int numberOfGroup,String nameOfStudent,Group[] groups) {
        return GroupService.getAveragePointOfStudent(nameOfStudent,groups[numberOfGroup-1].getStudents());
    }

    public static double getAverageOfConcreteSubjectOfConcreteGroup(int numberOfGroup,String nameOfSubject,
                                                                                      Group[] groups) {
        return GroupService.getAverageOfConcreteSubject(nameOfSubject,groups[numberOfGroup-1].getStudents());
    }

    public static double getAveragePointOfSubjectForFaculty(String nameOfSubject,Group[] groups) {
        double averagePointOfSubjectForFaculty = 0;
        for (int i = 0; i < groups.length; i++) {
            averagePointOfSubjectForFaculty += GroupService.getAverageOfConcreteSubject(nameOfSubject
                                                                                        ,groups[i].getStudents());
        }
        if (checkForNumberOfGroupsTeachingSubject(nameOfSubject,groups) == 0) {
            return 0;
        }

        return averagePointOfSubjectForFaculty/checkForNumberOfGroupsTeachingSubject(nameOfSubject,groups);
    }

    public static int checkForNumberOfGroupsTeachingSubject(String nameOfSubject,Group[] groups) {
        int numberOfGroupsTeachingSubject = 0;

        for (int i = 0; i < groups.length; i++) {
            if (GroupService.checkForStudentsLearningSubject(nameOfSubject,groups[i].getStudents())) {
                numberOfGroupsTeachingSubject++;
            }
        }
        return numberOfGroupsTeachingSubject;
    }
}


