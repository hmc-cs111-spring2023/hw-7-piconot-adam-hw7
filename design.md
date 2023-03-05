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

Once detected, the result is the transition (maybe navigate or Move? whats a roboty word for move). It states a direction to move and what Directive to continue with. This uses the word "via" which I like because (1) its short and (2) its very intuitive. You are moving in a direction under a new set of rules. 

Engage is then the method of starting this code at a specific state. State can be any string cause why not. Also maybe Detecting Right Left, means that *you are free to move to the right and the left)* rather then there are blocks there. Might be a bit more intuitive? 


## Who is the target for this design, e.g., are you assuming any knowledge on the part of the language users?

The target for this design is me. Im only partially joking. The target is students learning the course using picobot would be my main target. (One) they need it the most, and (two) because CS5 frosh are the most invested in the idea of *picobot* and the three eyed alien thematically. 

## Why did you choose this design, i.e., why did you think it would be a good idea for users to express the maze-searching computation using this syntax?

 I think the main goal is to give *Picobot* a voice, a robotic voice, but a voice none the less. I want using this language to feel like giving one of those mine diffusing robots commands rather then the current very obtuse but condensed code. 

## What behaviors are easier to express in your design than in Picobot’s original design?  If there are no such behaviors, why not?

I think overall the behaviors are mostly the same amount of easy. Functionally all the componenets of Picobot's original command line is identical. However, I think this version is a little more intuitive and promotes State based coding *better* then the original. Not only is it easier to parse but (personally) its a lot more intuitve to think of States as something your detecting, rather then just detecting closed spaces. *SOOOOO* Hopefully this language is easier to learn with. 

## What behaviors are more difficult to express in your design than in Picobot’s original design? If there are no such behaviors, why not?

I think actual efficient programing is much harder. This version of the code encourages treating it as basically a bunch of if else statements cycling through all the possible version of the "state of existance" which isnt efficient. The original code encourages organization by state. While unintutitive, leads to less unnecessary code. Or not unneccessary but more concise solutions. 

## On a scale of 1–10 (where 10 is “very different”), how different is your syntax from PicoBot’s original design?

3-5. The actually writing of it, and some of the intuition is different, but its effectively the same in the fact you write (state, environment, direction, new state) encoded in text for both. So I would say moderately different, but nothing groundbreaking. 


## Is there anything you would improve about your design?

I feel like "transition" . Even beyond that, I think there would be ways to make it "more robotic" Unlike the pirate example from class I feel like I fail to execute on the theme alittle. 
Outside of that, I really struggled to break away from "picobot code but with words instead of intuited syntax order." So I would like to figure some of that out.  
