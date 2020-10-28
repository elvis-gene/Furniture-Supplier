/*
    Coder: Elvis Gene
    Description: Repository interface extended by specific class repositories.
    Date:
 */

package com.furnitureapp.repository;
@Deprecated
public interface IRepository<T, ID> {

    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
}
