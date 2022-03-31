Neste ficheiro readme serão feitas as respostas ao exercício 1 do lab 3 de TQS.

a) Identify a couple of examples on the use of AssertJ expressive methods chaining.

There are a lot of examples of the use of AssertJ, for example:

    On A_EmployeeRepositoryTest.java, in the method givenSetOfEmployees_whenFindAll_thenReturnAllEmployees():

        assertThat(allEmployees).hasSize(3).extracting(Employee::getName).containsOnly(alex.getName(), ron.getName(), bob.getName());

    On D_EmployeeRestControllerIT.java, in the method whenValidInput_thenCreateEmployee():

        assertThat(found).extracting(Employee::getName).containsOnly("bob");


b) Identify an example in which you mock the behavior of the repository (and avoid involving a database).

In C_EmployeeController_WithMockServiceIT:

    when( service.save(Mockito.any()) ).thenReturn( alex);


c) What is the difference between standard @Mock and @MockBean?

@Mock is used when making unit tests in business logic (only using JUnit and Mockito).

@MockBean i used when we write a test that is backed by a Spring Test Context and we want to add or replace a bean with a mocked version.


d) What is the role of the file “application-integrationtest.properties”? In which conditions will it be used?

This file has the specifications (properties) to connect to a database that can be used during tests.


e) the sample project demonstrates three test strategies to assess an API (C, D and E) developed with SpringBoot.Which are the main/key differences?

The C and D examples use the MockMvc to communicate with the MVC application, while the E example uses a RestTemplate. 
C and D examples use direct communication, while E uses a RestTemplate which also simulates processes like serialization used in an actual communication with a REST API. 
The MockMvc strips those processes away and focuses only on invoking the controller's endpoints.