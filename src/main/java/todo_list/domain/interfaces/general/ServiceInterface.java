package todo_list.domain.interfaces.general;

public interface ServiceInterface<TInput, TReturn> {
    TReturn execute(TInput input) throws Exception;
}
