// Jakub Czerwiński

// Zadanie 2
def curry3[A, B, C, D] (f:(A, B, C) => D)(x:A)(y:B)(z:C) = f(x, y, z)
def curry3L[A, B, C, D] (f:(A, B, C) => D) : A => B => C => D = x => y => z => f(x, y, z)

def uncurry3[A, B, C, D] (f:A => B => C => D)(x:A, y:B, z:C) = f(x)(y)(z)
def uncurry3L[A, B, C, D] (f:A => B => C => D) : (A, B, C) => D = (x, y, z) => f(x)(y)(z)

def plus (x:Int)(y:Int)(z:Int) : Int = x + y + z
def add (x:Int, y:Int, z:Int) : Int = x + y + z

curry3(add)(1)(2)(3)
curry3L(add)(1)(2)(3)

uncurry3(plus)(1, 2, 3)
uncurry3L(plus)(1, 2, 3)

// Zadanie 3
def mySumProd(xs:List[Int]) =
  xs.foldLeft (0, 1) ((t: (Int, Int), x: Int) => (t._1 + x, t._2 * x))

mySumProd(List(1, 2, 3, 4))
mySumProd(List(0, 1, 2, 3))
mySumProd(List(-1, -2, -3, -4))

// Zadanie 5
// a)
def insertionSort[A](pred: (A, A) => Boolean)(xs: List[A]) : List[A] =
  def insert(pred: (A, A) => Boolean)(x: A)(xs: List[A]) : List[A] =
    xs match
      case Nil => List(x)
      case h::t =>
        if pred(x, h) then x::h::t
        else h::insert(pred)(x)(t)

  xs match
    case Nil => Nil
    case h::t => insert(pred)(h)(insertionSort (pred)(t))

insertionSort ((x: Int, y: Int) => x <= y)(List(5, 2, 1, 4, 3))
insertionSort ((x: (Int, _), y: (Int, _)) => x._1 <= y._1)(List((5, 1), (2, 1), (5, 2), (4, 1), (2, 2)))
insertionSort ((x: (Int, _), y: (Int, _)) => x._1 >= y._1)(List((5, 1), (2, 1), (5, 2), (4, 1), (2, 2)))

// b)
def mergeSort[A](pred: (A, A) => Boolean)(xs: List[A]) : List[A] =
  def halve(xs: List[A]) : (List[A], List[A]) =
    def halveHelper(n: Int)(ys: List[A]) : (List[A], List[A]) =
      if n == 0 then (Nil, ys)
      else ys match
        case Nil => (Nil, Nil)
        case h::t =>
          val (left, right) = halveHelper(n - 1)(t)
          (h::left, right)
    halveHelper(xs.length / 2)(xs)
  
  def merge(pred: (A, A) => Boolean)(xs: List[A])(ys: List[A]) : List[A]=
    (xs, ys) match
      case (Nil, list) => list
      case (list, Nil) => list
      case (hx::tx, hy::ty) =>
        if pred(hx, hy) then hx::merge(pred)(tx)(ys)
        else hy::merge(pred)(xs)(ty)
  
  xs match
    case Nil => Nil
    case List(x) => List(x)
    case h::t =>
      val (left, right) = halve(h::t)
      merge(pred)(mergeSort(pred)(left))(mergeSort(pred)(right))

mergeSort ((x: Int, y: Int) => x <= y)(List(5, 2, 1, 4, 3))
mergeSort ((x: (Int, _), y: (Int, _)) => x._1 <= y._1)(List((5, 1), (2, 1), (5, 2), (4, 1), (2, 2)))
mergeSort ((x: (Int, _), y: (Int, _)) => x._1 >= y._1)(List((5, 1), (2, 1), (5, 2), (4, 1), (2, 2)))
