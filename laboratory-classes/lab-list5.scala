// Jakub Czerwinski

// Zadanie 2
def subListL[A] (lxs: LazyList[A]) : LazyList[List[A]] =
  def helper(lys: LazyList[A], n: Int) : LazyList[List[A]] =
    (lys, n) match
      case (LazyList(), _) => LazyList(List())
      case (lh #:: lt, n) => lxs.take(n).toList #:: helper(lt, n + 1)
  helper(lxs, 1);

subListL(LazyList.from(1)).take(3).toList
subListL(LazyList.from(5)).take(5).toList
subListL(LazyList('k', 'u', 'b', 'a')).take(4).toList
subListL(LazyList()).take(3).toList
