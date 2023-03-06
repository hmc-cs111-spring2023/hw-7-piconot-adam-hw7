package piconot.internal

import picolib._
import picolib.maze._
import picolib.semantics._
import java.io.File

trait PicoOrder

trait State

case object Up extends State
case object Left extends State
case object Right extends State
case object Down extends State 
case object NotUp extends State
case object NotLeft extends State
case object NotRight extends State
case object NotDown extends State
case class Directive(name : String) extends State
case class And(p1 : State, p2 : State) extends State


case class Detecting(p1 : State ) extends PicoOrder
case class Transitioning(initial : PicoOrder, result : PicoOrder) extends PicoOrder
case class Via(direction : State, directive : State) extends PicoOrder

def engage(orders : List[PicoOrder], directive: String) : Unit = {
    var rules = List()
    for(order <- orders) {
        rules += convertToRule(order)
    }
}

def convertToRule(order : PicoOrder) : Rule = {

}