package minimalism 
//Note: trait no constructor parameter 
// log in Foo and Bar is an abstract method 
// Main Container then extends all traits and implement log. 

class Container (val log: String=> Unit) extends sub1 with sub2
// new Container(System.out.println).func() 
// new Container(System.err.println).func() 

// def f(msg: String, log: String=> Unit)= log(msg) 
// f("halo", System.out.println) 
// f("gut", System.out.println) 
// ...

// make it implicit to avoid write the same methods multiple times for instances 
// def f(msg: String)(implicit log: String=> Unit)= log(msg)
// implicit val logger: String=> Unit = System.out.println
// 
// f("halo")
// f("gut")
// 
// def add(x: Int, y: Int, c: (Int, Int)=> Int)= c(x,y) 
// def f(a:Int, b: Int): Int= (a+b)
// add(1,2,f) 
// add(1,3,f)
// add(2,3,f)
// add(3,5,f)
 

// def add(x: Int, y: Int)(implicit c: (Int, Int)=> Int)= c(x, y) 
// implicit val c: (a: Int, b: Int)=> Int= a+b
// 
// add(1,2)
// add(2,3)