package piconot.internal

import picolib._
import picolib.maze._
import picolib.semantics._
import picolib.display.TextDisplay
import java.io.File
import scala.collection.mutable.ListBuffer

trait Directive

trait Env

case object Up extends Env
case object Left extends Env
case object Right extends Env
case object Down extends Env 
case object NotUp extends Env
case object NotLeft extends Env
case object NotRight extends Env
case object NotDown extends Env
case class Directive(name : String) extends Directive
case class And(p1 : Env, p2 : Env) extends Env

// case class Detecting(p1 : State ) extends PicoOrder
// case class Transitioning(initial : PicoOrder, result : PicoOrder) extends PicoOrder
case class Via(direction : Env, directive : Directive) extends PicoOrder

/** @author
  *   Adam
  */
class PicoRobotic(val mazeFilename: String) extends App {
    private val rules = ListBuffer.empty[Rule]

  def addRule(rule: Rule) = rules += rule

  def run = {
    val maze = Maze(mazeFilename)
    object bot extends Picobot(maze, rules.toList) with TextDisplay
    bot.run()
  }

  def Detecting(environment: Env)(directive: Directive) : RuleBuilder = {
    val envList = envToList(environment)
    var outlist = List(Anything, Anything, Anything, Anything)
    for (i <- envlist) {
        if (i == Up) then outList[0] = Blocked
        if i == NotUp then outList[0] = Open
            
    }
    new RuleBuilder (
      State(directive),
      Surroundings(outList[0], Blocked, Open, Anything)
    )
  } 
    
  def envToList(env : Env) : List[Env] = env match 
    case And(e1, e2) => envToList(e1) ++ envToList(e2)
    case _ => List(env)

  class RuleBuilder(val startState: Env, val surroundings: Surroundings) {
    val program = PicoRobotic.this
    def Transition(rhs: (MoveDirection, Env)) = {
    //   val (moveDirection, nextState) = rhs
    //   val rule = new Rule(startState, surroundings, moveDirection, nextState)
    //   program.addRule(rule)
    }
}
