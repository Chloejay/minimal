package minimalism 

trait Foo{
    def log: String=> Unit 

    def func() = func2(log) 
    def func2()= func3(log)
}