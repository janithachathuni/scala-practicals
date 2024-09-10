class Rational(n: Int, d: Int){
    require(d != 0, "Denominator cannot be zero")

    private val g = gcd(n.abs, d.abs)
    val numer: Int = n / g
    val denom: Int = d / g

    def sub(that: Rational): Rational = {
        val newNumer = this.numer * that.denom - that.numer * this.denom
        val newDenom = this.denom * that.denom
        new Rational(newNumer, newDenom)
    }

    def neg: Rational = new Rational(-numer, denom)

    override def toString: String = {
        if (denom == 1) numer.toString
        else numer + "/" + denom
    }

    private def gcd(a: Int, b: Int): Int = {
        if (b == 0) a else gcd(b, a % b)
    }
}

object Main extends App {
    //x = 3/4, y = 5/8, z = 2/7
    val x = new Rational(3, 4)
    val y = new Rational(5, 8)
    val z = new Rational(2, 7)

    val result = y.sub(z)
    val finalResult = x.sub(result)

    println(s"x = $x")
    println(s"y = $y")
    println(s"z = $z")
    println(s"y - z = $result")
    println(s"x - (y - z) = $finalResult")
}
