package study.todo_list.domain.exceptions;

import study.todo_list.domain.enums.ProblemDetailTypeEnum;

public class NotFoundException extends ApplicationExceptionAbstract {
    public ProblemDetailTypeEnum getProblemDetailType() {
        return ProblemDetailTypeEnum.NOT_FOUND;
    }

    public NotFoundException(String message) {
        super(message);
    }
}
