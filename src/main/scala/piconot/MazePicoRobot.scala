package piconot.internal
// 
/////// THIS EXAMPLE CODE USES STRICTLY DIRECTIVE FROM CHAR/INT CONVERSIONS
//

// A Picobot program that can fill an maze room
object MazePicoRobot extends PicoRobotic("maze/empty.txt") {
// # State 0: moving north
// 0 *x** -> E 1    # we can turn right
Detecting(Right)('0') Transition (Right via '1')
// 0 xE** -> N 0
Detecting(NotRight and Up)('0') Transition (Up via '0')
// 0 NE** -> X 3
Detecting(NotUp and NotRight)('0') Transition (Stay via '3')

// # State 1: moving east
// 1 ***x -> S 3    # we can turn right!
Detecting(Down)(0) Transition (Down via 3)
// 1 *x*S -> E 1
// 1 *ExS -> X 2


// # State 2: moving west
// 2 x*** -> N 0    # we can turn right!
// 2 N*x* -> W 2
// 2 NxW* -> X 1

// # State 3: moving south
// 3 **x* -> W 2    # we can turn right!
// 3 **Wx -> S 3
// 3 x*WS -> X 0

  engage
}
