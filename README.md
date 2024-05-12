# LibraryManagementSystem

packages :-
  1- com.LibraryManagementSystem :- There is  inside it main method.
  2- com.LibraryManagementSystem.DTO :-Inside it, there is a collection  of classes that are used to send data to entity.
  3- com.LibraryManagementSystem.Entity:-Inside it, there is a collection  of classes that are used for inputting data to service.
  4- com.LibraryManagementSystem.Service:-Inside it, there is a collection  of classes containing methods used for sending and retrieving data from the database.
  5- com.LibraryManagementSystem.Repository:-Inside it, there is a collection  of interfaces responsible for connecting the application to the database.
  6- com.LibraryManagementSystem.controllers:-Inside it, there is a collection  of classes that organize the requests  and responses.
  7- com.LibraryManagementSystem.Exception:-Inside it, there is a collection  of classes that organize the exception .
  8- com.LibraryManagementSystem.mapper:- Inside it is an interface that performs conversions from DTO to entity and vice versa.
  9-com.LibraryManagementSystem.Security:-Inside it, there is a collection  of classes that organize the authentication and authorization.
classes:-
   > Books_DTO_Request
   > BorrowingRecord_DTO_Request
   > Patrons_DTO_Request
   > Users_DTO_Request
       Inside them, there is a collection of methods including setters and getters for data.

   > Books
   > BorrowingRecord
   > Patrons
         They are used to configure the table in the database.

   > PatronService
   > BorrowingService
   > BookService
          Inside them, there is a collection of methods used for sending and retrieving data from the database.
   Get/api/books
        return all books 
   Get/api/books/{id}
        return one book id ={id}
   Post/api/books 
      insert new book
   put/api/books
       edite books information
   Delete/api/books/{id}
        delete one book id={id}

   Get/api/patrons
        return all patrons
   Get/api/patrons/{id}
        return one patron id ={id}
   Post/api/patrons 
      insert new patron
   put/api/patrons
       edite patrons information
   Delete/api/patrons/{id}
        delete one patron id={id}

   post/api/borrow/{bookid}/patron/{patronid}
         allow a patron to borrow a book 
   put/api/return/{bookid}/patron/{patronid}
          allow a patron to return a book 
