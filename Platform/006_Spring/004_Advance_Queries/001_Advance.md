<table width="100%">
    <tr>
        <td><a href="./../003_Spring_Data_II/011_DojoOverflow.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./002_Joins.md">Next</a></td>
    </tr>
</table>

#

#   Advanced Queries
The CrudRepository mainly provides us an interface to execute CRUD operations onto a specific entity. However, many times we want to execute complex queries that the repository does not support. In this tab, we are going to learn about JPA's Query language and native queries. We will be using the same database from the One-to-Many relationships lesson in Springs Data II.

<img src="./../../000_img/onetomany.png">

##  __JPA Query Language (JPQL)__
JPQL is the object-oriented version of SQL in JPA. The query strings may look a little different but they have a lot of similarities with plain SQL. For example, this is how you would write several select queries.

### __repositories/DojoRepository.java__
```java
// ...
public interface DojoRepository extends CrudRepository<Dojo, Long>{
    List<Dojo> findAll();
    
    // get all dojos
    @Query("SELECT d FROM Dojo d")
    List<Dojo> findAllDojos();
    
    // get all the names of the dojos
    @Query("SELECT d.name FROM Dojo d")
    List<String> findAllDojosNames();
    
    // passing params and filtering (still retrieves a list)
    @Query("SELECT d FROM Dojo d WHERE id = ?1")
    List<Dojo> getDojoWhereId(Long id);
    
    // passing params and filtering
    @Query("SELECT d FROM Dojo d WHERE id = ?1")
    Dojo getSingleDojoWhereId(Long id);
}
```
## __Modifying Queries__
If we want to update or delete, we must use a @Modifying Annotation to indicate that we are changing the values in our database.

### __repositories/DojoRepository.java__
```java
// ...
public interface DojoRepository extends CrudRepository<Dojo, Long>{
    //...
    // previous methods removed for brevity
    //...
    
    // Note the int type. It is because it returns the number of rows affected
    @Modifying
    @Query("update Dojo d set d.name = ?1 WHERE d.id = ?2")
    int setNameForOne(String name, Long id);
    
    @Modifying
    @Query("update Dojo d set d.name = ?1")
    int setNameForAll(String name);
    
    @Modifying
    @Query("delete Dojo d WHERE d.id = ?1")
    int deleteOneDojo(Long id);
}
```
## __Native Queries__
JPA also supports native queries. This way, you can write any query in raw SQL.
```java
// ...
public interface DojoRepository extends CrudRepository<Dojo, Long>{
    //...
    // previous methods removed for brevity
    //...
    
    // Select all, we get a list of Dojo objects back.
    @Query(value="SELECT * FROM dojos", nativeQuery=true)
    List<Dojo> findAllDojosWithNativeQuery();
    
    // get all the names of the dojos with id. If we want to select specific columns, we will get a list of Object arrays because they are no longer Dojo objects. Each index of the array will be the column selected respectively. Therefore 0 = id column, 1 = name column
    @Query(value="SELECT id, name FROM dojos", nativeQuery=true)
    List<Object[]> findAllDojosNamesWithId2();
    
    // get one dojo
    @Query(value="SELECT * FROM dojos WHERE id = ?1", nativeQuery=true)
    Dojo getDojoWhereId(Long id);
}
```
To unpack the data from the `findAllDojoNamesWithId2` method, you would have to run something similar to this in your service:
```
// ...
List<Object[]> dojos = dojoRepo.findAllDojosNamesWithId2();
Object[] dojo = dojos.get(0);
Object dojoId = dojo[0];
Object dojoName = dojo[1];
```
### __Useful Links__
*   [CrudRepository](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html)
*   [JpaRepository](http://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html)
*   [JPQL](http://www.objectdb.com/java/jpa/query)


#

[]()
<table width="100%">
    <tr>
        <td><a href="./../003_Spring_Data_II/011_DojoOverflow.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./002_Joins.md">Next</a></td>
    </tr>
</table>