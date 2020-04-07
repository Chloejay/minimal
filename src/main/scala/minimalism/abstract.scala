package minimalism 
/**
  * this file is inspired by Category Theory by Bartosz Milewski. 
  * So nothing is mine, just read and note down! 
  */

object composition {
    //F                                                Instance 
    val f: A=>B                                        //val f: Int=> Int                
    val g: B=>C            
    val h: C=>D 
    
    h compose (g compose f) === (h compose g) compose f === h compose g compose f 
}

object identity {
    def id[A](a: A): A = a 
}

object Sum{
    sealed trait Bool
    case object True extends Bool 
    case object False extends Bool 
}
/**
  * println("######################################################################")
  */
trait Monad[M] {
    def combine (m1: M, m2: M)
    def empty: M 
}

object Monad{
    implicit val StringMonad: Monad[String]= new Monad[String] {
        def combine(m1: String, m2: String): String= m1+m2 
        def empty= " "
    }
}
/**
  * println("######################################################################")
  */

object ReaderMonad{
    type writer[A,C]= (A=>C)                            //type writer[A]=(A, String)
}

def >=> [A,B,C](m1:A=> writer[B],m2: B=> writer[C]): A=>writer[C] //fish 

def puer[A](x:A): writer[A]=(x, " ") 
val upCase: String=> writer[String]= s=> (s.toUppercase,"upCase") 


// Cartesian Product<-> RDD Pairs 
def f[A,B]:((A,B))=>B={
    case (x, y)=> x+y 
    case _=> Nil 
}

def ifTrue: Int=> (Int, Boolean) =x => (x, true) 

def p: Int=> Int=x => f(x)  
def q: Int=> Boolean=x => ??? 

def o: T=> (A,B) =x => (p(x), q(x))

def factorize [A,B,C]:(C=>A)=>(C=>B)=>(C=>(A=>B)) = p=>q => x=> (p(x), q(x)) 


// coProduct <-> Sums 
sealed trait contact 
case class Phone (num: Int) extends contact
case class Email (email: String) extends contact

//Instance 
def email: contact= Email("chloejiy@gmail.com") 

// Either[+T] => Some(T) or Nothing 
sealed trait Either [A,B] 
case class Left[A] (v: A) extends Either [A, Nothing] 
case class Right[B] (v: B) extends Either[Nothing, B] 

sealed trait Either[+A, +B]
case class Left[A] (v: A) extends Either [A, Nothing] 
case class Right[B] (v: B) extends Either [Nothing, B] 

//signature for type system
sealed trait T[A,B] 
case class P[A,B] (a: A, b: B) extends T[A,B] 

case class Name[first: String, last: String, age: Int] 
val v: A=> Boolean= e=> e.name startsWith (expr) 

// more Sums 
sealed trait Color 
case object Red extends Color
case object Green extends Color
case object  Blue extends Color 

sealed trait Option[+A] 
case object None extends Option[Nothing] 
case object Some[A] extends Option[A] 

//TO IMPLEMENT 
def option[A] : List[A]=> Option[List[A]]={
    case Nil=> None 
    case const(_, x)=> Some(x) 
}

//TO IMPLEMENT 
sealed trait List[+A]
case object Nil extends List[Nothing] 
case class cons[A] (head: A, tail: List[A]) extends List[A] 

val functor: A=>B 
sealed trait Option[+A] //type constructor -> type argument 
case object None extends Option[Nothing] 
case class Some[A] (a: A) extends Option[A] 

def f[A,B]: Option[A]=> Option[B]={
    case None=> None 
    case Some(x)=> Some(f(x))
}

def f[A,B](f: A=>B): (Option[A]=> Option[B]) 
<-> 
def f[A,B](f: A=>B)(fa: Option[A]): Option[B] //currying 

def Functor[F[_]]{
    def f[A,B](f:A=>B)(fa:F[A]): F[B] 
}





