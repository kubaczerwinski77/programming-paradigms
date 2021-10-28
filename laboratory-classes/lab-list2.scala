// Jakub Czerwinski

// Zadanie 1
def find[A] (xs : List[A])(x : A) : Boolean =
  xs match {
    case List() => false
    case h :: t if h == x => true
    case _ :: t => find(t)(x)
  }

find(List(1, 2, 3))(1)
find(List())(2)
find(List(2, 3, 4))(1)
val find123 = find(List(1, 2, 3))
find123(3)
find123(5)
find(List(2.0, 2.0, 2.0))(3.0)

// Zadanie 2
def split2Rec[A] (xs : List[A]) : ((List[A], List[A])) =
  xs match {
    case List() => (List(), List())
    case List(x) => (List(), List(x))
    case h1 :: h2 :: t =>
      val (left, right) = split2Rec(t);
      (h1 :: left, h2 :: right)
    }

split2Rec(List())
split2Rec(List(1, 2, 3, 4))
split2Rec(List(1, 2, 3))
split2Rec(List(1))
split2Rec(List("Ala", "ma", "kota"))

def split2Tail[A] (xs : List[A]) : (List[A], List[A]) =
  def splitIter(xs : List[A], alist : List[A], blist : List[A], n : Int) : (List[A], List[A]) =
    if xs == List() then (alist, blist)
    else {
      if n % 2 == 0 then splitIter(xs.tail, xs.head :: alist, blist, n + 1)
      else splitIter(xs.tail, alist, xs.head :: blist, n + 1)
    }
  splitIter(xs, List(), List(), 0)

split2Tail(List())
split2Tail(List(1, 2, 3, 4))
split2Tail(List(1, 2, 3))
split2Tail(List(1))
split2Tail(List("Ala", "ma", "kota"))