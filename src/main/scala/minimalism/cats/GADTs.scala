package minimalism.cats
//ADT 
// sealed trait Expr
// case class IntExpr(i: Int) extends Expr 
// case class BooleanExpr(i: Boolean) extends Expr 
// case class StringExpr (i : String) extends Expr 

//GADT 
sealed trait Expr[T] 
case class IntExpr(i: Int) extends Expr[Int] 
case class Boolean(i: Boolean) extends Expr[Boolean] 
case class StringExpr(i: String) extends Expr[String] 

object GADT{
  def main(args:Array[String]){
    def eval[T](e: Expr[T]): T = e match{
    case IntExpr(i) => i
    case Boolean(i) => i 
    case StringExpr(i) => i 
   }
}
}

