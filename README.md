# Mercy  [![Build Status](https://travis-ci.org/2202Programming/Mercy.svg?branch=master)](https://travis-ci.org/2202Programming/Mercy)
Collection of Helper functions and other methods to assist in doing almost anything in any language.

In the end, this project will be full of useful little helper functions, each usable by themselves to solve a specific goal or function. Some example topics that could be done in this project would be empty array initializers, event loggers, string formatters, fileIO helpers, web API assessors, frequency generators, and whole bunch of other topics. There is no limit to what you can add to this repo as long as it solves a general problem, not one specific task.

These code files are designed to _help_ people solve a problem, not to solve a problem. Please don't use these files if you are learning to program and it matches your assignment. That defeats the purpose of learning.

## Contributing Guide
All functions that are added are required to be in their own folders, and that folder should have everything the function needs to work, if it is not in the standard library for that language. Each folder should also contain a README that has the author's name, date it was created, a version, what language it was made in, and any other information about the function. If it is a specific algorithm please provide a link to Wikipedia, or some other resource.

All contributions are welcome. This section is mostly a protocol on how we deal with cases where two people want to submit helpers that do a similar function.

If the two helpers have similar enough implementations but can be used to solve different problems, then we can combine them together to make one larger class. If the two functions cannot be combined then the two functions can live side by side in the folder.

For cases when a new function does the same thing as the old one, with no notable improvements to length of code or efficiency, the older function is grandfathered in and the new one will not be accepted.


## Code Style
The general rule for the code style is to follow the accepted style for the language, but as long as the code style is consistent across your file and it contains an appropriate amount of comments it should be fine.

## Pull Requests
Pull Requests are required to add code the master branch. This allows people to be able to assume that everything in master works. Before a pull request can be completed, it must be reviewed by someone else in the repo.

## Directory Format
Files will be added wherever them seem to fit. If There is ever a problem with placement it is up to someone to bring that up in the PR or suggest a change in their own PR.
