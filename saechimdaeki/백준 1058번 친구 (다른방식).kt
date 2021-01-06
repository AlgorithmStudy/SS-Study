fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val arr=Array(n){IntArray(n)}
    val strings= arrayListOf<String>()
    repeat(n){
        strings.add(br.readLine())
    }
    (0 until n).forEach { k ->
        (0 until n).forEach { i ->
            loop@ for(j in 0 until n){
                when (i) {
                    j -> continue@loop
                }
                when {
                    strings[k][j]=='Y' && strings[i][k]=='Y' || strings[i][j]=='Y' -> arr[i][j]=1
                }
            }
        }
    }
    println((0 until n).map { arr[it].sum() }.max())
}