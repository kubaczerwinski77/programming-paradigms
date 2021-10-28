// Jakub Czerwinski

// Zadanie 2
def fib (n : Int) : Int =
  if (n < 0) then throw new Exception("Negative argument")
  else {
    if (n == 0) then 0
    else {
      if n <= 2 then 1
      else (fib(n - 1) + fib(n - 2))
    }
  }

// fib(-3)
fib(0) == 0
fib(3) == 2
fib(8) == 21
// fib(42)

def fibTail(n : Int) : Int = 
  if n < 0 then throw new Exception("Negative argument")
  else if n == 0 then 0
  else {
    def fibIter(n : Int, prev : Int, next : Int) : Int =
      if n <= 2 then next
      else fibIter(n - 1, next, prev + next)
    fibIter(n, 1, 1)  
  }

fibTail(0) == 0
fibTail(3) == 2
fibTail(8) == 21
fibTail(42) == 267914296

// Zadanie 3
def root3 (a : Double) : Double = 
  def root3Iter(a : Double, x : Double, eps : Double)  : Double =
    if math.abs(math.pow(x, 3) - a) <= eps * math.abs(a) then x
    else root3Iter(a, x + ((a / (x * x)) - x) / 3, eps)
  if a > 1 then root3Iter(a, a / 3, 1e-15)
  else root3Iter(a, a, 1e-15)

root3(64) == 4
root3(-64) == -4
root3(1) == 1
root3(0) == 0
math.abs(root3(43) - 3.503398060386724170614333) <= 1e-15 * math.abs(43)

// Zadanie 4
// val List(_, _, x, _, _) = List(-2, -1, 0, 1, 2)
val List((_, _), (x, _)) = List((1, 2), (0, 1))

// Zadanie 5
def initSegment[A] (xs : List[A], ys : List[A]) : Boolean =
  (xs, ys) match {
    case (List(), _) => true
    case (_, List()) => false
    case (hx :: tx, hy :: ty) =>
      if hx == hy then initSegment(tx, ty)
      else false
  }

initSegment(List(1, 2, 3), List(1, 2, 3, 4, 5)) == true
initSegment(List(1, 2, 3), List(1, 2)) == false
initSegment(List(), List(1, 2, 3)) == true
initSegment(List(1, 2, 3), List()) == false

// Zadanie 6a
def replaceNth[A] (xs : List[A], n : Int, x : A) : List[A] =
  if n < 0 then throw new Exception("Negative argument")
  else
    (xs, n, x) match {
      case (List(), _, _) => throw new Exception("Invalid argument")
      case (h :: t, 0, _) => x :: t
      case (h :: t, _, _) => h :: replaceNth(t, n - 1, x)
    }

replaceNth(List('o', 'l', 'a'), 1, 's') == List('o', 's', 'a')
replaceNth(List(1, 1, 1), 2, 5) == List(1, 1, 5)
// replaceNth(List(1, 1, 1), 3, 5)
// replaceNth(List(1, 1, 1), -1, 5)
// replaceNth(List(), 1, 1)