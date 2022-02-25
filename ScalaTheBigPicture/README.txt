3 Functional Programming concepts

- expression, returns a value (x + y)
- statement, does some action => print("Hello world")

functions:
- pure 
  - product a*b
  - square a^2
  - division a/b
  
- impure
 - debit(60)
 - making network calls
 - updating the database
 - writing to file system
 
High order functions
(a,b) => a*b
- map
- filter
- reduce
- fold


4 First interaction with scala

Variables
- var
- val (constant)

var day = "Monday"

no explicit returns

Loops
- while
- for

for
- imperative
- functional


5 Functions

- anonymous functions (aka Function Literals) unnamed, they are only used once!
- higher-order functions


6 Classes

members
- fields
- methods

https://github.com/hhimanshu/scala-the-big-picture

Companion objects
- singleton (only 1 instance in memory)


7 Null checks and error handling

Option
- Some (value)
- None


Option
- get
- getOrElse (aka default value)


Try
- Success (value)
- Failure (error)

Either
- For example Either[String, Int]
- Left (something) represents the absence of a value
- Right (value) represents the value of the computation


8 Pattern matching


9 Collections
- mutable
- immutable

Iterable
- sequence
- set
- map




