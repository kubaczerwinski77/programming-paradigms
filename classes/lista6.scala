// Jakub Czerwinski

// Zadanie 1
// def whileLoop(condition: =>Boolean)(expression: =>Unit): Unit =
val whileLoop: (=>Boolean) => (=>Unit) => Unit = condition => expression =>
  if condition then
    expression
    whileLoop(condition)(expression)

var i = 0
whileLoop(i < 3) {
  print(s"$i ")
  i += 1
}
println()

// Zadanie 2
// a) swap
// def swap (tab: Array[Int])(i: Int)(j: Int) =
val swap: Array[Int] => Int => Int => Unit = tab => i => j =>
  val aux = tab(i)
  tab(i) = tab(j)
  tab(j) = aux

// b) partition
// def partition (tab: Array[Int])(l: Int)(r: Int): (Int, Int)=
val partition: Array[Int] => Int => Int => (Int, Int) = tab => l => r =>
  var i = l
  var j = r
  val pivot = tab((l + r) / 2)
  while i < j do
    while tab(i) < pivot do
      i += 1
    while pivot < tab(j) do
      j -= 1
    if i <= j then
      swap(tab)(i)(j)
      i += 1
      j -= 1
  (i, j)

// def quick (tab: Array[Int])(l: Int)(r: Int): Unit =
val quick: Array[Int] => Int => Int => Unit = tab => l => r =>
  if l < r then
    val (i, j) = partition(tab)(l)(r)
    if j - 1 < i - 1
      then 
        quick(tab)(l)(j)
        quick(tab)(i)(r)
    else
        quick(tab)(i)(r)
        quick(tab)(l)(j)
  else ()

// def quickSort (tab: Array[Int]): Unit =
val quickSort: Array[Int] => Unit = tab =>
  quick(tab)(0)(tab.length - 1)

val arr1 = Array(5, 2, 1, 4, 3)
val arr2 = Array(1, 2, 3, 4, 5)
val arr3 = Array(1, -1)
val arr4 = Array[Int]()
quickSort(arr1)
quickSort(arr2)
quickSort(arr3)
quickSort(arr4)
arr1.toList == Array(1, 2, 3, 4, 5).toList
arr2.toList == Array(1, 2, 3, 4, 5).toList
arr3.toList == Array(-1, 1).toList
arr4.toList == Array[Int]().toList
