// Jakub Czerwiński

// Zadanie 3
sealed trait BT[+A]
  case object Empty extends BT[Nothing]
  case class Node[+A](value: A, left: BT[A], right: BT[A]) extends BT[A]

val tt = Node(1, Node(2, Node(4, Empty, Empty), Empty), Node(3, Node(5, Empty, Node(6, Empty, Empty)), Empty))

def breadthBT[A](tree: BT[A]) =
  def bfs(queue: List[BT[A]])(result: List[A]) : List[A] =
    queue match
      case Nil => result
      case h::t =>
        h match
          case Empty => bfs(t)(result)
          case Node(v, l, r) => bfs(t ::: List(l, r))(v::result)
  (bfs(List(tree))(Nil)).reverse

breadthBT(tt)

// Zadanie 4
def internalPathLen[A](tree: BT[A]) =
  def internalIter(n: BT[A])(result: Int)(depth: Int) : Int =
    n match
      case Empty => result
      case Node(v, l, r) => internalIter (l) (internalIter (r) (result + depth) (depth + 1)) (depth + 1)
  internalIter (tree)(0)(0)

internalPathLen(tt)

def externalPathLen[A](tree: BT[A]) =
  def externalIter(n: BT[A])(result: Int)(depth: Int) : Int =
    n match
      case Empty => result + depth
      case Node(v, l, r) => externalIter (l) (externalIter (r) (result) (depth + 1)) (depth + 1)
  externalIter(tree)(0)(0)

externalPathLen(tt)

// Zadanie 5
sealed trait Graphs[A]
  case class Graph[A](succ: A => List[A]) extends Graphs[A]

val g = Graph((i: Int) =>
  i match
    case 0 => List(3)
    case 1 => List(0, 2, 4)
    case 2 => List(1)
    case 3 => Nil
    case 4 => List(0, 2)
    case n => throw new Exception("Graph g: node $n doesn't exist")
)

def depthSearch[A](graph: Graph[A])(vertex: A) =
  def dfs(visited: List[A])(result: List[A]) : List[A] =
    visited match
      case Nil => result
      case h::t =>
        (result contains h) match
          case true => dfs (t)(result)
          case false => dfs ((graph succ h) ::: t)(h::result)
  (dfs(List(vertex))(Nil)).reverse

depthSearch(g)(4)