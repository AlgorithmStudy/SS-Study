package 백준

import kotlin.math.abs

private lateinit var arr:IntArray
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    arr.sort()
    var answer=Int.MAX_VALUE
    var (answer1,answer2)= arrayOf(0,0)
    (0 until n).forEach { i ->
        var (left, right) = arrayOf(i+1, n - 1)
        while (left <= right) {
            val mid = (left + right) / 2
            val sum=arr[i]+arr[mid]
            when {
                abs(sum)<answer -> {
                    answer1=arr[i]
                    answer2=arr[mid]
                    answer=abs(sum)
                }
            }
            when {
                sum<0 -> {
                    left=mid+1
                }
                else -> right=mid-1
            }
        }
    }
    println("$answer1 $answer2")
}