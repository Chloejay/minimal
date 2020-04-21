package minimalism.cats

import cats._ 

/**
  * https://arosien.github.io/cats-cheatsheets/typeclasses.pdf as refs. 
  */


object CatsSignatures{
    // Functor F[A] => (A=>B) => F[B]  
    def functor[A](fa: A=> F[A])(v: A=>B): F[B] 

    def contravariant[A,B](fa: A=>F[A])(v: B=>A): F[B] 

    def apply[A,B](fa: A=>F[A])(v: F[A]=>F[B]): F[B] 
 
    def map[A, B](fa: F[A])(f: A => B): F[B]

    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B] 
    
    def traverse [A,B, G] (fa: F[A])(v: A=> G[B]) : G[F[B]] 

    // def coFlatMap[A,B](v: F[A]=>B): F[B] 

    // Foldable F[A] => (B, (B, A) => B) => B

    // SemigroupK F[A] => F[A] => F[A]

    // Cartesian F[A] => F[B] => F[(A, B)] 

    // flatTraverse :: G[A] => (A => F[G[B]]) => F[G[B]]
}