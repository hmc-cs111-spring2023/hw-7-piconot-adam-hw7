# Design
-- Internal Language -- 

Lets make "Picobot" more robotic (in a thematic way). My design for this is to use robotic language but not make it feel like a programming language 

Here is an example of what that could look like:
```
Engage Directive A:

Detecting Right Left Directive A
Transition Up via Directive A

Detect Up Left Directive B
Transitioning Right via Directive B
```
This language is based on Detecting a "state of existance" which is not just the available locations to move but also the current directive. 

In this language "states" are defined by "Directives." Intuitionally, this version of the syntax makes each directive (state) something that needs to be detected just like the blocks around the Picobot. 

Once detected, the result is the transition (maybe navigate or Move? whats a roboty word for move). It states a direction to move and what Directive to continue with. 

Engage is then the method of starting this code at a specific state. State can be any string cause why not. 


## Who is the target for this design, e.g., are you assuming any knowledge on the part of the language users?

## Why did you choose this design, i.e., why did you think it would be a good idea for users to express the maze-searching computation using this syntax?

## What behaviors are easier to express in your design than in Picobot’s original design?  If there are no such behaviors, why not?

## What behaviors are more difficult to express in your design than in Picobot’s original design? If there are no such behaviors, why not?

## On a scale of 1–10 (where 10 is “very different”), how different is your syntax from PicoBot’s original design?

## Is there anything you would improve about your design?
