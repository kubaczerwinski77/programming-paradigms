// Jakub Czerwinski

// Zadanie 1a
sealed trait tree3[+A]
  case object Empty extends tree3[Nothing]
  case class Node[+A](v: A, left: tree3[A], middle: tree3[A], right: tree3[A]) extends tree3[A]

val t = Node(1, Node(2, Empty, Empty, Empty), Node(3, Node(4, Empty, Empty, Empty), Empty, Empty), Empty)
val tt = Node(1, Empty, Empty, Empty)
val ttt = Empty

// Zadanie 1b
def mapTree3[A, B](f: A => B)(tree: tree3[A]) : tree3[B] =
  tree match
    case Empty => Empty
    case Node(v, l, m, r) => Node(f)(mapTree3(f)(l), mapTree3(f)(m), mapTree3(f)(l))


mapTree3((n: Int) => n)(t)
mapTree3((n: Int) => (n + 1))(tt)
mapTree3((n: Int) => (n - 10))(ttt)

// Zadanie 2a
// sealed trait word
  case class Word(first: Char, other: String)
sealed trait typeOfSentence
  case object Affirmative extends typeOfSentence
  case object Question extends typeOfSentence
  case object Exclamation extends typeOfSentence
// sealed trait sentence
  case class Sentence(word: Word, wordList: List[Word], typeOf: typeOfSentence)
// sealed trait text
  case class Text(sentence: Sentence, sentenceList: List[Sentence])