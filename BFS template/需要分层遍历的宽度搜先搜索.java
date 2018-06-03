// T 指代任何你希望存储的类型
Queue<T> queue = new LinkedList<>();
Set<T> set = new HashSet<>();

set.add(start);
queue.offer(start);
while (!queue.isEmpty()) {
    int size = queue.size();
    //这里你可以在每个for结束之后做一些其他的跟分层有关的事比如每一层遍历完打印一个“|”，在不分层的方法中就无法判断什么时候一层结束。
    //因此虽然最后的结果都是一样的，但是分层的方法我们能知道每层确切的遍历结束时刻。
    for (int i = 0; i < size; i++) {
        T head = queue.poll();
        for (T neighbor : head.neighbors) {
            if (!set.contains(neighbor)) {
                set.add(neighbor);
                queue.offer(neighbor);
            }
        }
    }
}


上述代码中：

size = queue.size() 是一个必须的步骤。
如果在 for 循环中使用 for (int i = 0; i < queue.size(); i++) 会出错，因为 queue.size() 是一个动态变化的值。
所以必须先把当前层一共有多少个节点存在局部变量 size 中，才不会把下一层的节点也在当前层进行扩展。

