package minimalism.cats

import cats.implicits._ 
import cats.Monoid
import cats.Functor


object TestMonoid_Cats {
  import cats.instances.string._ 
  import cats.instances.int._ 
  import cats.instances.option._ 
  import cats.instances.tuple._ 
  import cats.syntax.semigroup._ // |+|

  //simple instance of Monoid 
  def combine(a: Int, b:Int): Int= a |+| b
  val zero= Monoid[Int].empty 
  val opt= Option(1) |+| Option(2) 
  val hi = "Hi " |+| Monoid[String].empty 

  //generic type T 
  def addAll[T](v: List[T])(implicit monoid: Monoid[T]): T =
    v.foldRight(monoid.empty)(_ |+| _)
}

object Functor_Cats{
  import cats.instances.function._ // Functor
  import cats.syntax.functor._ // map 

  val a= List(1,2,3).
  map(n=>n*n).
  map(n=> n+10)

  val fmt: (Int=> Double)= (v: Int) => v.toDouble 
  val add: (Double => Double) = (v: Double) => v+v
   
  val result = (fmt map add)(10) 

  //simple map for functor 
  def func_pow[F[_]](v: F[Int])
  (implicit functor: Functor[F]): F[Int]= v.map(a => a*a) 

  val pow = func_pow(List(1,2,3)) 
  }

object Main{
  import TestMonoid_Cats._
  import Functor_Cats._

  def main(args: Array[String]) {
  val sum= combine(1,2)
  val addSum= addAll(List(1,2)) 
  val addStr= addAll(List("play", "monoid!")) 
  //monoid 
  println(s"Monoid sum of combine $sum, addAll $addSum, $addStr!")
  //functor 
  println(s"$a, $result, $pow") 
  }
}