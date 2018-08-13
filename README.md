# sql-datafeed-tests
The main goal of this project is to show how to feed tests with sqls.

# manual
Suppose we have test class `path/CustomerRepositoryTest`:

1. add sqls to `test/resources/path`
1. annotate methods in `CustomerRepositoryTest`:
    * `@Sql(value = "xxx.sql")` - because default `executionPhase` is 
    `Sql.ExecutionPhase.BEFORE_TEST_METHOD`
    * `@Sql(value = "xxx.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)`
    
_Remark_: it is possible to annotate whole class with `@Sql` - it's especially valuable for 
clearing database before each test method (script will be fired before each method):
```
@Sql(value = "delete_all_customers.sql")
class CustomerRepositoryTest {
```

# tests
**Coverage**: `70%`