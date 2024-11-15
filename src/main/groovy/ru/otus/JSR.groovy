import groovy.transform.ToString

def evalStr = '"foo".toUpperCase()'

//println Eval.me(System.getProperty("EVAL_STR"))

@ToString
class X {
    String str = "Hello to all my friends from Russia"
}

def object = new X()
println Eval.me('x',
        object.getStr(),
        System.getProperty("EVAL_STR"))



def x = 1
def y = 2
def z = 3

def expression = "x+y+z+x"

Binding b = new Binding()
b.setVariable("x", x)
b.setVariable("y", y)
b.setVariable("z", z)
GroovyShell sh = new GroovyShell(b)
println sh.evaluate(expression)






b = new Binding()
b.setVariable("x", 5)
b.setVariable("object", object)
sh = new GroovyShell(b)
println sh.evaluate(new File("/home/bva/IdeaProjects/bpm/src/main/resources/factorial.groovy"))



b.setProperty('date', new Date())
b.setProperty('text', "some info text")
sh.evaluate('println("log INFO $date $text")')


b = new Binding()
sh = new GroovyShell(b)

//b.setProperty('foo', null)
sh.evaluate("foo=123")
println b.getProperty('foo')



def b1 = new Binding(x:3)
def b2 = new Binding(x:0)
sh = new GroovyShell()

def script = sh.parse("x = 2*x")

script.setBinding(b1)
println script.run()

script.setBinding(b2)
println script.run()

