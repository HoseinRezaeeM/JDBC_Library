CREATE TABLE book
(
    bookId serial,
    authorId  int
        references author (authorid),
    title     varchar(50),
    printYear varchar(50)
)