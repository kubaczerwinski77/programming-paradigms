// Jakub Czerwinski

// Zadanie 1
class Rectangle(val a: Double, val b: Double):
  def this(a: Double) = this(a, a)
  def area: Double = a * b

val r1 = new Rectangle(2, 3.5)
val r2 = new Rectangle(4)
val r3 = new Rectangle(2.2)
val r4 = new Rectangle(-0.01, -0.1)

r1.area
r2.area
r3.area
r4.area

// Zadanie 2
class EmptyStringException extends Exception
class NotAnAdultException extends Exception

class Handyman(protected var name: String, protected var surname: String, protected var age: Int):
  require(name != "", throw new EmptyStringException())
  require(surname != "", throw new EmptyStringException())
  require(age >= 18, throw new NotAnAdultException())

  override def toString = s"name: ${name}; surname: ${surname}; age: ${age}"

val h = new Handyman("Jakub", "Czerwinski", 20)

trait Electrician:
  import Electrician.counter
  counter += 1
  def fixElectricity = println("Your elecricity has been fixed!")
  def countElectricians = println(s"There are ${counter} electricians all over the world.")

object Electrician:
  private var counter = 0

trait BrickLayer:
  import BrickLayer.counter
  counter += 1
  def buildWall = println("Your wall has beed built!")
  def countBrickLayers = println(s"There are ${counter} bricklayers all over the world.")

object BrickLayer:
  private var counter = 0

trait Plumber:
  import Plumber.counter
  counter += 1
  def floodApartment = println("There is water everywhere!")
  def countPlumbers = println(s"There are ${counter} plumbers all over the world.")

object Plumber:
  private var counter = 0

object Test:
  def main(args: Array[String]): Unit =
    try
      new Handyman("Jakub", "Czerwinski", 20)
      // new Handyman("", "Czerwinski", 20)
      // new Handyman("Jakub", "", 20)
      // new Handyman("Jakub", "Czerwinski", 10)
      println("Handyman has joined the lobby.")
    catch
      case e: EmptyStringException => println("Name or surname cannot be an empty string!")
      case e: NotAnAdultException => println("The age of Handyman cannot be below 18 yo!")
      case _: Throwable => println("Any other exception, error in implementation!")
    
    println("\nFIRST HANDYMAN")
    val h1 = new Handyman("Jakub", "Czerwinski", 20) with Electrician with Plumber
    h1.fixElectricity
    h1.floodApartment
    h1.countElectricians
    h1.countPlumbers

    println("\nSECOND HANDYMAN")
    val h2 = new Handyman("Andrzej", "Czerwinski", 47) with Electrician
    h2.countElectricians

    println("\nTHIRD HANDYMAN")
    val h3 = new Handyman("Jan", "Czerwinski", 74) with Electrician with Plumber with BrickLayer
    h3.fixElectricity
    h3.floodApartment
    h3.buildWall
    h3.countElectricians
    h3.countPlumbers
    h3.countBrickLayers
