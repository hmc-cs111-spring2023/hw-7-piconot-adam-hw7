# Evaluation: running commentary

## Internal DSL

_Describe each change from your ideal syntax to the syntax you implemented, and
describe_ why _you made the change._

First Change, added a state for every direction and every not direction instead of making it a seperate keyword. I could make `Not` as single input function like `and` but 
Personally, This `Up, NotUp` is alittle less intuitive because `Detecting Up` isnt clear that that means Up is blocked. I considered changing it to "NotUp" means that its empty in the north direction, -- but that comes with a lit of other problems. 

I couldnt get rid of *every* parenthesis required to type it. In fact there are quite alot.  But their exactly 3 key locations you need it.  Detecting has two input, the surroundings and the initial state. Then the *via* call needs one to make sure its applied in the right order. I think this is reasonable. If you used the full directive call: `Directive("String")` rather then the string to directive auto conversion it becomes longer but I think clearer. 

There is a version of this where Detecting takes 1 input with a comma. I think thats two *computery*. Idk, I think haveing the code `(Up and NotLeft, Directive("1"))` is very ugly even compared to `(Up and NotLeft)(Directive("1"))` which I think is a littttle prettier. 

In addition, the two line combo that I wanted isnt really possible. Specifically `Transition` connecting the two distinct lines. So now every setup has to have one line with everything. There may be a way around this (well to require it) by having an identical member function with the newline character `/n`



**On a scale of 1–10 (where 10 is "a lot"), how much did you have to change your syntax?**

**On a scale of 1–10 (where 10 is "very difficult"), how difficult was it to map your syntax to the provided API?**

## External DSL

_Describe each change from your ideal syntax to the syntax you implemented, and
describe_ why _you made the change._

**On a scale of 1–10 (where 10 is "a lot"), how much did you have to change your syntax?**

**On a scale of 1–10 (where 10 is "very difficult"), how difficult was it to map your syntax to the provided API?**
