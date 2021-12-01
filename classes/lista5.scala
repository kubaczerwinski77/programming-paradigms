// Jakub Czerwinski

// Zadanie 1a
def lrepeat[A](k: Int)(lxs: LazyList[A]): LazyList[A] =
  def lhelper(counter: Int, elem: A, tail: LazyList[A]): LazyList[A] =
    if counter > 1 then elem #:: lhelper(counter - 1, elem, tail)
    else lrepeat(k)(tail)
  
  lxs match
    case LazyList() => LazyList()
    case lh #:: lt => lh #:: lhelper(k, lh, lt)

lrepeat(3)(LazyList('a', 'b', 'c', 'd')).toList == List('a', 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c', 'd', 'd', 'd')
lrepeat(3)(LazyList.from(1)).take(15).toList == List(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5)
lrepeat(3)(LazyList()).take(15).toList == List()

// Zadanie 2
def lfib =
  def lhelper(prev: BigInt, next: BigInt): LazyList[BigInt] =
    prev #:: lhelper(next, prev + next)
  lhelper(0, 1)

lfib.take(10).toList == List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34)
lfib.take(0).toList == List()

// Zadanie 3