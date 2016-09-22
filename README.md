# Mercy
Collection of Helper functions and other methods to assist in doing almost anything in any language.

This project in the end will be full of useful little helper functions each useable by themselves to solve a specific goal or functions. Some example topics that could be done in this project, would be empty array initializers, event loggers, string formatters, fileIO helpers, web API assessors, frequency generators, and whole bunch of other topics, their is no limit to what you can add to this repo as long as it solves a general problem, not one specific task.

This code files are designed to help people solve a problem, not solve a problem. Please don't use these files if you are learning to program, and it matches your assignment, that defeats the purpose of learning.

## Contributing Guide
All contributions are welcome, this section is mostly a protocol on how we deal with cases where two people want to submit helpers that do a similar function.

If the two helpers have similar enough implementations, but can be used to solve different problems then we can combine them together to make one larger class. If the two functions cannot be combined then the two functions can live side by side in the folder.

For cases when a new function does the same thing as the old one with no notable improvements to length of code or efficiency. Then the older function is grandfathered in, and the new one will not be accepted.

## Code Style
The general rule for the code style is to follow the accepted style for the language, but as long as the code style is consistent across your file and it contains an appropriate amount of comments.

## Pull Requests
Pull Requests are required to add code the master branch, this allows people to be able to assume that everything in master works. Before a pull request can be completed it must be reviewed by someone else in the repo.

## Directory Format

Root
|--language
  |--topic
    |--code file
|--java
  |--fileIO
    |--basicIO.java
    |--duelLaneIO.java
  |--searching
    |--bubbleSort.java
|--csharp
  |--fileIO
    |--EventLogger.cs
