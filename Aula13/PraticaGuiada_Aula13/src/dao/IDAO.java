package dao;

public interface IDAO<T> {

    public T insert(T t);
    public void delete(Integer id);
    public void select(Integer id);
    public void selectAll();

}
