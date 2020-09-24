# User Guide

## Features 

## Adding tasks to the list

Tasks to be done can be added to the list.
Tasks include todo, event and deadline.

## Show all tasks in list

Tasks in the list can be shown.

## Mark tasks as done.

Completed tasks can be marked as done.

## Removing tasks from list

Unwanted tasks can be removed from the list.

## Find task in list

Tasks in the list can be searched for by using keywords.

## Save / Load tasks in list

Data entered into the program will automatically be saved upon exit.
Previously stored data will be loaded into the program upon startup.

## Help

A list of all the commands will be shown.

### Usage

## 'todo' - Adds a todo task into the list

A todo task containing a description will be added to the list

Example of usage:

todo buy grocery

Expected outcome:

    ____________________________________________________________
     Got it. I've added this task:
       [T][✘] buy grocery
     Now you have 1 task in the list.
    ____________________________________________________________


## 'event' - Adds an event into the list

An event task containing a description and location will be added to the list

Example of usage:

event lunch /at Grandma's house

Expected outcome:

    ____________________________________________________________
     Got it. I've added this task:
       [E][✘] lunch (at: Grandma's house)
     Now you have 2 tasks in the list.
    ____________________________________________________________


Note: keyword '/at' needs to be included

## 'deadline' - Adds a deadline task to the list

A deadline task containing a description and a date due will be added to the list

Example of usage:

deadline project /by next mon

Expected outcome:

    ____________________________________________________________
     Got it. I've added this task:
       [D][✘] project (by: next mon)
     Now you have 3 tasks in the list.
    ____________________________________________________________


Note: keyword '/by' needs to be included

## 'list' - shows all the tasks in the list

A list of tasks along with their descriptions and status will be shown

Example of usage:

list

Expected outcome:

    ____________________________________________________________
     Here are the tasks in your list:
     1. [T][✘] buy grocery
     2. [E][✘] lunch (at: Grandma's house)
     3. [D][✘] project (by: next mon)
    ____________________________________________________________


## 'done' - marks a completed task as done

A specified task in the list will be marked as done.

Example of usage:

done 2

Expected outcome:

    ____________________________________________________________
     Nice! I've marked this task as done!
      [E][✓] lunch (at: Grandma's house)
    ____________________________________________________________


Note: task number should be specified and within the range of total number of tasks.

## 'delete' - deletes a task in the list

An unwanted task in the list will be removed

Example of usage:

delete 3

Expected outcome:

    ____________________________________________________________
     Noted. I've removed this task:
      [D][✘] project (by: next mon)
     Now you have 2 tasks in the list.
    ____________________________________________________________


Note: task number should be specified and within the range of total number of tasks.

## 'find' - looks for a task in the list

Locates task(s) containing the keyword(s) entered in the query

Example of usage:

find Grandma

Expected outcome:

    ____________________________________________________________
     Here are the matching tasks in your list:
     1. [E][✓] lunch (at: Grandma's house)
    ____________________________________________________________


Note: the keyword maybe be found in either the description or the additional information of the task

## 'help' - a list of all availiable commands will be shown

Example of usage:

help

Expected outcome:

    ____________________________________________________________
     Here are the commands available in Duke:
     todo    : adds a todo task to the list
     eg. todo do homework
     event   : adds an event task to the list
     eg. event lunch with cousins \at NEX
     deadline: adds a deadline task to the list
     eg. deadline iP \by wed
     done    : marks a task in the list as done
     eg. done 1
     delete  : deletes a task in the list
     eg. delete 3
     find    : looks for the keyword in the list
     eg. find lunch
     list    : lists out all the tasks in the list
     eg list
     bye     : exits the program
     eg. bye
    ____________________________________________________________


