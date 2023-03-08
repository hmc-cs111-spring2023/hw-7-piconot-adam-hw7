package piconot.internal

import picolib._
import picolib.maze._
import picolib.semantics._
import picolib.display.TextDisplay
import java.io.File
import scala.collection.mutable.ListBuffer
import scala.language.implicitConversions

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

given Conversion[Char, Directive] =
    c => Directive(c.toString)

given Conversion[String, Directive] =
    s => Directive(s)

given Conversion[Int, Directive] =
    i => Directive(i.toString)
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
    var outList = ListBuffer.empty[RelativeDescription]
    for (i <- envList) {
        if (i == Up) then ( outList += Open)
        else if (i == NotUp) then (outList += Blocked)
        else (outList+= Anything)

        if (i == Right) then (outList += Open)
        else if (i == NotRight) then (outList += Blocked)
        else (outList+= Anything)

        if (i == Left) then (outList += Open)
        else if (i == NotLeft) then (outList += Blocked) 
        else (outList+= Anything)

        if (i == Down) then (outList += Open)
        else if (i == NotDown) then (outList += Blocked)
        else (outList+= Anything)
    }
    var surroundings = outList.toList
    new RuleBuilder (
      State(directive.name),
      Surroundings(surroundings(0), surroundings(1), surroundings(2), surroundings(3))
    )
  } 



  extension (e1 : Env)
    def via(d1 : Directive) : (Env, State) = (e1, State(d1.name))
    def and(e2: Env) : Env = And(e1, e2) 


  def envToList(env : Env) : List[Env] =  env match {
    case And(e1, e2) => envToList(e1) ++ envToList(e2)
    case _ => List(env)
  }

  class RuleBuilder(val startState: State, val surroundings: Surroundings) {
    val program = PicoRobotic.this
      def Transition(rhs: (Env, State)) = {
        val (moveEnv, nextState) = rhs
        var moveDirection = convertToDirection(moveEnv)
        
        val rule = new Rule(startState, surroundings, moveDirection, nextState)
        program.addRule(rule)
      }
    }
  
    def convertToDirection(moveEnv : Env) = 
        if (moveEnv == Up) then North
        else if (moveEnv == Right) then East
        else if (moveEnv == Left) then West
        else if (moveEnv == Down) then South
        else StayHere

}
