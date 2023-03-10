package piconot.internal

// 
/////// THIS EXAMPLE CODE USES STRICTLY FULL DIRECTIVE DEFINITIONS 
//

// A Picobot program that can fill an empty room
object EmptyPicoRobot extends PicoRobotic("resources/empty.txt") {

  // States 0 and 1: move to the top left

//   // State 0: move left
//   (0 `**x*`) → W(0) // go all the way to the left
//   (0 `**W*`) → X(1) // can't go left anymore, so try to go up
  Detecting(Left)(Directive("0")) Transition (Left via Directive("0"))
  Detecting(NotLeft)(Directive("0")) Transition (Stay via Directive("1"))

//   // State 1: move up
//   (1 `x***`) → N(1) // go all the way to the top
//   (1 `N**x`) → S(2) // can't go up any more, so try to go down
  Detecting(Up)(Directive("1")) Transition (Up via Directive("1"))
  Detecting(NotUp and Down)(Directive("1")) Transition (Down via Directive("2"))

//   // States 2 and 3: fill from top to bottom, left to right

//   // State 2: fill this column to the bottom
//   (2 `***x`) → S(2) // go all the way to the bottom
//   (2 `*x*S`) → E(3) // can't go down anymore, so try to go right
  Detecting(Down)(Directive("2")) Transition (Down via Directive("2"))
  Detecting(NotDown and Right)(Directive("2")) Transition (Right via Directive("3"))

//   // State 3: fill this column to the top
//   (3 `x***`) → N(3) // go all the way to the top
//   (3 `Nx**`) → E(2) // can't go up anymore, so try to go right
  Detecting(Up)(Directive("3")) Transition (Up via Directive("3"))
  Detecting(NotUp and Right)(Directive("3")) Transition (Right via Directive("2"))

  engage
}