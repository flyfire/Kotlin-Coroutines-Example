package compare

/**
 * Created by houruhou on 2018/12/12.
 * Desc:
 */
fun main(args: Array<String>) {
    TestCompare().test()
}

class TestCompare {
    fun test() {
        val str = "solarex"

        val letResult = str.let {
            println("let----------")
            println(this)
            println(it)
            println("let----------")
            0
        }

        val runResult = str.run {
            println("run-------")
            println(this)
//            println(it)
            println("run-------")
            1
        }

        val run0Result = run {
            println("run0000000000")
            println(this)
//            println(it)
            println("run0000000000")
            2
        }

        val withResult = with(str) {
            println("with---------")
            println(this)
//            println(it)
            println("with---------")
            3
        }

        val applyResult = str.apply {
            println("apply------------")
            println(this)
//            println(it)
            println("apply------------")
            5
        }
        val alsoResult = str.also {
            println("also----------")
            println(this)
            println(it)
            println("also----------")
            6
        }
        println("let = $letResult,run = $runResult, run0 = $run0Result, with = $withResult, apply = $applyResult, also = $alsoResult")
    }
}