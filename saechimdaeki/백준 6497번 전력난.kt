package 백준

private lateinit var parent:IntArray
private var arr= mutableListOf<Triple<Int,Int,Int>>()
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    while (true) {
        var totalsum=0
        val (m, n) = br.readLine().split(" ").map { it.toInt() }
        if(m==0 && n==0)
            break
        parent = IntArray(m+1){it}
        arr.clear()
        repeat(n) {
            val (x, y, z) = br.readLine().split(" ").map { it.toInt() }
            arr.add(Triple(x, y, z))
            totalsum+=z
        }
        //arr = arr.sortedWith(compareBy { it.third }).toMutableList()
        arr.sortWith(compareBy { it.third })
        var mst = 0
        for (i in 0 until n) {
            val tmp = arr[i]
            if (find(tmp.first) != find(tmp.second)) {
                mst += tmp.third
                union(tmp.first, tmp.second)
            }
        }
        bw.write("${totalsum-mst}\n")
    }
    bw.flush()
}
private fun find(x:Int):Int{
    return when (x) {
        parent[x] -> x
        else -> {
            parent[x] = find(parent[x])
            parent[x]
        }
    }
}
private fun union(x:Int,y:Int){
    val (px,py)= intArrayOf(find(x),find(y))
    when {
        px<py -> parent[py]=px
        else -> parent[px]=py
    }
}