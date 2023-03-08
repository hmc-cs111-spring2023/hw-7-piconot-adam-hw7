# Evaluation: running commentary

## Internal DSL

_Describe each change from your ideal syntax to the syntax you implemented, and
describe_ why _you made the change._

First Change, added a state for every direction and every not direction instead of making it a seperate keyword. I could make `Not` as single input function like `and` but honestly since there are only 4 options, typing `NotUp` (ie just adding Not Directly) is easy to implement and 1 less character then `not Up`. So I think it works out just as well. 

In addition, I made 1 REALLY BIG CHANGE to directions. Specifically swapping the meaning of ``Detecting` a direction. Instead of `Detecting(Up)` implying there is a wall upwards, it instead implies *it is safe to go up*. So `Detecting(NotUp)` means that there is a wall north now. I just found this more intuitive. And that also means that 

I couldnt get rid of *every* parenthesis required to type it. In fact there are quite alot.  But their exactly 3 key locations you need it.  Detecting has two input, the surroundings and the initial state. Then the *via* call needs one to make sure its applied in the right order. Once I added the implicit conversions from int/string/char to Directive, the code ends up being very easy to write. I wrote Maze Robot without copy pasting, and the ability to just type `0` is very nice. 
However, If you used the full directive call: `Directive("State")` rather then the auto conversion it becomes longer and alittle harder to parse but I think clearer with intent. 

There is a version of this where Detecting takes 1 input with a comma. I think thats two *computery*. Idk, I think haveing the code `(Up and NotLeft, Directive("1"))` is very ugly even compared to `(Up and NotLeft)(Directive("1"))` which I think is a littttle prettier. (Could be convinced though) 

In addition, the two line combo that I wanted isnt really possible. Specifically `Transition` connecting the two distinct lines. So now every setup has to have one line with everything. There may be a way around this (well to require it) by having an identical member function with the newline character `/n`. In the end this was a systems required change. 




**On a scale of 1–10 (where 10 is "a lot"), how much did you have to change your syntax?**

**On a scale of 1–10 (where 10 is "very difficult"), how difficult was it to map your syntax to the provided API?**

## External DSL

_Describe each change from your ideal syntax to the syntax you implemented, and
describe_ why _you made the change._

**On a scale of 1–10 (where 10 is "a lot"), how much did you have to change your syntax?**

**On a scale of 1–10 (where 10 is "very difficult"), how difficult was it to map your syntax to the provided API?**
