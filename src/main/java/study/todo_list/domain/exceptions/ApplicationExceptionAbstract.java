package study.todo_list.domain.exceptions;

import study.todo_list.domain.enums.ProblemDetailTypeEnum;

public abstract class ApplicationExceptionAbstract extends Exception {
    abstract ProblemDetailTypeEnum getProblemDetailType();

    public ApplicationExceptionAbstract(String message) {
        super(message);
    }
}
