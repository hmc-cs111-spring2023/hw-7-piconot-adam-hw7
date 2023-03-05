package piconot.internal

import picolib._
import picolib.maze._
import picolib.semantics._
import java.io.File

trait PicoOrder

case object Up extends PicoOrder
case object Left extends PicoOrder
case object Right extends PicoOrder
case object Down extends PicoOrder
case class Directive(String : name) extends PicoOrder

case class Detecting(PicoOrder : p1) extends PicoOrder
case class And(PicoOrder : p1, PicoOrder : p2) extends PicoOrder
case class Transitioning(PicoOrder : p1, PicoOrder : p2) extends PicoOrdercase 
case class Via(PicoOrder : p1, PicoOrder : p2) extends PicoOrder