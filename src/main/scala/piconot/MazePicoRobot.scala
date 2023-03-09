package piconot.internal
// 
/////// THIS EXAMPLE CODE USES STRICTLY DIRECTIVE FROM CHAR/INT CONVERSIONS
//

// A Picobot program that can fill an maze room
object MazePicoRobot extends PicoRobotic("resources/maze.txt") {
// # State 0: moving north
// 0 *x** -> E 1    # we can turn right
Detecting(Right)('0') Transition (Right via '1')
// 0 xE** -> N 0
Detecting(NotRight and Up)('0') Transition (Up via '0')
// 0 NE** -> X 3
Detecting(NotUp and NotRight)('0') Transition (Stay via '3')

// # State 1: moving east
// 1 ***x -> S 3    # we can turn right!
Detecting(Down)(1) Transition (Down via 3)
// 1 *x*S -> E 1
Detecting(Right and NotDown)(1) Transition (Right via 1)
// 1 *ExS -> X 2
Detecting(NotRight and Left and NotDown)(1) Transition (Stay via 2)

// # State 2: moving west
// 2 x*** -> N 0    # we can turn right!
Detecting(Up)(2) Transition (Up via 0)
// 2 N*x* -> W 2
Detecting(NotUp and Left)(2) Transition (Left via 2)
// 2 NxW* -> X 1
Detecting(NotUp and Right and NotLeft)(2) Transition (Stay via 1)

// # State 3: moving south
// 3 **x* -> W 2    # we can turn right!
Detecting(Left)(3) Transition (Left via 2)
// 3 **Wx -> S 3
Detecting(NotLeft and Down)(3) Transition (Down via 3)
// 3 x*WS -> X 0
Detecting(Up and NotLeft and NotDown)(3) Transition (Stay via 0)

  engage
}
