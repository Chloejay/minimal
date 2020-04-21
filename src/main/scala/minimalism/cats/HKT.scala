package minimalism.cats

import cats.Monad
import cats.syntax.functor._ // map
import cats.syntax.flatMap._ // flatMap
import scala.language.higherKinds
import cats.instances.list._ // Monad
import cats.instances.option._ 

/* type of type */
object Higher_kind_type{
  def sum[F[_]: Monad](a: F[Int], b: F[Int]): F[Int] = 
    for {
      x<- a
      y<- b
    } 
      yield (x * y) 
}

object HKT{
    def main(args: Array[String]){
        import Higher_kind_type._   
        val result  = Higher_kind_type.sum(List(1,2), List(2,3)) 
        val result2 = Higher_kind_type.sum(Option(2), Option(4)) 
        print(result) 
        print(result2)
    }
}