// Jakub Czerwinski

// Zadanie 1
def revNComp[A] (f : A => A)(n : Int)(x : A) =
  def revNCompIter[A] (f : A => A)(n : Int)(x : A): List[A] =
    if n <= 0 then Nil
    else if n == 1 then List(x)
    else x :: revNCompIter(f)(n - 1)(f(x))
  (revNCompIter(f)(n)(x)).reverse

revNComp ((x: Int) => 2 * x)(10)(2)
revNComp ((x: String) => x + x)(3)("Kuba")
revNComp ((x: Int) => x * x)(-2)(5)
revNComp ((x: Double) => 3 * x)(1)(5)

// Zadanie 2
def area (tup : (Double, Double))(f : (Double => Double))(n : Int) =
  val arr = List.range(1, n)
  val arr1 = arr map (x => x * (tup._2 - tup._1) / n)
  val arr2 = arr1 map (x => f(x))
  val arr3 = arr2 map (x => x * (tup._2 - tup._1) / n)
  (arr3 foldRight 0.0)((sum, x) => sum + x)

area (0, 1)(x => x)(1000)
area (0, 2)(x => x)(1000)
area (0, 3.1415)(x => math.sin(x))(1000)