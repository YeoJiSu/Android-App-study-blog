import java.lang.Integer.max
import java.util.*

private val EMPTY = 0 // 빈공간은 0
private val WALL = 1 // 벽은 1
private val VIRUS = 2 // 바이러스는 2

// 탐색할 (x,y)의 이동을 나타낸 것 ex) (0,1),(0,-1),(1,0),(-1,0)
private val dx = intArrayOf(0, 0, 1, -1)
private val dy = intArrayOf(1, -1, 0, 0)

private var N = 0 // 입력 받을 변수 N - 0으로 초기화
private var M = 0 // 입력 받을 변수 M - 0으로 초기화
private var map = Array(N) { IntArray(M) } // 입력 받을 이차원 배열 map
class Virus(var x: Int, var y: Int) // Virus 위치 좌표 (x,y)
private val virusList = ArrayList<Virus>() // Virus 위치 좌표 (x,y) 들의 list
private var maxSafeArea = 0 // 안전 영역의 최대 크기


fun main() {
    // 입력 받기
    val input = readLine()?.split(" ")
    N = input?.get(0)?.toInt()!! // !!을 붙여서 not null 임을 명시
    M = input?.get(1)?.toInt()!! // !!을 붙여서 not null 임을 명시

    // 2차원 배열의 map 초기화하기 - 코틀린 이차원 배열 선언은 신기방기...
    map = Array(N ) { IntArray(M ) }
    // 입력 받아서 2차원 배열 안에 넣기
    for (i in 0..N-1) {
        var my_ln = readLine()!!.split(" ")
        for (j in 0..M-1) {
            // map 안에 값 넣고
            map[i][j] = my_ln[j].toInt()
            // 그 값이 VIROUS 라면 바이러스 리스트에 추가해줌.
            if (map[i][j] == VIRUS) {
                virusList.add(Virus(i, j))
            }
        }
    }
    searchEmpty(0)
    println(maxSafeArea)
}

fun searchEmpty(count: Int) {
    // 벽 세개 설치하는 걸 다 했다면
    if (count == 3) {

        // map을 복사한 copy_map 만들기
        val copy_map = Array(N) { IntArray(M) }
        for (i in 0..N-1) {
            for (j in 0..M-1) {
                copy_map[i][j] = map[i][j]
            }
        }
        // 바이러스 퍼뜨리고,
        for (virus in virusList) {
            spreadVirus(virus, copy_map)
        }
        // 다 퍼뜨린다음, 0 개수 세기
        countSafeArea(copy_map)
        return
    }
    // 아직 벽 3개 설치하는 걸 다 안했다면
    for (i in 0..N-1) {
        for (j in 0..M-1) {
            if (map[i][j] == EMPTY) {
                // 벽 설치하고 다음 부분 탐색
                map[i][j] = WALL
                searchEmpty(count + 1)
                // 다음 search를 위해 다시 원상복구.
                map[i][j] = EMPTY
                /*-> 이렇게 기존 map 은 원래 상태를 유지하고 있어야 해서
                나머지 함수에서 copy_map 으로 문제를 풀었음.
                 */
            }
        }
    }
}


fun spreadVirus(virus: Virus, copy_map: Array<IntArray>) {
    val queue: Queue<Virus> = LinkedList() // Virus 형 큐 선언 - 링크드 리스트로
    queue.add(virus) // queue에 기존 바이러스 좌표 추가
    while (!queue.isEmpty()) { // queue가 빌 때까지
        // queue의 첫번째 값을 참조하여 x, y에 저장
        val x = queue.peek().x
        val y = queue.peek().y

        // 좌우상하로 퍼트리는 코드
        for (i in 0..3) {
            val new_x = x + dx[i]
            val new_y = y + dy[i]
            // index가 범위를 벗어나면 안됨.
            if (new_x < 0 || new_x >= N || new_y < 0 || new_y >= M)
                continue
            // 빈공간이면 바이러스로 바꿔줌.
            if (copy_map[new_x][new_y] == EMPTY) {
                copy_map[new_x][new_y] = VIRUS
                // queue에 새 바이러스 좌표 추가하기
                queue.add(Virus(new_x, new_y))
            }
        }
        queue.remove()
    }
}

fun countSafeArea(copy_map: Array<IntArray>) {
    var count = 0
    for (i in 0..N-1) {
        for (j in 0..M-1) {
            // EMPTY인 것들을 센다
            if (copy_map[i][j] == EMPTY) {
                count++
            }
        }
    }
    // 둘 중 더 큰 값을 넣음.
    maxSafeArea = max(maxSafeArea,count)
}

/*

7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0

4 6
0 0 0 0 0 0
1 0 0 0 0 2
1 1 1 0 0 2
0 0 0 0 0 2

8 8
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
2 0 0 0 0 0 0 2
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0

*/
