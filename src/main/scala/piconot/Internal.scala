package piconot.internal

import picolib._
import picolib.maze._
import picolib.semantics._
import picolib.display.TextDisplay
import java.io.File
import scala.collection.mutable.ListBuffer

trait Dir

trait Env

case object Up extends Env
case object Left extends Env
case object Right extends Env
case object Down extends Env 
case object NotUp extends Env
case object NotLeft extends Env
case object NotRight extends Env
case object NotDown extends Env
case object Stay extends Env
case class Directive(name : String) extends Dir
case class And(p1 : Env, p2 : Env) extends Env

// case class Detecting(p1 : State ) extends PicoOrder
// case class Transitioning(initial : PicoOrder, result : PicoOrder) extends PicoOrder
// case class Via(direction : Env, directive : Directive) extends PicoOrder

/** @author
  *   Adam
  */
class PicoRobotic(val mazeFilename: String) extends App {
  private val rules = ListBuffer.empty[Rule]

  def addRule(rule: Rule) = rules += rule

  def engage = {
    val maze = Maze(mazeFilename)
    object bot extends Picobot(maze, rules.toList) with TextDisplay
    bot.run()
  }

  def Detecting(environment: Env)(directive: Directive) : RuleBuilder = {
    val envList = envToList(environment)
    var outList = List(Anything, Anything, Anything, Anything)
    for (i <- envList) {
        if (i == Up) then (outList(0) = Blocked)
        if (i == NotUp) then (outList(0) = Open)
        if (i == Down) then (outList(3) = Blocked)
        if (i == NotDown) then (outList(3) = Open)
        if (i == Left) then (outList(2) = Blocked)
        if (i == NotLeft) then (outList(2) = Open)    
        if (i == Right) then (outList(1) = Blocked)
        if (i == NotRight) then (outList(1) = Open)
    }
    new RuleBuilder (
      State(directive.name),
      Surroundings(outList(0), outList(1), outList(2), outList(3))
    )
  } 

  extension (e1 : Env)
    def via(d1 : Directive) : (Env, State) = (e1, State(d1.name))


  def envToList(env : Env) : List[Env] =  env match {
    case And(e1, e2) => envToList(e1) ++ envToList(e2)
    case _ => List(env)
  }

  class RuleBuilder(val startState: State, val surroundings: Surroundings) {
    val program = PicoRobotic.this
      def Transition(rhs: (Env, State)) = {
        var moveDirection = StayHere
        val (moveEnv, nextState) = rhs
        
        if (moveEnv == Up) then (moveDirection = North)
        if (moveEnv == Right) then (moveDirection = East)
        if (moveEnv == Left) then (moveDirection = West)
        if (moveEnv == Down) then (moveDirection = South)
        
        val rule = new Rule(startState, surroundings, moveDirection, nextState)
        program.addRule(rule)
      }
    }
}
