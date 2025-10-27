package todo_list.domain.exceptions;

import todo_list.domain.enums.ProblemDetailTypeEnum;

public abstract class ApplicationRuntimeExceptionAbstract extends RuntimeException {
    abstract ProblemDetailTypeEnum getProblemDetailType();

    public ApplicationRuntimeExceptionAbstract(String message) {
        super(message);
    }
}
